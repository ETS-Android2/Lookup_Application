package Color;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import petrov.kristiyan.colorpicker.ColorPicker;
import petrov.kristiyan.colorpicker_sample.R;

public class BottomSelect extends AppCompatActivity {
    private Button bottom_b1;
    private Button bottom_b2;
    private Button bottom_b3;
    private RelativeLayout layout;

    private TextView topText;

    public int bottom_tone[] = {0, 0, 0};  //1:파스텔 2:비비드 3:딥 4:내추럴 5:모노톤

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_select);

        bottom_b1 = (Button) findViewById(R.id.top_b1);
        bottom_b2 = (Button) findViewById(R.id.top_b2);
        bottom_b3 = (Button) findViewById(R.id.top_b3);

        layout = (RelativeLayout) findViewById(R.id.layout);


        bottom_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker1_bottom();
            }
        });
        bottom_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker2_bottom();
            }
        });
        bottom_b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker3_bottom();
            }
        });

    }

    public void openColorPicker1_bottom() {
        final ColorPicker colorPicker = new ColorPicker(this);  // ColorPicker 객체 생성
        ArrayList<String> colors = new ArrayList<>();  // Color 넣어줄 list

        //colors.add(Color.rgb(0, 162, 179));

        colors.add("#EAA2B3");  //파스텔 핑크
        colors.add("#F8F4B1");  //파스텔 옐로우
        colors.add("#91C0BD");  //파스텔 그린
        colors.add("#ABD6F3");  //파스텔 블루
        colors.add("#D1B7DB");  //파스텔 퍼플

        colors.add("#E13F00");  //비비드 빨
        colors.add("#F06700");  //비비드 주
        colors.add("#F4CD0B");  //비비드 노
        colors.add("#CBDB08");  //비비드 연두
        colors.add("#40901A");  //비비드 초록
        colors.add("#218D7B");  //비비드 딥그린
        colors.add("#069DE4");  //비비드 블루
        colors.add("#394AA4");  //비비드 네이비
        colors.add("#793991");  //비비드 퍼플
        colors.add("#D44194");  //비비드 핑크

        colors.add("#90343F");  //딥
        colors.add("#602C04");  //딥
        colors.add("#C89704");  //딥
        colors.add("#42510F");  //딥
        colors.add("#2D2267");  //딥

        colors.add("#EED079");  //내추럴
        colors.add("#9B4D02");  //내추럴
        colors.add("#CA8102");  //내추럴
        colors.add("#BF890A");  //내추럴
        colors.add("#61490E");  //내추럴

        colors.add("#ffffff");  //흰
        colors.add("#000000");  //검
        colors.add("#B8B8B8");  //회


        colorPicker.setColors(colors)  // 만들어둔 list 적용
                .setColumns(5)  // 5열로 설정
                .setRoundColorButton(true)  // 원형 버튼으로 설정
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
//                      layout.setBackgroundColor(color);  // OK 버튼 클릭 시 이벤트
                        bottom_b1.setBackgroundColor(color);

                        Log.d("position", "" + position);

                        if (position >= 0 && position < 5) {
                            bottom_tone[0] = 1;
                            Log.d("선택된 색 ", "1파스텔톤");
                        }
                        if (position >= 5 && position < 15) {
                            bottom_tone[0] = 2;
                            Log.d("선택된 색 ", "2비비드톤");
                        }
                        if (position >= 15 && position < 20) {
                            bottom_tone[0] = 3;
                            Log.d("선택된 색 ", "3딥톤");
                        }
                        if (position >= 20 && position < 25) {
                            bottom_tone[0] = 4;
                            Log.d("선택된 색 ", "4내추럴톤");
                        }
                        if (position >= 25 && position < 28) {
                            bottom_tone[0] = 5;
                            Log.d("선택된 색 ", "5모노톤");
                        }

                    }

                    @Override
                    public void onCancel() {
                        // Cancel 버튼 클릭 시 이벤트
                    }
                }).show();  // dialog 생성


    }

    public void openColorPicker2_bottom() {
        final ColorPicker colorPicker = new ColorPicker(this);  // ColorPicker 객체 생성
        ArrayList<String> colors = new ArrayList<>();  // Color 넣어줄 list


        colors.add("#EAA2B3");  //파스텔 핑크
        colors.add("#F8F4B1");  //파스텔 옐로우
        colors.add("#91C0BD");  //파스텔 그린
        colors.add("#ABD6F3");  //파스텔 블루
        colors.add("#D1B7DB");  //파스텔 퍼플

        colors.add("#E13F00");  //비비드 빨
        colors.add("#F06700");  //비비드 주
        colors.add("#F4CD0B");  //비비드 노
        colors.add("#CBDB08");  //비비드 연두
        colors.add("#40901A");  //비비드 초록
        colors.add("#218D7B");  //비비드 딥그린
        colors.add("#069DE4");  //비비드 블루
        colors.add("#394AA4");  //비비드 네이비
        colors.add("#793991");  //비비드 퍼플
        colors.add("#D44194");  //비비드 핑크

        colors.add("#90343F");  //딥
        colors.add("#602C04");  //딥
        colors.add("#C89704");  //딥
        colors.add("#42510F");  //딥
        colors.add("#2D2267");  //딥

        colors.add("#EED079");  //내추럴
        colors.add("#9B4D02");  //내추럴
        colors.add("#CA8102");  //내추럴
        colors.add("#BF890A");  //내추럴
        colors.add("#61490E");  //내추럴

        colors.add("#ffffff");  //흰
        colors.add("#000000");  //검
        colors.add("#B8B8B8");  //회


        colorPicker.setColors(colors)  // 만들어둔 list 적용
                .setColumns(5)  // 5열로 설정
                .setRoundColorButton(true)  // 원형 버튼으로 설정
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
//                      layout.setBackgroundColor(color);  // OK 버튼 클릭 시 이벤트
                        bottom_b2.setBackgroundColor(color);

                        Log.d("position", "" + position);

                        if (position >= 0 && position < 5) {
                            bottom_tone[1] = 1;
                            Log.d("선택된 색 ", "1파스텔톤");
                        }
                        if (position >= 5 && position < 15) {
                            bottom_tone[1] = 2;
                            Log.d("선택된 색 ", "2비비드톤");
                        }
                        if (position >= 15 && position < 20) {
                            bottom_tone[1] = 3;
                            Log.d("선택된 색 ", "3딥톤");
                        }
                        if (position >= 20 && position < 25) {
                            bottom_tone[1] = 4;
                            Log.d("선택된 색 ", "4내추럴톤");
                        }
                        if (position >= 25 && position < 28) {
                            bottom_tone[1] = 5;
                            Log.d("선택된 색 ", "5모노톤");
                        }


                    }


                    @Override
                    public void onCancel() {
                        // Cancel 버튼 클릭 시 이벤트
                    }
                }).show();  // dialog 생성


    }

    public void openColorPicker3_bottom() {
        final ColorPicker colorPicker = new ColorPicker(this);  // ColorPicker 객체 생성
        ArrayList<String> colors = new ArrayList<>();  // Color 넣어줄 list


        colors.add("#EAA2B3");  //파스텔 핑크
        colors.add("#F8F4B1");  //파스텔 옐로우
        colors.add("#91C0BD");  //파스텔 그린
        colors.add("#ABD6F3");  //파스텔 블루
        colors.add("#D1B7DB");  //파스텔 퍼플

        colors.add("#E13F00");  //비비드 빨
        colors.add("#F06700");  //비비드 주
        colors.add("#F4CD0B");  //비비드 노
        colors.add("#CBDB08");  //비비드 연두
        colors.add("#40901A");  //비비드 초록
        colors.add("#218D7B");  //비비드 딥그린
        colors.add("#069DE4");  //비비드 블루
        colors.add("#394AA4");  //비비드 네이비
        colors.add("#793991");  //비비드 퍼플
        colors.add("#D44194");  //비비드 핑크

        colors.add("#90343F");  //딥
        colors.add("#602C04");  //딥
        colors.add("#C89704");  //딥
        colors.add("#42510F");  //딥
        colors.add("#2D2267");  //딥

        colors.add("#EED079");  //내추럴
        colors.add("#9B4D02");  //내추럴
        colors.add("#CA8102");  //내추럴
        colors.add("#BF890A");  //내추럴
        colors.add("#61490E");  //내추럴

        colors.add("#ffffff");  //흰
        colors.add("#000000");  //검
        colors.add("#B8B8B8");  //회


        colorPicker.setColors(colors)  // 만들어둔 list 적용
                .setColumns(5)  // 5열로 설정
                .setRoundColorButton(true)  // 원형 버튼으로 설정
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
//                      layout.setBackgroundColor(color);  // OK 버튼 클릭 시 이벤트
                        bottom_b3.setBackgroundColor(color);

                        Log.d("position", "" + position);

                        if (position >= 0 && position < 5) {
                            bottom_tone[2] = 1;
                            Log.d("선택된 색 ", "1파스텔톤");
                        }
                        if (position >= 5 && position < 15) {
                            bottom_tone[2] = 2;
                            Log.d("선택된 색 ", "2비비드톤");
                        }
                        if (position >= 15 && position < 20) {
                            bottom_tone[2] = 3;
                            Log.d("선택된 색 ", "3딥톤");
                        }
                        if (position >= 20 && position < 25) {
                            bottom_tone[2] = 4;
                            Log.d("선택된 색 ", "4내추럴톤");
                        }
                        if (position >= 25 && position < 28) {
                            bottom_tone[2] = 5;
                            Log.d("선택된 색 ", "5모노톤");
                        }


                    }


                    @Override
                    public void onCancel() {
                        // Cancel 버튼 클릭 시 이벤트
                    }


                }).show();  // dialog 생성

    }
}

