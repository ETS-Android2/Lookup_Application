package Closet.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.R;
import java.util.ArrayList;

import Closet.Data_Type;
//import Closet.ImageAdapter;
import Closet.ViewPagerAdapter.ViewPagerAdapter_Top;

public class TopActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager2 viewPager2; //뷰페이저
    ViewPagerAdapter_Top viewPagerAdapter; //뷰페이저 어뎁터
    TabLayout tabLayout; //텝 레이아웃
    //GridView gridView;
    ArrayList<Data_Type> mdata; //데이터 모델
    Context context;
    public static TopActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closet_activity_top);
        activity=this;
        context = this;
        mdata = new ArrayList<>();

        viewPager2 = findViewById(R.id.notification_list_container);
        tabLayout = findViewById(R.id.notification_list_tabs);

//        tabLayout.addTab(tabLayout.newTab().setText("A")); //텝 레이아웃 아이템 추가
//        tabLayout.addTab(tabLayout.newTab().setText("B"));
//        tabLayout.addTab(tabLayout.newTab().setText("C"));

        mdata.add(new Data_Type(1));
        mdata.add(new Data_Type(2));
        mdata.add(new Data_Type(3));
        mdata.add(new Data_Type(4));
        mdata.add(new Data_Type(5));
        mdata.add(new Data_Type(6));
        mdata.add(new Data_Type(7));
        mdata.add(new Data_Type(8));
        mdata.add(new Data_Type(9));
        mdata.add(new Data_Type(10));

        /*
        mdata.add(new Data_Type(1, "shortsleeve"));
        mdata.add(new Data_Type(2, "longsleeve"));
        mdata.add(new Data_Type(3, "shortshirt"));
        mdata.add(new Data_Type(4, "longshirt"));
        mdata.add(new Data_Type(5, "sweater"));
        mdata.add(new Data_Type(6, "hoodie"));
        mdata.add(new Data_Type(7, "shortblouse"));
        mdata.add(new Data_Type(8, "longblouse"));
        mdata.add(new Data_Type(9, "sleeveless"));
        mdata.add(new Data_Type(10, "vest"));
         */
        viewPagerAdapter = new ViewPagerAdapter_Top(context ,mdata); //뷰페이저 어뎁터 생성
        viewPager2.setAdapter(viewPagerAdapter);//어뎁터 연결
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL); //스크롤방향

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {// 텝 레이아웃이랑 연결
                switch (position){
                    case 0:{
                        tab.setText("반팔"); //텝레이아웃 상단 타이틀 제목 설정
                        break;
                    }
                    case 1:{
                        tab.setText("긴팔");
                        break;
                    }
                    case 2:{
                        tab.setText("반팔 셔츠");
                        break;
                    }
                    case 3:{
                        tab.setText("긴팔 셔츠");
                        break;
                    }
                    case 4:{
                        tab.setText("니트");
                        break;
                    }
                    case 5:{
                        tab.setText("후드");
                        break;
                    }
                    case 6:{
                        tab.setText("반팔 블라우스");
                        break;
                    }
                    case 7:{
                        tab.setText("긴팔 블라우스");
                        break;
                    }
                    case 8:{
                        tab.setText("민소매");
                        break;
                    }
                    case 9:{
                        tab.setText("조끼");
                        break;
                    }
                }

            }
        });

        tabLayoutMediator.attach();

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { //뷰페이저 해당 포지션 위치
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position){
                    case 0://A
                    {
                        Toast.makeText(context, "A", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 1://B
                    {
                        Toast.makeText(context, "B", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 2://C
                    {
                        Toast.makeText(context, "C", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 3://C
                    {
                        Toast.makeText(context, "D", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 4://C
                    {
                        Toast.makeText(context, "E", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 5://C
                    {
                        Toast.makeText(context, "F", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 6://C
                    {
                        Toast.makeText(context, "G", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 7://C
                    {
                        Toast.makeText(context, "H", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 8://C
                    {
                        Toast.makeText(context, "I", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 9://C
                    {
                        Toast.makeText(context, "J", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });

    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.appbar){
            finish();
            Intent intent = new Intent(getApplicationContext(), Closet_MainActivity.class);
            startActivity(intent);
        }
    }
}
