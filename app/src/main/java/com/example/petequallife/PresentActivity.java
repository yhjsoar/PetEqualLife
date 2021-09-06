package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PresentActivity extends AppCompatActivity {

    int points, present_num, isFromHome;

    ImageView present1, present2, present3, present4;
    TextView point, num;
    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present);

        Intent intent = getIntent();
        points = intent.getIntExtra("point", 0);
        isFromHome = intent.getIntExtra("fromHome", 0);
        present_num = 0;

        /*
        TODO 1. point 설정
        TODO 2. 사용시 이벤트
         */

        present1 = findViewById(R.id.present1);
        present2 = findViewById(R.id.present2);
        present3 = findViewById(R.id.present3);
        present4 = findViewById(R.id.present4);

        point = findViewById(R.id.present_point);
        num = findViewById(R.id.present_num);

        home = findViewById(R.id.present_home);

        point.setText(points+"");
        num.setText(3-present_num+"/3");

        present1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(points >= 10){
                    if(present_num<3){
                        points -= 10;
                        point.setText(points+"");
                        present_num ++;
                        num.setText(3-present_num+"/3");
                        if(present_num==3){
                            present1.setImageResource(R.drawable.present1_grey);
                            present2.setImageResource(R.drawable.present2_grey);
                            present3.setImageResource(R.drawable.present3_grey);
                            present4.setImageResource(R.drawable.present4_grey);
                        }
                    } else{
                        Toast.makeText(getApplicationContext(), "더 이상 구매할 수 없습니다..", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "포인트가 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        present2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(points >= 10){
                    if(present_num<3){
                        points -= 10;
                        point.setText(points+"");
                        present_num ++;
                        num.setText(3-present_num+"/3");
                        if(present_num==3){
                            present1.setImageResource(R.drawable.present1_grey);
                            present2.setImageResource(R.drawable.present2_grey);
                            present3.setImageResource(R.drawable.present3_grey);
                            present4.setImageResource(R.drawable.present4_grey);
                        }
                    } else{
                        Toast.makeText(getApplicationContext(), "더 이상 구매할 수 없습니다..", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "포인트가 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        present3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(points >= 5){
                    if(present_num<3){
                        points -= 5;
                        point.setText(points+"");
                        present_num ++;
                        num.setText(3-present_num+"/3");
                        if(present_num==3){
                            present1.setImageResource(R.drawable.present1_grey);
                            present2.setImageResource(R.drawable.present2_grey);
                            present3.setImageResource(R.drawable.present3_grey);
                            present4.setImageResource(R.drawable.present4_grey);
                        }
                    } else{
                        Toast.makeText(getApplicationContext(), "더 이상 구매할 수 없습니다..", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "포인트가 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        present4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(points >= 8){
                    if(present_num<3){
                        points -= 8;
                        point.setText(points+"");
                        present_num ++;
                        num.setText(3-present_num+"/3");
                        if(present_num==3){
                            present1.setImageResource(R.drawable.present1_grey);
                            present2.setImageResource(R.drawable.present2_grey);
                            present3.setImageResource(R.drawable.present3_grey);
                            present4.setImageResource(R.drawable.present4_grey);
                        }
                    } else{
                        Toast.makeText(getApplicationContext(), "더 이상 구매할 수 없습니다..", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "포인트가 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
//
//    void present_finish(){
//        if(isFromHome==1){
//            finish();
//        } else{
//            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        present_finish();
//    }
}
