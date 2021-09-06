package com.example.petequallife;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ImageView playBtn1, playBtn2, playBtn3, playBtn4;
    ImageView dog;
    ImageView dog_baby;
    ImageView dog_round;
    ImageView menu, menu_open;
    LinearLayout menu_layout;
    ImageView menu_community, menu_baby, menu_cat;
    ImageView present, map_btn, point;
    TextView dog_name;

    Bitmap bit, bit_baby;

    Boolean menu_bool = false;

    int data;
    boolean isBaby;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        /*
        TODO 1. play 버튼 설정
        TODO 2. 호감도 설정
        TODO 3. 고양이 그림 클릭 이벤트 - finish
        TODO 4. point 기록 클릭 이벤트 - finish
        TODO 5. 색변화 - finish
         */

        data = PreferenceManager.getInt(getApplicationContext(), "dog");
        isBaby = PreferenceManager.getBoolean(getApplicationContext(), "isBaby");
        name = PreferenceManager.getString(getApplicationContext(), "name");

        playBtn1 = findViewById(R.id.home_play1);
        playBtn2 = findViewById(R.id.home_play2);
        playBtn3 = findViewById(R.id.home_play3);
        playBtn4 = findViewById(R.id.home_play4);

        dog = findViewById(R.id.home_dog);
        dog_baby = findViewById(R.id.home_dog_baby);
        dog_round = findViewById(R.id.home_round);

        menu = findViewById(R.id.menu);
        menu_open = findViewById(R.id.menu_open);
        menu_layout = findViewById(R.id.menu_open_assets);

        menu_community = findViewById(R.id.menu_community);
        menu_baby = findViewById(R.id.menu_baby);
        menu_cat = findViewById(R.id.menu_cat);

        present = findViewById(R.id.home_present);
        map_btn = findViewById(R.id.home_map);
        point = findViewById(R.id.home_point);

        dog_name = findViewById(R.id.home_name);

        dog_name.setText(name);

        setBitmap();
        setBack();

        dog.setImageBitmap(bit);
        dog_baby.setImageBitmap(bit_baby);

        if(isBaby){
            dog.setVisibility(View.GONE);
            dog_baby.setVisibility(View.VISIBLE);
            menu_baby.setColorFilter(Color.parseColor("#445EA8"));
        }

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_bool = !menu_bool;
                if(menu_bool){
                    menu_open.setVisibility(View.VISIBLE);
                    menu_layout.setVisibility(View.VISIBLE);
                } else{
                    menu_open.setVisibility(View.GONE);
                    menu_layout.setVisibility(View.GONE);
                }
            }
        });

        menu_community.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommunityActivity.class);
                startActivity(intent);
            }
        });

//        menu_baby.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isBaby = !isBaby;
//                if(isBaby){
//                    dog.setVisibility(View.GONE);
//                    dog_baby.setVisibility(View.VISIBLE);
//                    menu_baby.setColorFilter(Color.parseColor("#445EA8"));
//                }
//                else{
//                    dog.setVisibility(View.VISIBLE);
//                    dog_baby.setVisibility(View.GONE);
//                    menu_baby.setColorFilter(null);
//                }
//            }
//        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PointActivity.class);
                startActivity(intent);
            }
        });

        menu_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        playBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "play1", Toast.LENGTH_SHORT).show();
            }
        });
        playBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "play2", Toast.LENGTH_SHORT).show();
            }
        });
        playBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "play3", Toast.LENGTH_SHORT).show();
            }
        });
        playBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "play4", Toast.LENGTH_SHORT).show();
            }
        });

        map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                intent.putExtra("num", data);
                intent.putExtra("isBaby", isBaby);
                startActivity(intent);
                finish();
            }
        });

        present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PresentActivity.class);
                intent.putExtra("point", 61);
                intent.putExtra("fromHome", "1");
                startActivity(intent);
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
                dog_round.setImageDrawable(getResources().getDrawable(R.drawable.dog_round_1));
                break;
            case 1:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_2);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_2_baby);
                dog_round.setImageDrawable(getResources().getDrawable(R.drawable.dog_round_2));
                break;
            case 2:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_3);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_3_baby);
                dog_round.setImageDrawable(getResources().getDrawable(R.drawable.dog_round_3));
                break;
            case 3:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_4);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_4_baby);
                dog_round.setImageDrawable(getResources().getDrawable(R.drawable.dog_round_4));
                break;
            case 4:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_5);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_5_baby);
                dog_round.setImageDrawable(getResources().getDrawable(R.drawable.dog_round_5));
                break;
            case 5:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_6);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_6_baby);
                dog_round.setImageDrawable(getResources().getDrawable(R.drawable.dog_round_6));
                break;
            case 6:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_7);
                bitmap_baby = BitmapFactory.decodeResource(getResources(), R.drawable.dog_7_baby);
                dog_round.setImageDrawable(getResources().getDrawable(R.drawable.dog_round_7));
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

    void setBack(){
        switch (data){
            case 0:
            case 2:
            case 3:
                menu.setImageResource(R.drawable.menu_grey);
                point.setImageResource(R.drawable.home_point_grey);
                present.setImageResource(R.drawable.home_present_grey);
                playBtn3.setImageResource(R.drawable.play3_grey);
                break;
            case 4:
            case 6:
                menu.setImageResource(R.drawable.menu_orange);
                point.setImageResource(R.drawable.home_point_orange);
                present.setImageResource(R.drawable.home_present_orange);
                playBtn3.setImageResource(R.drawable.play3_orange);
                break;
            case 1:
            case 5:
                menu.setImageResource(R.drawable.menu_brown);
                point.setImageResource(R.drawable.home_point_brown);
                present.setImageResource(R.drawable.home_present_brown);
                playBtn3.setImageResource(R.drawable.play3_brown);
                break;
        }
    }

    void showDialog(){
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(HomeActivity.this)
                .setTitle("정말 재선택 하시겠습니까?")
                .setMessage("플레이했던 정보가 삭제됩니다.")
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PreferenceManager.clear(getApplicationContext());
                        Intent intent = new Intent(getApplicationContext(), SelectPetActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();
    }
}
