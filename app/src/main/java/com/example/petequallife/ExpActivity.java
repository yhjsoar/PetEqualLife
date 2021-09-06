package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpActivity extends AppCompatActivity {
    ImageView btn;
    ImageView exp;
    ImageView exp1, exp2, exp3;
    TextView textView;
    ImageView back;
    ImageView dog;

    int dog_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp);

        /*
        TODO 강아지 바꾸기 - finish
         */

        dog_int = PreferenceManager.getInt(getApplicationContext(), "dog");

        back = findViewById(R.id.exp_back);
        dog = findViewById(R.id.exp_dog);
        btn = findViewById(R.id.exp_button);
        exp = findViewById(R.id.exp_btn_exp);
        textView = findViewById(R.id.exp_text);
        exp1 = findViewById(R.id.exp_exp1);
        exp2 = findViewById(R.id.exp_exp2);
        exp3 = findViewById(R.id.exp_exp3);

        setDog();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(exp.getVisibility()==View.VISIBLE){
                    exp.setVisibility(View.GONE);
                }
                else if(exp.getVisibility()==View.GONE){
                    exp.setVisibility(View.VISIBLE);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setDog(){
        switch (dog_int){
            case 0:
                dog.setImageBitmap(rotateImage(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.dog_1)));
                break;
            case 1:
                dog.setImageBitmap(rotateImage(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.dog_2)));
                break;
            case 2:
                dog.setImageBitmap(rotateImage(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.dog_3)));
                break;
            case 3:
                dog.setImageBitmap(rotateImage(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.dog_4)));
                break;
            case 4:
                dog.setImageBitmap(rotateImage(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.dog_5)));
                break;
            case 5:
                dog.setImageBitmap(rotateImage(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.dog_6)));
                break;
            case 6:
                dog.setImageBitmap(rotateImage(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.dog_7)));
                break;
        }
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
