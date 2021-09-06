package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DogGroupInfoActivity extends AppCompatActivity {
    ImageView detail_img_btn, baby_img_btn;
    ImageView country, body, age, color, activity, personality, shape1, shape2, hair, bark;
    TextView jineung, info;
    ImageView baby_img;
    LinearLayout linearLayout, linearLayout2;
    ImageView select_btn;
    ImageView dog_img;
    TextView dog_info;
    TextView dog_group;
    ImageView back_btn;

    Boolean detail_bool = false;
    Boolean baby_bool = false;

    int data;

    Drawable dog_resource, baby_resource;
    String dog_name;

    int REQUEST_CODE = 200;
    int RESULT_BACK = 100;
    int RESULT_FINISH = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dog_group_info);

        final Intent intent = getIntent();
        data = intent.getIntExtra("num", 0);

        country = findViewById(R.id.info_dog_country);
        body = findViewById(R.id.info_dog_body);
        age = findViewById(R.id.info_dog_age);
        color = findViewById(R.id.info_dog_color);
        activity = findViewById(R.id.info_dog_activity);
        personality = findViewById(R.id.info_dog_personality);
        shape1 = findViewById(R.id.info_dog_shape1);
        shape2 = findViewById(R.id.info_dog_shape2);
        jineung = findViewById(R.id.info_dog_jineung);
        hair = findViewById(R.id.info_dog_hair);
        bark = findViewById(R.id.info_dog_bark);
        info = findViewById(R.id.info_dog_info);
        linearLayout = findViewById(R.id.linearLayout);
        linearLayout2 = findViewById(R.id.linearLayout2);
        dog_group = findViewById(R.id.dog_group_group);
        back_btn = findViewById(R.id.dog_group_back);

        String dog[] = getResources().getStringArray(R.array.dog_group_name);

        /*
        TODO 1. 나머지 강아지 넣기
         */

        dog_name = dog[data];

        dog_img = findViewById(R.id.info_dog_img);
        dog_info = findViewById(R.id.info_dog_text);

        setBack();
        setData();

        dog_img.setImageDrawable(dog_resource);


        dog_info.setText(dog_name);

        detail_img_btn = findViewById(R.id.info_detail);
        baby_img_btn = findViewById(R.id.info_baby);
        baby_img = findViewById(R.id.info_dog_baby);
        baby_img.setImageDrawable(baby_resource);

        select_btn = findViewById(R.id.info_dog_select);

        detail_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detail_bool = !detail_bool;
                if(detail_bool){
                    linearLayout.setVisibility(View.GONE);
                    linearLayout2.setVisibility(View.VISIBLE);
                    detail_img_btn.setImageResource(R.drawable.detail_selected);
                } else{
                    linearLayout2.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);
                    detail_img_btn.setImageResource(R.drawable.detail);
                }
            }
        });

        baby_img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baby_bool = !baby_bool;
                if(baby_bool){
                    baby_img.setVisibility(View.VISIBLE);
                    dog_img.setVisibility(View.GONE);
                    baby_img_btn.setImageResource(R.drawable.baby_selected);
                } else{
                    baby_img.setVisibility(View.GONE);
                    dog_img.setVisibility(View.VISIBLE);
                    baby_img_btn.setImageResource(R.drawable.baby);
                }
            }
        });

        select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NamingActivity.class);
                intent.putExtra("num", data);
                intent.putExtra("isBaby", baby_bool);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                setResult(RESULT_BACK, intent1);
                finish();
            }
        });
    }

    void setBack(){
        switch(data){
            case 0:
            case 2:
            case 3:
                linearLayout.setBackgroundResource(R.drawable.dog_info_grey);
                linearLayout2.setBackgroundResource(R.drawable.dog_info_grey);
                dog_group.setText("Terrier Group");
                break;
            case 4:
            case 6:
                linearLayout.setBackgroundResource(R.drawable.dog_info_orange);
                linearLayout2.setBackgroundResource(R.drawable.dog_info_orange);
                dog_group.setText("Non-Sporting Group");
                break;
            case 1:
            case 5:
                linearLayout.setBackgroundResource(R.drawable.dog_info_brown);
                linearLayout2.setBackgroundResource(R.drawable.dog_info_brown);
                dog_group.setText("Sporting Group");
                break;
        }
    }

    void setData(){
        switch (data){
            case 0:
                dog_resource = getResources().getDrawable(R.drawable.dog_choose_1);
                baby_resource = getResources().getDrawable(R.drawable.dog_1_baby);
                country.setImageResource(R.drawable.dog1_country);
                body.setImageResource(R.drawable.dog1_size_info);
                age.setImageResource(R.drawable.dog1_age);
                color.setImageResource(R.drawable.dog1_colors);
                activity.setImageResource(R.drawable.dog1_activity);
                personality.setImageResource(R.drawable.dog1_personality);
                shape1.setImageResource(R.drawable.dog1_shape1);
                shape2.setImageResource(R.drawable.dog1_shape2);
                hair.setImageResource(R.drawable.dog1_hair);
                jineung.setText("12위");
                bark.setImageResource(R.drawable.dog1_bark);
                info.setText("- 강한 자기주장\n- 수렵본능\n- 활동성 높음\n- 호기심 왕성\n- 짖음에 대한 교육");
                break;
            case 1:
                dog_resource = getResources().getDrawable(R.drawable.dog_choose_2);
                baby_resource = getResources().getDrawable(R.drawable.dog_2_baby);
                country.setImageResource(R.drawable.dog2_country);
                body.setImageResource(R.drawable.dog2_size_info);
                age.setImageResource(R.drawable.dog2_age);
                color.setImageResource(R.drawable.dog2_colors);
                activity.setImageResource(R.drawable.dog2_activity);
                personality.setImageResource(R.drawable.dog2_personality);
                shape1.setImageResource(R.drawable.dog2_shape1);
                shape2.setImageResource(R.drawable.dog2_shape2);
                hair.setImageResource(R.drawable.dog2_hair);
                jineung.setText("20위");
                bark.setImageResource(R.drawable.dog2_bark);
                info.setText("- 강한 자기주장\n- 수렵본능\n- 활동성 높음\n- 호기심 왕성\n- 짖음에 대한 교육");
                break;
            case 2:
                dog_resource = getResources().getDrawable(R.drawable.dog_choose_3);
                baby_resource = getResources().getDrawable(R.drawable.dog_3_baby);
                break;
            case 3:
                dog_resource = getResources().getDrawable(R.drawable.dog_choose_4);
                baby_resource = getResources().getDrawable(R.drawable.dog_4_baby);
                break;
            case 4:
                dog_resource = getResources().getDrawable(R.drawable.dog_choose_5);
                baby_resource = getResources().getDrawable(R.drawable.dog_5_baby);
                country.setImageResource(R.drawable.dog5_country);
                body.setImageResource(R.drawable.dog5_size_info);
                age.setImageResource(R.drawable.dog5_age);
                color.setImageResource(R.drawable.dog5_colors);
                activity.setImageResource(R.drawable.dog5_activity);
                personality.setImageResource(R.drawable.dog5_personality);
                shape1.setImageResource(R.drawable.dog5_shape1);
                shape2.setImageResource(R.drawable.dog5_shape2);
                hair.setImageResource(R.drawable.dog5_hair);
                jineung.setText("77위");
                bark.setImageResource(R.drawable.dog5_bark);
                info.setText("- 강한 자기주장\n- 수렵본능\n- 활동성 높음\n- 호기심 왕성\n- 짖음에 대한 교육");
                break;
            case 5:
                dog_resource = getResources().getDrawable(R.drawable.dog_choose_6);
                baby_resource = getResources().getDrawable(R.drawable.dog_6_baby);
                break;
            case 6:
                dog_resource = getResources().getDrawable(R.drawable.dog_choose_7);
                baby_resource = getResources().getDrawable(R.drawable.dog_7_baby);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_BACK) {
            } else if(resultCode == RESULT_FINISH){
                Intent intent1 = new Intent();
                setResult(RESULT_FINISH, intent1);
                finish();
            }
        }
    }
}
