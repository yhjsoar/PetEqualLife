package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MapActivity extends AppCompatActivity {
    ImageView map_baby, map_play, map_eat, map_walk;
    ImageView dog;
    ImageView home_btn;

    int data;
    boolean isBaby;

    Bitmap bit, bit_baby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_map);

        /*
        TODO 1. 호감도, 피로도
        TODO 2. 진행도
        TODO 3. 좌우반전 - finish
         */

        Intent intent = getIntent();
        data = PreferenceManager.getInt(getApplicationContext(), "dog");
        isBaby = PreferenceManager.getBoolean(getApplicationContext(), "isBaby");

        map_baby = findViewById(R.id.map_baby);
        map_play = findViewById(R.id.map_play);
        map_eat = findViewById(R.id.map_eat);
        map_walk = findViewById(R.id.map_walk);

        dog = findViewById(R.id.map_dog);

        home_btn = findViewById(R.id.map_home);

        setBitmap();
        if(isBaby) dog.setImageBitmap(bit_baby);
        else dog.setImageBitmap(bit);

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        map_baby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아기강아지
                Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                intent.putExtra("from", 1);
                intent.putExtra("data", data);
                startActivity(intent);
                finish();
            }
        });

        map_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 놀아줄 때
                Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                intent.putExtra("from", 2);
                intent.putExtra("data", data);
                startActivity(intent);
                finish();
            }
        });

        map_eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 식사 시간
                Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                intent.putExtra("from", 3);
                intent.putExtra("data", data);
                startActivity(intent);
                finish();
            }
        });

        map_walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 산책할 때
                Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                intent.putExtra("from", 4);
                intent.putExtra("data", data);
                startActivity(intent);
                finish();
            }
        });
    }

    void setBitmap(){
        Bitmap bitmap = null;
        Bitmap bitmap_baby = null;

        switch(data){
            case 0:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_1);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_1_baby);
                break;
            case 1:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_2);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_2_baby);
                break;
            case 2:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_3);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_3_baby);
                break;
            case 3:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_4);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_4_baby);
                break;
            case 4:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_5);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_5_baby);
                break;
            case 5:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_6);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_6_baby);
                break;
            case 6:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_7);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_7_baby);
                break;
        }
        bit = rotateImage(bitmap);
        bit_baby = rotateImage(bitmap_baby);
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
