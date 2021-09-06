package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddCommunityActivity extends AppCompatActivity {

    int dog;
    String name;

    ImageView dogImageView;
    TextView dogName;
    EditText editText;
    ImageView addBtn;
    ImageView backBtn;

    int nowCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_community);

        /*
        TODO: 호감도 설정
        TODO: 상단바 지우기 - finish
         */

        Intent intent = getIntent();
        dog = PreferenceManager.getInt(getApplicationContext(), "dog");
        name = PreferenceManager.getString(getApplicationContext(), "name");
        nowCnt = intent.getIntExtra("cnt", 0);

        dogImageView = findViewById(R.id.add_comm_dog_img);
        dogName = findViewById(R.id.add_comm_dog_name);
        editText = findViewById(R.id.add_comm_edittext);
        addBtn = findViewById(R.id.imageView15);
        backBtn = findViewById(R.id.add_commu_back);

        switch (dog){
            case 0:
                dogImageView.setImageResource(R.drawable.dog_round_1);
                break;
            case 1:
                dogImageView.setImageResource(R.drawable.dog_round_2);
                break;
            case 2:
                dogImageView.setImageResource(R.drawable.dog_round_3);
                break;
            case 3:
                dogImageView.setImageResource(R.drawable.dog_round_4);
                break;
            case 4:
                dogImageView.setImageResource(R.drawable.dog_round_5);
                break;
            case 5:
                dogImageView.setImageResource(R.drawable.dog_round_6);
                break;
            case 6:
                dogImageView.setImageResource(R.drawable.dog_round_7);
                break;
        }
        dogName.setText(name);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text.equals("") || text==null){
                    Toast.makeText(getApplication(),"내용을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else{
                    nowCnt++;
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference ref = database.getReference();
                    Map<String, Object> childUpdates = new HashMap<>();
                    Map<String, Object> postValues = null;
                    FirebasePost post = new FirebasePost(name, dog, text);
                    postValues = post.toMap();
                    childUpdates.put("/story/"+nowCnt, postValues);
                    ref.updateChildren(childUpdates);
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
