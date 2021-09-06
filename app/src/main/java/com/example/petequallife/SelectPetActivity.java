package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectPetActivity extends AppCompatActivity {

    Drawable[] dog_resource;
    Drawable[] dog_resource_r;
    ImageView mainDog;
    ImageView[] listDog;
    ImageView btn;
    ImageView back;
    int[] dog_seq;

    TextView eng, kor;

    int REQUEST_CODE = 200;
    int RESULT_BACK = 100;
    int RESULT_FINISH = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_select_pet);

        dog_resource = new Drawable[7];
        dog_resource_r = new Drawable[7];

        dog_resource_r[0] = getResources().getDrawable(R.drawable.dog_group_1);
        dog_resource_r[1] = getResources().getDrawable(R.drawable.dog_group_2);
        dog_resource_r[2] = getResources().getDrawable(R.drawable.dog_group_3);
        dog_resource_r[3] = getResources().getDrawable(R.drawable.dog_group_4);
        dog_resource_r[4] = getResources().getDrawable(R.drawable.dog_group_5);
        dog_resource_r[5] = getResources().getDrawable(R.drawable.dog_group_6);
        dog_resource_r[6] = getResources().getDrawable(R.drawable.dog_group_7);


        dog_resource[0] = getResources().getDrawable(R.drawable.dog_r_1);
        dog_resource[1] = getResources().getDrawable(R.drawable.dog_r_2);
        dog_resource[2] = getResources().getDrawable(R.drawable.dog_r_3);
        dog_resource[3] = getResources().getDrawable(R.drawable.dog_r_4);
        dog_resource[4] = getResources().getDrawable(R.drawable.dog_r_5);
        dog_resource[5] = getResources().getDrawable(R.drawable.dog_r_6);
        dog_resource[6] = getResources().getDrawable(R.drawable.dog_r_7);

        mainDog = findViewById(R.id.select_main_dog);
        listDog = new ImageView[6];
        listDog[0] = findViewById(R.id.select_dog1);
        listDog[1] = findViewById(R.id.select_dog2);
        listDog[2] = findViewById(R.id.select_dog3);
        listDog[3] = findViewById(R.id.select_dog4);
        listDog[4] = findViewById(R.id.select_dog5);
        listDog[5] = findViewById(R.id.select_dog6);

        back = findViewById(R.id.select_back);
        btn = findViewById(R.id.select_btn);

        eng = findViewById(R.id.select_title);
        kor = findViewById(R.id.select_group);

        dog_seq = new int[7];
        for(int i=0;i<7;i++){
            dog_seq[i] = i;
            // dog_seq[0] : mainDog resource
        }

        mainDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DogGroupInfoActivity.class);
                intent.putExtra("num", dog_seq[0]);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        listDog[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmp = dog_seq[0];
                dog_seq[0] = dog_seq[1];
                dog_seq[1] = tmp;

                ChangeImage();

                mainDog.setImageDrawable(dog_resource[dog_seq[0]]);
                listDog[0].setImageDrawable(dog_resource_r[dog_seq[1]]);
            }
        });

        listDog[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmp = dog_seq[0];
                dog_seq[0] = dog_seq[2];
                dog_seq[2] = tmp;

                ChangeImage();

                mainDog.setImageDrawable(dog_resource[dog_seq[0]]);
                listDog[1].setImageDrawable(dog_resource_r[dog_seq[2]]);
            }
        });

        listDog[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmp = dog_seq[0];
                dog_seq[0] = dog_seq[3];
                dog_seq[3] = tmp;

                ChangeImage();

                mainDog.setImageDrawable(dog_resource[dog_seq[0]]);
                listDog[2].setImageDrawable(dog_resource_r[dog_seq[3]]);
            }
        });

        listDog[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmp = dog_seq[0];
                dog_seq[0] = dog_seq[4];
                dog_seq[4] = tmp;

                ChangeImage();

                mainDog.setImageDrawable(dog_resource[dog_seq[0]]);
                listDog[3].setImageDrawable(dog_resource_r[dog_seq[4]]);
            }
        });

        listDog[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmp = dog_seq[0];
                dog_seq[0] = dog_seq[5];
                dog_seq[5] = tmp;

                ChangeImage();

                mainDog.setImageDrawable(dog_resource[dog_seq[0]]);
                listDog[4].setImageDrawable(dog_resource_r[dog_seq[5]]);
            }
        });

        listDog[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tmp = dog_seq[0];
                dog_seq[0] = dog_seq[6];
                dog_seq[6] = tmp;

                ChangeImage();

                mainDog.setImageDrawable(dog_resource[dog_seq[0]]);
                listDog[5].setImageDrawable(dog_resource_r[dog_seq[6]]);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectPopupActivity.class);
                intent.putExtra("num", dog_seq[0]);
                startActivity(intent);
            }
        });
    }

    void ChangeImage(){
        switch(dog_seq[0]){
            case 0:
            case 2:
            case 3:
                back.setImageResource(R.drawable.select_grey);
                eng.setText("Terrier Group");
                kor.setText("테리어 그룹");
                break;
            case 1:
            case 4:
                back.setImageResource(R.drawable.select_orange);
                eng.setText("Non-Sporting Group");
                kor.setText("논 스포팅 그룹");
                break;
            case 5:
            case 6:
                back.setImageResource(R.drawable.select_brown);
                eng.setText("Sporting Group");
                kor.setText("스포팅 그룹");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_BACK){

            } else if(resultCode == RESULT_FINISH){
                finish();
            }
        }

    }
}
