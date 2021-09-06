package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectPopupActivity extends Activity {
    String dog_info[];
    String dog_info2[];
    ImageView imageView;

    ViewPager viewPager;
    TextViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_select_popup);

        /*
        TODO 1. 설명 넣기
        TODO 2. 아래 도트 바꾸기
         */

        Intent intent =  getIntent();
        int data = intent.getIntExtra("num", 0);

        imageView = findViewById(R.id.pagerimg);

        dog_info = getResources().getStringArray(R.array.dog_group_info);
        dog_info2 = getResources().getStringArray(R.array.dog_group_info2);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        pagerAdapter = new TextViewPagerAdapter(this, dog_info[data], dog_info2[data]);
        viewPager.setAdapter(pagerAdapter);
    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
