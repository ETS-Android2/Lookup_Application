package ImageSelect;

import android.content.Intent;
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

    private Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemselect);

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




    }

}