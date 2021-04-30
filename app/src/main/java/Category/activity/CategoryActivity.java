package Category.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.R;
import java.io.File;

import Category.data.CategoryData;
import Category.data.CategoryResponse;
import Cookie.SaveSharedPreference;
import network.RetrofitClient;
import network.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    //private AutoCompleteTextView mEmailView;
    // private EditText mEmailView;
    private Button catBtn;
    private ImageView imgView;
    private ServiceApi service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String id= (SaveSharedPreference.getString(getApplicationContext(), "ID"));

        Intent intent = getIntent(); /*데이터 수신*/
        String imgName = intent.getExtras().getString("imgName"); /*String형*/
        String imgPath= intent.getExtras().getString("imgFile"); /*String형*/
        File imgFile = new  File(imgPath);

        catBtn= (Button) findViewById(R.id.catBtn);
        service = RetrofitClient.getClient().create(ServiceApi.class);

        if(imgFile.exists()){
            Log.d("file_", String.valueOf(imgFile));
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ImageView myImage = (ImageView) findViewById(R.id.imageView);
            myImage.setImageBitmap(myBitmap);
        }

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCategory(new CategoryData(id, imgName));
            }
        });
    }

    private void startCategory(CategoryData data) {
        service.findCategory(data).enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                CategoryResponse result = response.body();
                if(response.body() != null) {
                    result = response.body();
                }
                else{
                    Log.v("알림", "값이 없습니다.");
                }
                // Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), result.getMessage(), Toast.LENGTH_SHORT).show();

                //값 가져오는 거 성공하면 사용자가 예상한 결과값과 같은 지 확인하기
                if(result.getCode()==200){
                    Toast.makeText(getApplicationContext(), "category: "+result.getCategoryResult(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "카테고리 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("카테고리 에러 발생", t.getMessage());
            }
        });
    }
}
