package Login_Main.activity;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

import Closet.activity.Closet_MainActivity;
//import petrov.kristiyan.colorpicker_sample.R;
import java.R;

import Color.activity.TopSelect123;
import ColorSpuit.ExampleColorMixing;
import Cutout.CutOut;
import Cutout.CutOut_MainActivity;
import Cookie.SaveSharedPreference;
import ImageSelect.ImageSelectActivity;
import LookBook.LookBookActivity;
import LookBook.MergeActivity;
import LookBook.MergeActivity2;
import styleList.RatingActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
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
    Button mLookBook_Merge;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //setSupportActionBar(toolbar);

        //로그인 로그아웃 부분
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);



        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

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

        mLookBook_Merge = (Button) findViewById(R.id.lookbook_merge_btn);
        mLookBook_Merge .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MergeActivity2.class);
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


    public void onBackPressed(){  //Back 눌렸을 때 어플 꺼지는 거 방지,,

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

        switch (menuitem.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.nav_closet:
                Intent intent = new Intent(MainActivity.this, Closet_MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_add:
                Intent intent1 = new Intent(MainActivity.this, CutOut_MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_stylerate:
                Intent intent2 = new Intent(MainActivity.this, RatingActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_situation:
                Intent intent3 = new Intent(MainActivity.this, ImageSelectActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_lookbook:
                Intent intent4 = new Intent(MainActivity.this, LookBookActivity.class);
                startActivity(intent4);
                break;



        }

        drawerLayout.closeDrawer(GravityCompat.START); //메뉴 선택되면 drawer 닫히도록

        return true;
    }
}
