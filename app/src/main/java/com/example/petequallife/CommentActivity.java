package com.example.petequallife;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentActivity extends AppCompatActivity {

    ListView listView;
    ListAdapter adapter;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;

    ArrayList<ItemData> itemDatas = new ArrayList<>();

    int number;
    int dog, comm_dog;
    String comm_name, comm_text, name;

    ImageView comment_dog_main;
    TextView comment_name_main;
    TextView comment_text;

    ImageView comment_dog;
    TextView comment_name;

    EditText editText;
    ImageView pin;
    ImageView back_btn;

    int nowCnt;

    ArrayList<Drawable> rounds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_comment);

        /*
        TODO 1. 호감도 설정
        TODO 2. 뒤로가기 버튼 설정 - finish
         */

        listView = findViewById(R.id.comment_listView);

        Intent intent = getIntent();
        number = intent.getIntExtra("number", 0);
        dog = PreferenceManager.getInt(getApplicationContext(), "dog");
        name = PreferenceManager.getString(getApplicationContext(), "name");
        comm_dog = intent.getIntExtra("comm_dog", 0);
        comm_name = intent.getStringExtra("comm_name");
        comm_text = intent.getStringExtra("comm_text");

        rounds.add(getResources().getDrawable(R.drawable.dog_round_1));
        rounds.add(getResources().getDrawable(R.drawable.dog_round_2));
        rounds.add(getResources().getDrawable(R.drawable.dog_round_3));
        rounds.add(getResources().getDrawable(R.drawable.dog_round_4));
        rounds.add(getResources().getDrawable(R.drawable.dog_round_5));
        rounds.add(getResources().getDrawable(R.drawable.dog_round_6));
        rounds.add(getResources().getDrawable(R.drawable.dog_round_7));

        comment_dog = findViewById(R.id.comment_dog);
        comment_dog_main = findViewById(R.id.comment_dog_main);
        comment_name = findViewById(R.id.comment_name);
        comment_name_main = findViewById(R.id.comment_name_main);
        comment_text = findViewById(R.id.comment_text);

        comment_dog.setImageDrawable(rounds.get(dog));
        comment_dog_main.setImageDrawable(rounds.get(comm_dog));
        comment_name.setText(name);
        comment_name_main.setText(comm_name);
        comment_text.setText(comm_text);

        editText = findViewById(R.id.comment_editText);
        pin = findViewById(R.id.pin);

        listView = findViewById(R.id.comment_listView);
        adapter = new ListAdapter(itemDatas);
        listView.setAdapter(adapter);

        initDatabase();

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus){
                if(hasFocus){
                    pin.setVisibility(View.VISIBLE);
                } else{
                    pin.setVisibility(View.GONE);
                }
            }
        });

        pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if(text.equals("")||text==null){
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
                    childUpdates.put("/comment/"+number+"/"+nowCnt, postValues);
                    ref.updateChildren(childUpdates);
                    editText.setText(null);
                    editText.clearFocus();
                }
            }
        });

        back_btn = findViewById(R.id.comment_back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initDatabase(){
        mDatabase = FirebaseDatabase.getInstance();

        mReference = mDatabase.getReference("comment/"+number);

        mChild = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                FirebasePost firebasePost = snapshot.getValue(FirebasePost.class);
                itemDatas.add(new ItemData(rounds.get(firebasePost.dog), firebasePost.name, firebasePost.txt, firebasePost.dog));
                nowCnt = itemDatas.size();
                adapter = new ListAdapter(itemDatas);
                listView.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mReference.addChildEventListener(mChild);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mReference.removeEventListener(mChild);
    }
}
