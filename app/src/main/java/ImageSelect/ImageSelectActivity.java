package ImageSelect;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.R;


public class ImageSelectActivity extends AppCompatActivity {
    Button mSelectActivity1;
    Button mSelectActivity2;
    Button mSelectActivity3;
    Button mSelectActivity4;
    Button mSelectActivity5;
    Button mSelectActivity6;

    Drawable img1;
    Drawable img2;
    Drawable img3;
    Drawable img4;
    Drawable img5;
    Drawable img6;

    int left, top, right, bottom=20;

    private Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemselect_activity_itemselect);
        mSelectActivity1 = (Button) findViewById(R.id.select1_button);
        mSelectActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SelectActivity1.class);
                startActivity(intent);
            }
        });

        mSelectActivity2 = (Button) findViewById(R.id.select2_button);
        mSelectActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SelectActivity2.class);
                startActivity(intent);
            }
        });

        mSelectActivity3 = (Button) findViewById(R.id.select3_button);
        mSelectActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SelectActivity3.class);
                startActivity(intent);
            }
        });

        mSelectActivity4 = (Button) findViewById(R.id.select4_button);
        mSelectActivity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SelectActivity4.class);
                startActivity(intent);
            }
        });

        mSelectActivity5 = (Button) findViewById(R.id.select5_button);
        mSelectActivity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SelectActivity5.class);
                startActivity(intent);
            }
        });

        mSelectActivity6 = (Button) findViewById(R.id.select6_button);
        mSelectActivity6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SelectActivity6.class);
                startActivity(intent);
            }
        });

/*
        Drawable img1 = getApplicationContext().getResources().getDrawable(
                R.drawable.purpose_daily);
        img1.setBounds(left, top, right, bottom);
        mSelectActivity1.setCompoundDrawablesRelativeWithIntrinsicBounds(null, img1, null, null);

        Drawable img2 = getApplicationContext().getResources().getDrawable(
                R.drawable.purpose_hangout);
        img2.setBounds(left, top, right, bottom);
        mSelectActivity2.setCompoundDrawablesRelativeWithIntrinsicBounds(null, img2, null, null);

        Drawable img3 = getApplicationContext().getResources().getDrawable(
                R.drawable.purpose_workout);
        img3.setBounds(left, top, right, bottom);
        mSelectActivity3.setCompoundDrawables(null, img3, null, null);

        Drawable img4 = getApplicationContext().getResources().getDrawable(
                R.drawable.purpose_formal);
        img4.setBounds(left, top, right, bottom);
        mSelectActivity4.setCompoundDrawables(null, img4, null, null);

        Drawable img5 = getApplicationContext().getResources().getDrawable(
                R.drawable.purpose_parttime);
        img5.setBounds(left, top, right, bottom);
        mSelectActivity5.setCompoundDrawables(null, img5, null, null);

        Drawable img6 = getApplicationContext().getResources().getDrawable(
                R.drawable.purpose_etc);
        img6.setBounds(left, top, right, bottom);
        mSelectActivity6.setCompoundDrawables(null, img6, null, null);

 */


    }

}