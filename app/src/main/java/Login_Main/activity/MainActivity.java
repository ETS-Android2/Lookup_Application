package Login_Main.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Closet.activity.Closet_MainActivity;
import Closet.activity.TopActivity;
import Color.activity.TopSelect;
//import petrov.kristiyan.colorpicker_sample.R;
import java.R;
import Cutout.CutOut_MainActivity;
import Cookie.SaveSharedPreference;

public class MainActivity extends AppCompatActivity{
    Button mLogoutButton;
    Button mTestButton;
    Button mLoginButton;
    Button mCutoutButton;
    Button mTopSelectButton;
    Button mClosetButton;

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

        mTopSelectButton = (Button) findViewById(R.id.topselect_btn);
        mTopSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TopSelect.class);
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
