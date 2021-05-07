package Category.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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
import Category.data.SaveCategoryData;
import Category.data.SaveCategoryResponse;
import Cookie.SaveSharedPreference;
import network.RetrofitClient;
import network.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    //private AutoCompleteTextView mEmailView;
    // private EditText mEmailView;
    private Activity activity;
    private Button catBtn;
    private ImageView imgView;
    private ServiceApi service;
    private int msgCode=-1;
    private String category="";
    AlertDialog.Builder alertdialog; // 다이얼로그 바디
    private final String[] words=new String[] {"상의", "하의", "아우터", "원피스", "악세서리"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        activity=this;

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

        // 다이얼로그 바디
        alertdialog = new AlertDialog.Builder(activity);
        // 다이얼로그 메세지
        //alertdialog.setMessage("기본 다이얼로그 입니다.");

        // 확인버튼
        alertdialog.setPositiveButton("예", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "'예'버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                startSaveCategory(new SaveCategoryData(id, imgName, category));
            }
        });

        // 취소버튼
        alertdialog.setNegativeButton("아니요", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "'아니요'버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCategory(new CategoryData(id, imgName));
            }
        });
    }

    private void startCategory(CategoryData data) {
        int aResult=0;
        msgCode=0;
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
                    category=result.getCategoryResult();
                    Toast.makeText(getApplicationContext(), "category: "+result.getCategoryResult(), Toast.LENGTH_SHORT).show();
                    alertdialog.setMessage(category+" 가 맞습니까?");
                    // 메인 다이얼로그 생성
                    AlertDialog alert = alertdialog.create();
                    // 아이콘 설정
                    //alert.setIcon(R.drawable.ic_launcher);
                    // 타이틀
                    alert.setTitle("Category 확인");
                    // 다이얼로그 보기
                    alert.show();
                    msgCode=200;
                }

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "카테고리 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("카테고리 에러 발생", t.getMessage());
            }
        });
        //if(msgCode==200) aResult=1;
        //return aResult;
    }


    private void startSaveCategory(SaveCategoryData data) {
        service.saveCategory(data).enqueue(new Callback<SaveCategoryResponse>() {
            @Override
            public void onResponse(Call<SaveCategoryResponse> call, Response<SaveCategoryResponse> response) {
                SaveCategoryResponse result = response.body();
                if(response.body() != null) {
                    result = response.body();
                }
                else{
                    Log.v("알림", "값이 없습니다.");
                }

                //값 가져오는 거 성공하면 사용자가 예상한 결과값과 같은 지 확인하기
                if(result.getCode()==200){
                    Toast.makeText(getApplicationContext(), "category 저장 성공", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SaveCategoryResponse> call, Throwable t) {
                Toast.makeText(CategoryActivity.this, "카테고리 저장 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("카테고리 저장 에러 발생", t.getMessage());
            }
        });
    }

    /*
    public void ListClock(View view){
        new AlertDialog.Builder(this).setTitle("선택").setItems(words, new DialogInterface.OnClickListener() {
            @Override public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(CategoryActivity.this, "words : " + words[which], Toast.LENGTH_LONG).show();
            } }).setNeutralButton("닫기", null).setPositiveButton("확인", null).show();

    }
    */

    /*
    new AsyncTask<Void, Void, String>(){
        @Override
        protected String doInBackground(Void... params) {
            GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
            Call<List<Contributor>> call = gitHubService.repoContributors("square", "retrofit");

            try {
                return call.execute().body().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(s);
        }
    }.execute();
 */
}
