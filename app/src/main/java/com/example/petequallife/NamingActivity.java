package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NamingActivity extends AppCompatActivity {
    ImageView dog_img;
    EditText editText;
    ImageView start_btn;
    ImageView back_btn;

    Drawable dog_resource;

    int data;
    boolean isBaby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naming);

        dog_img = findViewById(R.id.naming_dog);
        editText = findViewById(R.id.naming_edittext);
        start_btn = findViewById(R.id.naming_btn);
        back_btn = findViewById(R.id.naming_back);

        Intent intent = getIntent();
        data = intent.getIntExtra("num", 0);
        isBaby = intent.getBooleanExtra("isBaby", false);

        switch (data){
            case 0:
                if(!isBaby) dog_resource = getResources().getDrawable(R.drawable.dog_choose_1);
                else dog_resource = getResources().getDrawable(R.drawable.dog_1_baby);
                break;
            case 1:
                if(!isBaby) dog_resource = getResources().getDrawable(R.drawable.dog_choose_2);
                else dog_resource = getResources().getDrawable(R.drawable.dog_2_baby);
                break;
            case 2:
                if(!isBaby) dog_resource = getResources().getDrawable(R.drawable.dog_choose_3);
                else dog_resource = getResources().getDrawable(R.drawable.dog_3_baby);
                break;
            case 3:
                if(!isBaby) dog_resource = getResources().getDrawable(R.drawable.dog_choose_4);
                else dog_resource = getResources().getDrawable(R.drawable.dog_4_baby);
                break;
            case 4:
                if(!isBaby) dog_resource = getResources().getDrawable(R.drawable.dog_choose_5);
                else dog_resource = getResources().getDrawable(R.drawable.dog_5_baby);
                break;
            case 5:
                if(!isBaby) dog_resource = getResources().getDrawable(R.drawable.dog_choose_6);
                else dog_resource = getResources().getDrawable(R.drawable.dog_6_baby);
                break;
            case 6:
                if(!isBaby) dog_resource = getResources().getDrawable(R.drawable.dog_choose_7);
                else dog_resource = getResources().getDrawable(R.drawable.dog_7_baby);
                break;
        }

        dog_img.setImageDrawable(dog_resource);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text.equals("")||text==null){
                    Toast.makeText(getApplication(), "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    PreferenceManager.setBoolean(getApplicationContext(), "isSaved", true);
                    PreferenceManager.setInt(getApplicationContext(), "dog", data);
                    PreferenceManager.setBoolean(getApplicationContext(), "isBaby", isBaby);
                    PreferenceManager.setString(getApplicationContext(), "name", text);
                    startActivity(intent);
                    Intent intent1 = new Intent();
                    setResult(101, intent1);
                    finish();
                }
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
