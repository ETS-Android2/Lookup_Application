package Closet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.R;

import Login_Main.activity.JoinActivity;
import network.RetrofitClient;
import network.ServiceApi;

public class Closet_MainActivity extends AppCompatActivity {
    private Button mTopButton;
    private Button mBottomButton;
    private Button mOuterButton;
    private Button mDressButton;
    private Button mAccButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closet_mainactivity);

        mTopButton = (Button) findViewById(R.id.top_btn);
        mBottomButton = (Button) findViewById(R.id.bottom_btn);
        mOuterButton = (Button) findViewById(R.id.outer_btn);
        mDressButton = (Button) findViewById(R.id.dress_btn);
        mAccButton = (Button) findViewById(R.id.acc_btn);


        //TopActivity로
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TopActivity.class);
                startActivity(intent);
            }
        });

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BottomActivity.class);
                startActivity(intent);
            }
        });

        mOuterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OuterActivity.class);
                startActivity(intent);
            }
        });

        mDressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DressActivity.class);
                startActivity(intent);
            }
        });

        mAccButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccActivity.class);
                startActivity(intent);
            }
        });
    }
}
