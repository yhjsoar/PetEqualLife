package com.example.petequallife;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class CommunityActivity extends AppCompatActivity {
    private static String TAG = "CommunityActivity";
    Context mContext;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;

    ListView listView;
    ListAdapter adapter;

    ImageView plus_btn;
    ImageView home_btn;

    ArrayList<ItemData> itemDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_community);

        /*
        TODO 1. plus 버튼 수정
        TODO 2. home 버튼 설정 - finish
         */

        mContext = getApplicationContext();

        listView = findViewById(R.id.listView);
        adapter = new ListAdapter(itemDatas);
        listView.setAdapter(adapter);

        initDatabase();

        plus_btn = findViewById(R.id.community_plus);
        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddCommunityActivity.class);
                intent.putExtra("cnt", itemDatas.size());
                startActivityForResult(intent, 200);
            }
        });

        home_btn = findViewById(R.id.community_home);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemData data = itemDatas.get(position);

                Intent intent = new Intent(getApplicationContext(), CommentActivity.class);
                intent.putExtra("comm_dog", data.dog);
                intent.putExtra("comm_name", data.name);
                intent.putExtra("comm_text", data.txt);
                intent.putExtra("number", position+1);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 200) {
            if (resultCode == RESULT_OK) {
                adapter = new ListAdapter(itemDatas);
                listView.setAdapter(adapter);
            } else {   // RESULT_CANCEL
            }
        }
    }

    private void initDatabase(){
        mDatabase = FirebaseDatabase.getInstance();

        mReference = mDatabase.getReference("story");

        mChild = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                FirebasePost firebasePost = snapshot.getValue(FirebasePost.class);

                    Drawable drawable = getResources().getDrawable(R.drawable.dog_r_1);

                    switch (firebasePost.dog) {
                        case 0:
                            drawable = getResources().getDrawable(R.drawable.dog_round_1);
                            break;
                        case 1:
                            drawable = getResources().getDrawable(R.drawable.dog_round_2);
                            break;
                        case 2:
                            drawable = getResources().getDrawable(R.drawable.dog_round_3);
                            break;
                        case 3:
                            drawable = getResources().getDrawable(R.drawable.dog_round_4);
                            break;
                        case 4:
                            drawable = getResources().getDrawable(R.drawable.dog_round_5);
                            break;
                        case 5:
                            drawable = getResources().getDrawable(R.drawable.dog_round_6);
                            break;
                        case 6:
                            drawable = getResources().getDrawable(R.drawable.dog_round_7);
                            break;
                    }

                    itemDatas.add( new ItemData(drawable, firebasePost.name, firebasePost.txt, firebasePost.dog));

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
