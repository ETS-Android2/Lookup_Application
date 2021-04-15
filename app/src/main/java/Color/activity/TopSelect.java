package Color.activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;
//import petrov.kristiyan.colorpicker_sample.R;
import java.R;


//import petrov.kristiyan.colorpicker_sample.mj.activity.JoinActivity;

//import petrov.kristiyan.colorpicker_sample.mj.data.DupCheckResponse;
//import petrov.kristiyan.colorpicker_sample.mj.data.JoinData;
//import petrov.kristiyan.colorpicker_sample.mj.network.ServiceApi;
//import petrov.kristiyan.colorpicker_sample.yj.data.TopData;
//import petrov.kristiyan.colorpicker_sample.yj.data.TopResponse;


public class TopSelect extends AppCompatActivity {

    static final int top1=-1;
    static final int top2=-1;
    static final int top3=-1;


    private Button top_b1;
    private Button top_b2;
    private Button top_b3;
    private RelativeLayout layout;

//    private ServiceApi service;


    private TextView topText;

    public int bottom_tone[] = {0, 0, 0};  //1:파스텔 2:비비드 3:딥 4:내추럴 5:모노톤

    public static Color.activity.TopSelect context_main;   //0409 추가
    public int top_position1;
    public int top_position2;
    public int top_position3;

    public Button next1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_select);

        top_b1 = (Button) findViewById(R.id.top_b1);
        top_b2 = (Button) findViewById(R.id.top_b2);
        top_b3 = (Button) findViewById(R.id.top_b3);

        layout = (RelativeLayout) findViewById(R.id.layout);


        top_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker1_top();
            }
        });
        top_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker2_top();
            }
        });
        top_b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker3_top();
            }
        });

        next1 = (Button) findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), code.color_select.activity.tone_in_on.class);
//                //원래 이건데 내가 지운거 tone_in_on.class);
//                startActivity(intent);

                Intent i = new Intent (Color.activity.TopSelect.this, tone_in_on.class);
                startActivity(i);
//
//                int top1 = top_position1;
//                int top2 = top_position2;
//                int top3 = top_position3;

//                sendTop123(new TopData(top1,top2,top3));
//                showProgress(true);


            }
        });
    }

    public void openColorPicker1_top() {
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
                        top_b1.setBackgroundColor(color);
                        top_position1 = position; //0409 추가

                        //0412추가시작
                        Intent intent1 = new Intent(Color.activity.TopSelect.this, tone_in_on.class);
                        intent1.putExtra("top_position1", top_position1);
                        startActivity(intent1);
                        //0412추가끝

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

    public void openColorPicker2_top() {
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
                        top_b2.setBackgroundColor(color);
                        top_position2 = position; //0409 추가

                        //0412추가시작
                        Intent intent2 = new Intent(Color.activity.TopSelect.this, tone_in_on.class);
                        intent2.putExtra("top_position2", top_position2);
                        startActivity(intent2);
                        //0412추가끝


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

    public void openColorPicker3_top() {
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
                        top_b3.setBackgroundColor(color);
                        top_position3 = position; //0409 추가

                        //0412추가시작
                        Intent intent3 = new Intent(Color.activity.TopSelect.this, tone_in_on.class);
                        intent3.putExtra("top_position3", top_position3);
                        startActivity(intent3);
                        //0412추가끝


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



// 서버 전송 코드
//    private void sendTop123(TopData data) {
//        service.userJoin(data).enqueue(new Callback<TopResponse>() {
//            @Override
//            public void onResponse(Call<TopResponse> call, Response<TopResponse> response) {
//                TopResponse result = response.body();
//                Toast.makeText(TopSelect.this, result.getMessage(), Toast.LENGTH_SHORT).show();
//                showProgress(false);
//
//                if (result.getCode() == 200) {
//                    finish();
//                }
//            }
//
//
//
//        });
//    }

    private void showProgress(boolean show) {
        // mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    /*
    private void sendTop123(ColorData data) {
        service.userJoin(data).enqueue(new Callback<ColorResponse>() {
            @Override
            public void onResponse(Call<ColorResponse> call, Response<ColorResponse> response) {
                ColorResponse result = response.body();
                Toast.makeText(TopSelect.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                showProgress(false);

                if (result.getCode() == 200) {
                    finish();
                }
            }



        });
    }
    */


/*흰 상자 색깔 유지하는 거 -> 안됨 0413
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Button b1=(Button) findViewById(R.id.top_b1);
        Button b2=(Button) findViewById(R.id.top_b2);
        Button b3=(Button) findViewById(R.id.top_b3);


        outState.putInt(top_position1, top1);
        outState.putInt(top_position2, top2);
        outState.putInt(top_position3, top3);



    }

 */


}

