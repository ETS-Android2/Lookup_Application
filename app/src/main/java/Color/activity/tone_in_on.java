package Color.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import petrov.kristiyan.colorpicker_sample.R;


public class tone_in_on extends AppCompatActivity {


    ImageView image;
    private ImageView ToneInTone, ToneOnTone;

    int Tone_In_On = 0; //1이면 IN ,, 2이면 ON

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    public Button back2select;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Intent intent1 = getIntent();
        int intent_top1 = intent1.getIntExtra("top_position1", -1);

        Intent intent2 = getIntent();
        int intent_top2 = intent2.getIntExtra("top_position2", -1);

        Intent intent3 = getIntent();
        int intent_top3 = intent3.getIntExtra("top_position3", -1);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tone_in_on);


        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);


        back2select = (Button) findViewById(R.id.back2select);
        back2select.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Color.activity.tone_in_on.this, Color.activity.TopSelect.class);
                startActivity(i);
            }});



        Button buttonApply = findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                textView.setText("User Choice " + radioButton.getText());
                if (radioButton.getText().equals("Tone In Tone")) {
                    Log.d("선호도 :", "톤인톤");
                    Tone_In_On = 1;
                }
                if (radioButton.getText().equals("Tone On Tone")) {
                    Log.d("선호도 :", "톤온톤");
                    Tone_In_On = 2;
                }


//            radioButton = findViewById(radioId);
            }
        });


        ToneInTone = (ImageView) findViewById(R.id.ToneInTone);
        ToneOnTone = (ImageView) findViewById(R.id.ToneOnTone);


        //top1으로 고른 색상 -> 톤온톤?톤인톤? 뭘 선호하는지
        switch (intent_top1) {
            case 0:
                ToneInTone.setImageResource(R.drawable.pastel_1_in);
                ToneOnTone.setImageResource(R.drawable.pastel_1_on);
                break;
            case 1:
                ToneInTone.setImageResource(R.drawable.pastel_2_in);
                ToneOnTone.setImageResource(R.drawable.pastel_2_on);
                break;
            case 2:
                ToneInTone.setImageResource(R.drawable.pastel_3_in);
                ToneOnTone.setImageResource(R.drawable.pastel_3_on);
                break;
            case 3:
                ToneInTone.setImageResource(R.drawable.pastel_4_in);
                ToneOnTone.setImageResource(R.drawable.pastel_4_on);
                break;
            case 4:
                ToneInTone.setImageResource(R.drawable.pastel_5_in);
                ToneOnTone.setImageResource(R.drawable.pastel_5_on);
                break;
            case 5:
                ToneInTone.setImageResource(R.drawable.vivid_1_in);
                ToneOnTone.setImageResource(R.drawable.vivid_1_on);
                break;
            case 6:
                ToneInTone.setImageResource(R.drawable.vivid_2_in);
                ToneOnTone.setImageResource(R.drawable.vivid_2_on);
                break;
            case 7:
                ToneInTone.setImageResource(R.drawable.vivid_3_in);
                ToneOnTone.setImageResource(R.drawable.vivid_3_on);
                break;
            case 8:
                ToneInTone.setImageResource(R.drawable.vivid_4_in);
                ToneOnTone.setImageResource(R.drawable.vivid_4_on);
                break;
            case 9:
                ToneInTone.setImageResource(R.drawable.vivid_5_in);
                ToneOnTone.setImageResource(R.drawable.vivid_5_on);
                break;
            case 10:
                ToneInTone.setImageResource(R.drawable.vivid_6_in);
                ToneOnTone.setImageResource(R.drawable.vivid_6_on);
                break;
            case 11:
                ToneInTone.setImageResource(R.drawable.vivid_7_in);
                ToneOnTone.setImageResource(R.drawable.vivid_7_on);
                break;
            case 12:
                ToneInTone.setImageResource(R.drawable.vivid_8_in);
                ToneOnTone.setImageResource(R.drawable.vivid_8_on);
                break;
            case 13:
                ToneInTone.setImageResource(R.drawable.vivid_9_in);
                ToneOnTone.setImageResource(R.drawable.vivid_9_on);
                break;
            case 14:
                ToneInTone.setImageResource(R.drawable.vivid_10_in);
                ToneOnTone.setImageResource(R.drawable.vivid_10_on);
                break;
            case 15:
                ToneInTone.setImageResource(R.drawable.deep_1_in);
                ToneOnTone.setImageResource(R.drawable.deep_1_on);
                break;
            case 16:
                ToneInTone.setImageResource(R.drawable.deep_2_in);
                ToneOnTone.setImageResource(R.drawable.deep_2_on);
                break;
            case 17:
                ToneInTone.setImageResource(R.drawable.deep_3_in);
                ToneOnTone.setImageResource(R.drawable.deep_3_on);
                break;
            case 18:
                ToneInTone.setImageResource(R.drawable.deep_4_in);
                ToneOnTone.setImageResource(R.drawable.deep_4_on);
                break;
            case 19:
                ToneInTone.setImageResource(R.drawable.deep_5_in);
                ToneOnTone.setImageResource(R.drawable.deep_5_on);
                break;
            case 20:
                ToneInTone.setImageResource(R.drawable.natural_1_in);
                ToneOnTone.setImageResource(R.drawable.natural_1_on);
                break;
            case 21:
                ToneInTone.setImageResource(R.drawable.natural_2_in);
                ToneOnTone.setImageResource(R.drawable.natural_2_on);
                break;
            case 22:
                ToneInTone.setImageResource(R.drawable.natural_3_in);
                ToneOnTone.setImageResource(R.drawable.natural_3_on);
                break;
            case 23:
                ToneInTone.setImageResource(R.drawable.natural_4_in);
                ToneOnTone.setImageResource(R.drawable.natural_4_on);
                break;
            case 24:
                ToneInTone.setImageResource(R.drawable.natural_5_in);
                ToneOnTone.setImageResource(R.drawable.natural_5_on);
                break;
        }

        //top2로 고른 색상 -> 톤온톤?톤인톤? 뭘 선호하는지
        switch (intent_top2) {
            case 0:
                ToneInTone.setImageResource(R.drawable.pastel_1_in);
                ToneOnTone.setImageResource(R.drawable.pastel_1_on);
                break;
            case 1:
                ToneInTone.setImageResource(R.drawable.pastel_2_in);
                ToneOnTone.setImageResource(R.drawable.pastel_2_on);
                break;
            case 2:
                ToneInTone.setImageResource(R.drawable.pastel_3_in);
                ToneOnTone.setImageResource(R.drawable.pastel_3_on);
                break;
            case 3:
                ToneInTone.setImageResource(R.drawable.pastel_4_in);
                ToneOnTone.setImageResource(R.drawable.pastel_4_on);
                break;
            case 4:
                ToneInTone.setImageResource(R.drawable.pastel_5_in);
                ToneOnTone.setImageResource(R.drawable.pastel_5_on);
                break;
            case 5:
                ToneInTone.setImageResource(R.drawable.vivid_1_in);
                ToneOnTone.setImageResource(R.drawable.vivid_1_on);
                break;
            case 6:
                ToneInTone.setImageResource(R.drawable.vivid_2_in);
                ToneOnTone.setImageResource(R.drawable.vivid_2_on);
                break;
            case 7:
                ToneInTone.setImageResource(R.drawable.vivid_3_in);
                ToneOnTone.setImageResource(R.drawable.vivid_3_on);
                break;
            case 8:
                ToneInTone.setImageResource(R.drawable.vivid_4_in);
                ToneOnTone.setImageResource(R.drawable.vivid_4_on);
                break;
            case 9:
                ToneInTone.setImageResource(R.drawable.vivid_5_in);
                ToneOnTone.setImageResource(R.drawable.vivid_5_on);
                break;
            case 10:
                ToneInTone.setImageResource(R.drawable.vivid_6_in);
                ToneOnTone.setImageResource(R.drawable.vivid_6_on);
                break;
            case 11:
                ToneInTone.setImageResource(R.drawable.vivid_7_in);
                ToneOnTone.setImageResource(R.drawable.vivid_7_on);
                break;
            case 12:
                ToneInTone.setImageResource(R.drawable.vivid_8_in);
                ToneOnTone.setImageResource(R.drawable.vivid_8_on);
                break;
            case 13:
                ToneInTone.setImageResource(R.drawable.vivid_9_in);
                ToneOnTone.setImageResource(R.drawable.vivid_9_on);
                break;
            case 14:
                ToneInTone.setImageResource(R.drawable.vivid_10_in);
                ToneOnTone.setImageResource(R.drawable.vivid_10_on);
                break;
            case 15:
                ToneInTone.setImageResource(R.drawable.deep_1_in);
                ToneOnTone.setImageResource(R.drawable.deep_1_on);
                break;
            case 16:
                ToneInTone.setImageResource(R.drawable.deep_2_in);
                ToneOnTone.setImageResource(R.drawable.deep_2_on);
                break;
            case 17:
                ToneInTone.setImageResource(R.drawable.deep_3_in);
                ToneOnTone.setImageResource(R.drawable.deep_3_on);
                break;
            case 18:
                ToneInTone.setImageResource(R.drawable.deep_4_in);
                ToneOnTone.setImageResource(R.drawable.deep_4_on);
                break;
            case 19:
                ToneInTone.setImageResource(R.drawable.deep_5_in);
                ToneOnTone.setImageResource(R.drawable.deep_5_on);
                break;
            case 20:
                ToneInTone.setImageResource(R.drawable.natural_1_in);
                ToneOnTone.setImageResource(R.drawable.natural_1_on);
                break;
            case 21:
                ToneInTone.setImageResource(R.drawable.natural_2_in);
                ToneOnTone.setImageResource(R.drawable.natural_2_on);
                break;
            case 22:
                ToneInTone.setImageResource(R.drawable.natural_3_in);
                ToneOnTone.setImageResource(R.drawable.natural_3_on);
                break;
            case 23:
                ToneInTone.setImageResource(R.drawable.natural_4_in);
                ToneOnTone.setImageResource(R.drawable.natural_4_on);
                break;
            case 24:
                ToneInTone.setImageResource(R.drawable.natural_5_in);
                ToneOnTone.setImageResource(R.drawable.natural_5_on);
                break;
        }

        //top3으로 고른 색상 -> 톤온톤?톤인톤? 뭘 선호하는지
        switch (intent_top3) {
            case 0:
                ToneInTone.setImageResource(R.drawable.pastel_1_in);
                ToneOnTone.setImageResource(R.drawable.pastel_1_on);
                break;
            case 1:
                ToneInTone.setImageResource(R.drawable.pastel_2_in);
                ToneOnTone.setImageResource(R.drawable.pastel_2_on);
                break;
            case 2:
                ToneInTone.setImageResource(R.drawable.pastel_3_in);
                ToneOnTone.setImageResource(R.drawable.pastel_3_on);
                break;
            case 3:
                ToneInTone.setImageResource(R.drawable.pastel_4_in);
                ToneOnTone.setImageResource(R.drawable.pastel_4_on);
                break;
            case 4:
                ToneInTone.setImageResource(R.drawable.pastel_5_in);
                ToneOnTone.setImageResource(R.drawable.pastel_5_on);
                break;
            case 5:
                ToneInTone.setImageResource(R.drawable.vivid_1_in);
                ToneOnTone.setImageResource(R.drawable.vivid_1_on);
                break;
            case 6:
                ToneInTone.setImageResource(R.drawable.vivid_2_in);
                ToneOnTone.setImageResource(R.drawable.vivid_2_on);
                break;
            case 7:
                ToneInTone.setImageResource(R.drawable.vivid_3_in);
                ToneOnTone.setImageResource(R.drawable.vivid_3_on);
                break;
            case 8:
                ToneInTone.setImageResource(R.drawable.vivid_4_in);
                ToneOnTone.setImageResource(R.drawable.vivid_4_on);
                break;
            case 9:
                ToneInTone.setImageResource(R.drawable.vivid_5_in);
                ToneOnTone.setImageResource(R.drawable.vivid_5_on);
                break;
            case 10:
                ToneInTone.setImageResource(R.drawable.vivid_6_in);
                ToneOnTone.setImageResource(R.drawable.vivid_6_on);
                break;
            case 11:
                ToneInTone.setImageResource(R.drawable.vivid_7_in);
                ToneOnTone.setImageResource(R.drawable.vivid_7_on);
                break;
            case 12:
                ToneInTone.setImageResource(R.drawable.vivid_8_in);
                ToneOnTone.setImageResource(R.drawable.vivid_8_on);
                break;
            case 13:
                ToneInTone.setImageResource(R.drawable.vivid_9_in);
                ToneOnTone.setImageResource(R.drawable.vivid_9_on);
                break;
            case 14:
                ToneInTone.setImageResource(R.drawable.vivid_10_in);
                ToneOnTone.setImageResource(R.drawable.vivid_10_on);
                break;
            case 15:
                ToneInTone.setImageResource(R.drawable.deep_1_in);
                ToneOnTone.setImageResource(R.drawable.deep_1_on);
                break;
            case 16:
                ToneInTone.setImageResource(R.drawable.deep_2_in);
                ToneOnTone.setImageResource(R.drawable.deep_2_on);
                break;
            case 17:
                ToneInTone.setImageResource(R.drawable.deep_3_in);
                ToneOnTone.setImageResource(R.drawable.deep_3_on);
                break;
            case 18:
                ToneInTone.setImageResource(R.drawable.deep_4_in);
                ToneOnTone.setImageResource(R.drawable.deep_4_on);
                break;
            case 19:
                ToneInTone.setImageResource(R.drawable.deep_5_in);
                ToneOnTone.setImageResource(R.drawable.deep_5_on);
                break;
            case 20:
                ToneInTone.setImageResource(R.drawable.natural_1_in);
                ToneOnTone.setImageResource(R.drawable.natural_1_on);
                break;
            case 21:
                ToneInTone.setImageResource(R.drawable.natural_2_in);
                ToneOnTone.setImageResource(R.drawable.natural_2_on);
                break;
            case 22:
                ToneInTone.setImageResource(R.drawable.natural_3_in);
                ToneOnTone.setImageResource(R.drawable.natural_3_on);
                break;
            case 23:
                ToneInTone.setImageResource(R.drawable.natural_4_in);
                ToneOnTone.setImageResource(R.drawable.natural_4_on);
                break;
            case 24:
                ToneInTone.setImageResource(R.drawable.natural_5_in);
                ToneOnTone.setImageResource(R.drawable.natural_5_on);
                break;
        }








//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);


        // Toast.makeText(this,"Selected "+radioButton, Toast.LENGTH_SHORT).show();
    }
}
