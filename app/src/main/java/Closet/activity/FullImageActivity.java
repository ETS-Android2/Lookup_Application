package Closet.activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.R;

//import Closet.ImageAdapter;


public class FullImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closet_image_details);
        // Get intent data
        Intent i = getIntent();
        // Get Selected Image Id
        String imgUrl = i.getExtras().getString("url");
        Log.d("url:::::: ", imgUrl);
        //ImageAdapter imageAdapter = new ImageAdapter(this);
        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        if(imgUrl.length()!=0) {

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round);
            Glide.with(getApplicationContext()).load(imgUrl).apply(options).into(imageView);
        }
        //imageView.setImageResource(imageAdapter.thumbImages[position]);
    }
}
