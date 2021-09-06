package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PointActivity extends AppCompatActivity {
    Context mContext;

    ListView listView;
    PointListAdapter pointListAdapter;

    ImageView dog;
    ImageView heart[] = new ImageView[5];
    TextView point;
    ImageView home;

    Bitmap bit;

    ArrayList<PointData> pointDataArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_point);

        mContext = getApplicationContext();

        listView = findViewById(R.id.point_listView);
        dog = findViewById(R.id.point_dog);
        heart[0] = findViewById(R.id.point_heart0);
        heart[1] = findViewById(R.id.point_heart1);
        heart[2] = findViewById(R.id.point_heart2);
        heart[3] = findViewById(R.id.point_heart3);
        heart[4] = findViewById(R.id.point_heart4);
        point = findViewById(R.id.point_text);
        home = findViewById(R.id.point_home);

        pointDataArrayList.add(new PointData("산책할 때 맵", 11, 5));
        pointDataArrayList.add(new PointData("간식", -10, 8));
        pointDataArrayList.add(new PointData("장난감", -10, 8));
        pointDataArrayList.add(new PointData("식사시간 맵", 11, 5));

        int point_num = 0;
        int heart_num = 0;
        for(int i=0;i<pointDataArrayList.size();i++){
            point_num += pointDataArrayList.get(i).point;
            heart_num += pointDataArrayList.get(i).heart;
        }

        // TODO heart_num 별 하트 설정

        point.setText(point_num+"");

        // TODO dog 받아오기 - finish
        int dog_num = PreferenceManager.getInt(getApplicationContext(), "dog");
        setBitmap(dog_num);

        dog.setImageBitmap(bit);

        // TODO pointDataArray 받아오기

        pointListAdapter = new PointListAdapter(pointDataArrayList);
        listView.setAdapter(pointListAdapter);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void setBitmap(int data){
        Bitmap bitmap = null;

        switch(data){
            case 0:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_1);
                break;
            case 1:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_2);
                break;
            case 2:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_3);
                break;
            case 3:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_4);
                break;
            case 4:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_5);
                break;
            case 5:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_6);
                break;
            case 6:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_choose_7);
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
