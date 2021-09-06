package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinishPlayActivity extends AppCompatActivity {

    ImageView present, map;
    Button exp, home;
    ImageView dog_big, dog_small;
    ImageView heart[] = new ImageView[5];
    TextView result[] = new TextView[4];
    TextView name_text;

    Bitmap bit;

    int dog;
    String name;
    Boolean isBaby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_finish_play);


        dog_big = findViewById(R.id.finish_dog);
        dog_small = findViewById(R.id.finish_small_img);
        name_text = findViewById(R.id.finish_name);

        heart[0] = findViewById(R.id.finish_heart0);
        heart[1] = findViewById(R.id.finish_heart1);
        heart[2] = findViewById(R.id.finish_heart2);
        heart[3] = findViewById(R.id.finish_heart3);
        heart[4] = findViewById(R.id.finish_heart4);

        result[0] = findViewById(R.id.finish_result0);
        result[1] = findViewById(R.id.finish_result1);
        result[2] = findViewById(R.id.finish_result2);
        result[3] = findViewById(R.id.finish_result3);

        present = findViewById(R.id.finish_present);
        map = findViewById(R.id.finish_map);

        exp = findViewById(R.id.finish_exp);
        home = findViewById(R.id.finish_home);

        /*
        TODO intent로 이름, 개 종류, 호감도, 결과 받아오기
         */

        dog = PreferenceManager.getInt(getApplicationContext(), "dog");
        name = PreferenceManager.getString(getApplicationContext(), "name");
        isBaby = PreferenceManager.getBoolean(getApplicationContext(), "isBaby");

        setBitmap(dog);
        dog_big.setImageBitmap(bit);
        name_text.setText(name);

        present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 선물 액티비티로 이동
                Intent intent = new Intent(getApplicationContext(), PresentActivity.class);
                intent.putExtra("point", 61);
                intent.putExtra("fromHome", "0");
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 맵으로 이동
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 구체 설명으로 이동
                Intent intent = new Intent(getApplicationContext(), ExpActivity.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //홈으로 이동
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    void setBitmap(int data){
        Bitmap bitmap = null;

        switch(data){
            case 0:
                if(isBaby) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_1_baby);
                else bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_1);
                dog_small.setImageResource(R.drawable.dog_round_1);
                break;
            case 1:
                if(isBaby) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_2_baby);
                else bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_2);
                dog_small.setImageResource(R.drawable.dog_round_2);
                break;
            case 2:
                if(isBaby) BitmapFactory.decodeResource(getResources(), R.drawable.dog_3_baby);
                else bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_3);
                dog_small.setImageResource(R.drawable.dog_round_3);
                break;
            case 3:
                if(isBaby) BitmapFactory.decodeResource(getResources(), R.drawable.dog_4_baby);
                else bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_4);
                dog_small.setImageResource(R.drawable.dog_round_4);
                break;
            case 4:
                if(isBaby) BitmapFactory.decodeResource(getResources(), R.drawable.dog_5_baby);
                else bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_5);
                dog_small.setImageResource(R.drawable.dog_round_5);
                break;
            case 5:
                if(isBaby) BitmapFactory.decodeResource(getResources(), R.drawable.dog_6_baby);
                else bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_6);
                dog_small.setImageResource(R.drawable.dog_round_6);
                break;
            case 6:
                if(isBaby) BitmapFactory.decodeResource(getResources(), R.drawable.dog_7_baby);
                else bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_7);
                dog_small.setImageResource(R.drawable.dog_round_7);
                break;
        }

        bit = rotateImage(bitmap);
    }

    public Bitmap rotateImage(Bitmap src){
        float[] mirrorY = {
                -1, 0, 0,
                0, 1, 0,
                0, 0, 1
        };
        Matrix matrix = new Matrix();
        matrix.setValues(mirrorY);

        return Bitmap.createBitmap(src, 0, 0, src.getWidth(), src.getHeight(), matrix, true);
    }
}
