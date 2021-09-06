package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView startBtn;

    boolean isSaved = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.main_start_btn);

        /*
        TODO sharedPerference 이용, isSaved 가져오기
         */

        isSaved = PreferenceManager.getBoolean(getApplicationContext(), "isSaved");

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSaved){
                    Intent intent = new Intent(getApplicationContext(), SelectPetActivity.class);
                    startActivity(intent);
                } else{
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        });
    }
}
