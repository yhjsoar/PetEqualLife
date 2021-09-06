package com.example.petequallife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class PlayActivity extends AppCompatActivity {
    int data;
    int from;

    Drawable dog_resource;

    ImageView pause_btn;
    ImageView dog, play_dog;
    TextView text_yes, text_no;
    TextView dog_name;

    GifDrawable gifAnim;
    GifImageView gifImageView;

    View view;
    ConstraintLayout linearLayout1, linearLayout2, linearLayout3;
    LinearLayout layout;
    LinearLayout play_layout;

    ImageView guage1, guage2, guage3, guage4;
    ImageView dog1, dog2, dog3, dog4, dog5;
    TextView questBox;

    TextView pause1, pause2;

    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play);

        final Intent intent = getIntent();
        data = intent.getIntExtra("data", 0);
        from = intent.getIntExtra("from", 1);
        // 1 아기 강아지 2 놀아줄 때 3 식사 시간 4 산책할 때

        String name = PreferenceManager.getString(getApplicationContext(), "name");

        pause_btn = findViewById(R.id.play_pause);
        dog = findViewById(R.id.play_round);
        text_yes = findViewById(R.id.play_text_yes);
        text_no = findViewById(R.id.play_text_no);
        linearLayout1 = findViewById(R.id.play_linearLayout1);
        linearLayout2 = findViewById(R.id.play_linearLayout2);
        linearLayout3 = findViewById(R.id.play_linearLayout3);
        view = findViewById(R.id.gifImageView);
        layout = findViewById(R.id.pause_layout);
        dog_name = findViewById(R.id.play_name);
        pause1 = findViewById(R.id.text_pause);
        pause2 = findViewById(R.id.text_play);
        play_layout = findViewById(R.id.play_layout);
        play_dog = findViewById(R.id.play_dog);
        guage1 = findViewById(R.id.guage_1);
        guage2 = findViewById(R.id.guage_2);
        guage3 = findViewById(R.id.guage_3);
        guage4 = findViewById(R.id.guage_4);
        dog1 = findViewById(R.id.guage_dog_0);
        dog2 = findViewById(R.id.guage_dog_1);
        dog3 = findViewById(R.id.guage_dog_2);
        dog4 = findViewById(R.id.guage_dog_3);
        dog5 = findViewById(R.id.guage_dog_4);
        questBox = findViewById(R.id.play_quest_text);


        String p1 = '"'+name+"아~! 물마셔!"+'"';
        String p2 = '"'+name+"아~! 가자!"+'"';
        pause1.setText(p1);
        pause2.setText(p2);

        dog_name.setText(name);

        switch (data){
            case 0:
                dog_resource = getResources().getDrawable(R.drawable.dog_round_1);
                play_dog.setImageResource(R.drawable.dog_1);
                if(from==1){
                    play_dog.setImageResource(R.drawable.dog_1_baby);
                }
                break;
            case 1:
                dog_resource = getResources().getDrawable(R.drawable.dog_round_2);
                play_dog.setImageResource(R.drawable.dog_2);
                if(from==1){
                    play_dog.setImageResource(R.drawable.dog_2_baby);
                }
                break;
            case 2:
                dog_resource = getResources().getDrawable(R.drawable.dog_round_3);
                play_dog.setImageResource(R.drawable.dog_3);
                if(from==1){
                    play_dog.setImageResource(R.drawable.dog_3_baby);
                }
                break;
            case 3:
                dog_resource = getResources().getDrawable(R.drawable.dog_round_4);
                play_dog.setImageResource(R.drawable.dog_4);
                if(from==1){
                    play_dog.setImageResource(R.drawable.dog_4_baby);
                }
                break;
            case 4:
                dog_resource = getResources().getDrawable(R.drawable.dog_round_5);
                play_dog.setImageResource(R.drawable.dog_5);
                if(from==1){
                    play_dog.setImageResource(R.drawable.dog_5_baby);
                }
                break;
            case 5:
                dog_resource = getResources().getDrawable(R.drawable.dog_round_6);
                play_dog.setImageResource(R.drawable.dog_6);
                if(from==1){
                    play_dog.setImageResource(R.drawable.dog_6_baby);
                }
                break;
            case 6:
                dog_resource = getResources().getDrawable(R.drawable.dog_round_7);
                play_dog.setImageResource(R.drawable.dog_7);
                if(from==1){
                    play_dog.setImageResource(R.drawable.dog_7_baby);
                }
                break;
        }

        gifAnim = null;
        try{
            if(from == 4){
                if(data==0){
                    play_layout.setVisibility(View.GONE);
                    gifAnim = new GifDrawable(getResources(), R.drawable.dog1_run_1);
                    view.setBackground(gifAnim);
                    gifAnim.setLoopCount(1);
                } else{
                    view.setVisibility(View.GONE);
                    dog2.setVisibility(View.VISIBLE);
                    guage1.setVisibility(View.VISIBLE);
                    play_layout.setBackgroundResource(R.drawable.play_background_play);
                    questBox.setText("반대편에서 다가오는 행인을 보고 강아지가 갑자기 발을 멈췄습니다. 어떻게 하시겠습니까?");
                }
                text_no.setText("목줄을 끌어 계속이어서 산책을 하도록 유도합니다.");
                text_yes.setText("옆에 벽을 쳐주듯 행인과 강아지 사이에 막아서고 행인이 지나가기를 기다립니다.");
            }
            else{
                view.setVisibility(View.GONE);
                dog2.setVisibility(View.VISIBLE);
                guage1.setVisibility(View.VISIBLE);
                if(from==3){
                    play_layout.setBackgroundResource(R.drawable.play_background_eat);
                    questBox.setText("강아지가 밥이라는 말을 듣자 흥분한 상태로 달려옵니다. 빨리 먹고 싶은 마음에 강아지가 뛰어오르며 밥그릇을 달라고 합니다.");
                    text_no.setText("배가 고플 우리 강아지에게 빨리 밥을 줍니다!");
                    text_yes.setText("밥을 너무 쉽게 줄 수는 없다. 앉아서 기다릴 때까지 밥을 주지 않는다.");
                    if(data==0){
                        play_dog.setImageResource(R.drawable.eat_dog1);
                    }
                }
                else if(from==2){
                    play_layout.setBackgroundResource(R.drawable.play_background_play);
                    questBox.setText("강아지와 놀아주는데 장난감을 보자 흥분해서 당신이 아닌 장난감에 시선이 고정되어있다. 강아지에게 장난감을 건넬까?");
                    text_no.setText("얼마나 놀고 싶으면 눈이 빠져라 장난감을 노려보겠는가.");
                    text_yes.setText("나에게 집중하지 않으면 장난감을 주지 않는다");
                    if(data==0){
                        play_dog.setImageResource(R.drawable.play_dog1);
                    }
                }
                else if(from==1){
                    play_layout.setBackgroundResource(R.drawable.play_background_play);
                    questBox.setText("자신의 삶의 조건과 가장 어울리는 강아지를 처음 분양받았다. 아기 강아지가  너무 귀여워서 계속 강아지를 쓰다듬고 싶습니다.");
                    text_no.setText("계속 따라다니며 강아지를 쓰다듬는다");
                    text_yes.setText("공간에 적응하도록 기다린다");
                }
            }
        } catch (Exception e){
            Log.d("asdasd", e.toString());
        }




        dog.setImageDrawable(dog_resource);

        text_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer(1);
            }
        });

        text_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer(0);
            }
        });

        pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(from==4){
                    gifAnim.pause();
                }
                findViewById(R.id.play_view).setVisibility(View.VISIBLE);
                layout.setVisibility(View.VISIBLE);
            }
        });

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 일시정지..?
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(from==4){
                    gifAnim.start();
                }
                findViewById(R.id.play_view).setVisibility(View.GONE);
                layout.setVisibility(View.GONE);
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }

    private final long FINISH_INTERVAL_TIME = 2000;
    private long   backPressedTime = 0;

    @Override
    public void onBackPressed(){
        if(findViewById(R.id.play_view).getVisibility()==View.VISIBLE){
            gifAnim.start();
            findViewById(R.id.play_view).setVisibility(View.GONE);
            layout.setVisibility(View.GONE);
        }
        else{
            long tempTime = System.currentTimeMillis();
            long intervalTime = tempTime - backPressedTime;

            if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
            {
                super.onBackPressed();
            }
            else
            {
                backPressedTime = tempTime;
                Toast.makeText(getApplicationContext(), "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void answer(int ans){
        num++;
        if(from==4 && data == 0){
            if(num==1){
                try{
                    gifAnim = new GifDrawable(getResources(), R.drawable.dog1_run_2);
                    view.setBackground(gifAnim);
                    gifAnim.setLoopCount(1);
                    text_no.setText("다른 강아지랑 있다가 다칠 수도 있으니까 다가가지 않는다.");
                    text_yes.setText("다른 강아지와 사교활동을 하는 건 중요하지. 친구를 만들라고 다가간다.");
                } catch (Exception e){
                    Log.d("asdasd", e.toString());
                }
            } else if(num==2){
                try{
                    gifAnim = new GifDrawable(getResources(), R.drawable.dog1_run_3);
                    view.setBackground(gifAnim);
                    gifAnim.setLoopCount(1);
                    text_no.setText("신나서 달려가는데 마음것 놀게 놔둡니다.");
                    text_yes.setText("주위에 다른 행인이 많을 수 있는데 이렇게 뛰어가면 통제가 어렵기 떄문에 적절히 제지한다.");
                } catch (Exception e){
                    Log.d("asdasd", e.toString());
                }
            } else if(num>=3){
                Intent intent = new Intent(getApplicationContext(), FinishPlayActivity.class);
                startActivity(intent);
                finish();
            }
        } else if(from == 4){
            if(num==1){
                dog2.setVisibility(View.GONE);
                dog3.setVisibility(View.VISIBLE);
                guage2.setVisibility(View.VISIBLE);
                questBox.setText("반대편에서 다른 강아지가 꼬리를 흔들며 다가옵니다. 당신의 강아지는 귀를 쫑긋거리며 꼬리를 흔듭니다. 다가가시겠습니까?");
                text_no.setText("다른 강아지랑 있다가 다칠 수도 있으니까 다가가지 않는다.");
                text_yes.setText("다른 강아지와 사교활동을 하는 건 중요하지. 친구를 만들라고 다가간다.");
            } else if(num==2){
                dog3.setVisibility(View.GONE);
                dog4.setVisibility(View.VISIBLE);
                guage3.setVisibility(View.VISIBLE);
                questBox.setText("강아지가 신이나서 앞만 보고 달려나가기 시작했습니다. 당신은 어떻게 하시겠습니까?");
                text_no.setText("신나서 달려가는데 마음것 놀게 놔둡니다.");
                text_yes.setText("주위에 다른 행인이 많을 수 있는데 이렇게 뛰어가면 통제가 어렵기 떄문에 적절히 제지한다.");
            } else if(num>=3){
                Intent intent = new Intent(getApplicationContext(), FinishPlayActivity.class);
                startActivity(intent);
                finish();
            }
        }
        else if(from == 3){
            if(num==1){
                dog2.setVisibility(View.GONE);
                dog3.setVisibility(View.VISIBLE);
                guage2.setVisibility(View.VISIBLE);
                questBox.setText("당신이 밥을 먹으려고 고기를 굽는데 강아지가 냄새를 맡고 다가옵니다. 고기를 얻어먹고자 당신을 지긋이 바라봅니다.");
                text_no.setText("나만 고기를 먹기에는 미안하다. 사랑하는 반려견에게 나눠준다.");
                text_yes.setText("사람이 먹는 고기는 사람이 먹어야 한다. 그리고 이미 밥도 줬잖아!");
                if(data==0){
                    play_dog.setImageResource(R.drawable.eat_dog2);
                }
            }
            else if(num==2){
                dog3.setVisibility(View.GONE);
                dog4.setVisibility(View.VISIBLE);
                guage3.setVisibility(View.VISIBLE);
                questBox.setText("당신이 하루 정도 장기간 집을 비웁니다. 강아지의 밥을 챙겨주기 어려워진당신은 밥그릇에 사료를 가득 채우고 자가급식을 시키겠습니까?");
                text_no.setText("강아지가 굶으면 안 되니 밥그릇을 가득 채우고 나갑니다.");
                text_yes.setText("가족이나 지인에게 부탁해 강아지 밥을 챙깁니다. 아니면 자가급식 기계를 마련하여 시간이 되면 일정량의 사료만 공급한다.");
                if(data==0){
                    play_dog.setImageResource(R.drawable.eat_dog3);
                }
            } else if(num>=3){
                Intent intent = new Intent(getApplicationContext(), FinishPlayActivity.class);
                startActivity(intent);
                finish();
            }
        }
        else if (from==2){
            if(num==1){
                dog2.setVisibility(View.GONE);
                dog3.setVisibility(View.VISIBLE);
                guage2.setVisibility(View.VISIBLE);
                questBox.setText("날씨가 좋아 도그 파크로 놀러 나왔다. 다른 강아지들이 당신의 강아지를 발견하고 우르르 다가욌다. 당신 강아지는 시선을 회피하며 코나 입을 계속 핥는다.");
                text_no.setText("조금 당황한 거 같지만 친구들이랑 같이 놀다 보면 적응할 것이다.");
                text_yes.setText("겁을 먹었다면 진정할 때까지 밖에서 기다리는 게 좋겠다.");
                if(data==0){
                    play_dog.setImageResource(R.drawable.play_dog2);
                }
            }
            else if(num==2){
                dog3.setVisibility(View.GONE);
                dog4.setVisibility(View.VISIBLE);
                guage3.setVisibility(View.VISIBLE);
                questBox.setText("강아지에게 새로운 활동을 시키기 위해 어질리티 파크를 들렸다. 강아지가 새로운 환경을 돌아다니며 훑어보고 있다.");
                text_no.setText("처음온 어질리티 파크인 만큼 무언가 시켜보기위해 강아지를 장애물 앞으로 끌고가 뛰어볼것을 권한다.");
                text_yes.setText("주변에 어질리티를 하는 다른 강아지에게 피해가 없다면 계속 돌아다니게 둡니다.");
                if(data==0){
                    play_dog.setImageResource(R.drawable.play_dog3);
                }
            } else if(num>=3){
                Intent intent = new Intent(getApplicationContext(), FinishPlayActivity.class);
                startActivity(intent);
                finish();
            }
        }
        else if(from==1){
            if(num==1){
                dog2.setVisibility(View.GONE);
                dog3.setVisibility(View.VISIBLE);
                guage2.setVisibility(View.VISIBLE);
                questBox.setText("아직 어린 강아지가 첫날에 배변 실수를 합니다.");
                text_no.setText("당황스럽고 실망이든 당신은 강아지를 혼내며 버릇을 고치려고 합니다.");
                text_yes.setText("이미 벌어진 일은 어쩔수 없으니 일단 실수한 것을 치운다.");
            } else if(num==2){
                dog3.setVisibility(View.GONE);
                dog4.setVisibility(View.VISIBLE);
                guage3.setVisibility(View.VISIBLE);
                questBox.setText("강아지를 키우면서 가장큰 로망이 강아지와 함께 산책하는것인 당신은 강아지와 산책을 나가겠습니까?");
                text_no.setText("바로 목줄을 채우고 나간다");
                text_yes.setText("아직은 산책은 이른거같아 미룹니다.");
            } else if(num>=3){
                Intent intent = new Intent(getApplicationContext(), FinishPlayActivity.class);
                startActivity(intent);
                finish();
            }
        }
        if(num>4){
            Intent intent = new Intent(getApplicationContext(), FinishPlayActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
