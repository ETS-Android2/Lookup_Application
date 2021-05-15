package Login_Main.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Closet.activity.Closet_MainActivity;
//import petrov.kristiyan.colorpicker_sample.R;
import java.R;

import Color.activity.TopSelect123;
import ColorSpuit.ExampleColorMixing;
import Cutout.CutOut_MainActivity;
import Cookie.SaveSharedPreference;
import ImageSelect.ImageSelectActivity;
import LookBook.LookBookActivity;
import styleList.RatingActivity;

public class MainActivity extends AppCompatActivity{
    Button mLogoutButton;
    Button mTestButton;
    Button mLoginButton;
    Button mCutoutButton;
    Button mTopSelectButton;
    Button mTopSelect123Button;
    Button mClosetButton;
    Button mStyleListButton;
    Button mColorSpuit;
    Button mImageSelect;
    Button mLookBook;

    private Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogoutButton = (Button) findViewById(R.id.logout_button);
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveSharedPreference.clear(MainActivity.this);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //다른 액티비티로 넘어가기 위한 테스트 버튼
        mTestButton = (Button) findViewById(R.id.test_btn);
        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(intent);
            }
        });

        //cutout으로 넘어가기 위한 버튼
        mCutoutButton = (Button) findViewById(R.id.cutout_btn);
        mCutoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CutOut_MainActivity.class);
                startActivity(intent);
            }
        });



        mTopSelect123Button = (Button) findViewById(R.id.topselect123_btn);
        mTopSelect123Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TopSelect123.class);
                startActivity(intent);
            }
        });

        mClosetButton = (Button) findViewById(R.id.closet_btn);
        mClosetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Closet_MainActivity.class);
                startActivity(intent);
            }
        });

        mStyleListButton = (Button) findViewById(R.id.styleList_btn);
        mStyleListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RatingActivity.class);
                startActivity(intent);
            }
        });

        mColorSpuit = (Button) findViewById(R.id.colorspuit_btn);
        mColorSpuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ExampleColorMixing.class);
                startActivity(intent);
            }
        });

        mImageSelect = (Button) findViewById(R.id.imageSelect_btn);
        mImageSelect .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImageSelectActivity.class);
                startActivity(intent);
            }
        });

        mLookBook = (Button) findViewById(R.id.lookbook_btn);
        mLookBook .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LookBookActivity.class);
                startActivity(intent);
            }
        });

        /*
        mLoginButton = (Button) findViewById(R.id.login_btn);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveSharedPreference.clear(MainActivity.this);
                Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                startActivity(intent);
            }
        });
*/
        //만약 쿠키가 없으면=>로그인 상태가 아니면
        if(SaveSharedPreference.getString(getApplicationContext(), "ID").equals("")) {
            // call Login Activity
            intent = new Intent(getApplicationContext(), LoginActivity.class); //로그인 액티비티로
            startActivity(intent);
            this.finish();
        }

        /*
        if(SaveSharedPreference.getString(getApplicationContext(), "ID").equals("")) {
            // call Login Activity
            mLogoutButton.setEnabled(false);
            //intent = new Intent(getApplicationContext(), LoginActivity.class);
            //startActivity(intent);
            //this.finish();
        }
        else if (SaveSharedPreference.getString(getApplicationContext(), "ID").length()>0) {
            // call Login Activity
            mLoginButton.setEnabled(false);
            //intent = new Intent(getApplicationContext(), LoginActivity.class);
            //startActivity(intent);
            //this.finish();
        }
        */

        /*
        else {
            // Call Next Activity
            intent = new Intent(MainActivity.this, MainActivity.class);
            //intent.putExtra("STD_NUM", SaveSharedPreference.getAttribute(this).toString());
            startActivity(intent);
            this.finish();
        }

         */
    }

}
