package s2017s16.kr.hs.mirim.silvernow.exercise.body;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import s2017s16.kr.hs.mirim.silvernow.CurrentPost;
import s2017s16.kr.hs.mirim.silvernow.MainActivity;
import s2017s16.kr.hs.mirim.silvernow.PopupActivity;
import s2017s16.kr.hs.mirim.silvernow.R;
import s2017s16.kr.hs.mirim.silvernow.exercise.arm.ArmExerciseActivity;


public class BodyExerciseActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button b_stop;
    Button b_main;
    MediaPlayer mediaPlayer;

    TextView tv_title; //Intent로 전달받을 페이지 제목 - 운동 이름
    TextSwitcher ts_num_set;
    TextView tv_num_set; // Intent로 전달받을 세트수
    TextSwitcher ts_num_set_times;
    TextView tv_num_set_times; // Intent로 전달받을 세트당 횟수

    private  Boolean isRunning = true;

    //TextSwitcher는 <TextSwitcher></TextSwitcher>안에 있는 Text가 바뀔 때 애니메이션 넣을 수 있을 것 같아서 해둔거

    //사용 예시 - sleep으로 지연시키고 setText하는 방식
    /*
        try {
        mSwitcher.setText("ON");
        Thread.sleep(1000);
        mSwitcher.setText("OFF");
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }*/

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getInstance().getReference("board");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_exercise);

        tv_num_set = (TextView)findViewById(R.id.textview_num_set);
        tv_num_set_times=(TextView) findViewById(R.id.textview_num_set_times);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        //ActionBar actionbar=getActionBar();
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
//        actionbar.setDisplayHomeAsUpEnabled(true);


        mediaPlayer = MediaPlayer.create(BodyExerciseActivity.this, R.raw.music);
        mediaPlayer.start();

        b_stop=findViewById(R.id.b_stop);
        b_main=findViewById(R.id.b_main);

        b_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 정지버튼
                mediaPlayer.stop();
                // 초기화
                mediaPlayer.reset();
            }
        });

        b_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                Intent intent = new Intent(EyeExerciseActivity.this,EyeActivity.class);
                Toast.makeText(getApplicationContext(), "운동을 종료합니다", Toast.LENGTH_LONG).show();
                startActivity(intent);*/

                BodyExerciseActivity eyeExe = new BodyExerciseActivity();
                eyeExe.finish();

                android.os.Process.killProcess(android.os.Process.myPid());
                return;


            }
        });



        ImageView gif = findViewById(R.id.gif);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(gif);
        Glide.with(this).load(R.raw.body).into(gif);

//        (new Thread(new Runnable()
//        {
//        @Override
//        public void run() {
//            final int[] num = {40000};
//            while (!Thread.interrupted()) {
//                try {
//                    Thread.sleep(1000);
//                    runOnUiThread(new Runnable() // start actions in UI thread
//                    {
//
//                        @Override
//                        public void run() {
//                            num[0] -= 1000;
//                            tv_num_set_times.setText(num[0]);
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    // ooops
//                }
//            }
//        }
//    })).start();

        timeThread t = new timeThread();
        t.start();
        if(isRunning==false){
            Log.d("suyoung","제발 러닝 끝나서 성공");
        }

    }//onCreate



    public class timeThread extends Thread{
        int set_count=0;
        String formatDate;
        int a=2;
        int count=0;
        int b=1;
        int i=0;
        @Override
        public void run(){

            while (isRunning){
                Message msg = new Message();


/*                                    if(count%2==0){
                                        b=2;
                                    }else{
                                        b=1;
                                    }*/



                msg.arg1 = a;
                msg.arg2 = b;

                if(b==1){
                    --a;
                }

                handler.sendMessage(msg);
                try {
                    count++;
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }

                if(count==2){
                    isRunning = false;
                }
            }
            if(isRunning==false) {

                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat sdfNow = new SimpleDateFormat("MM월dd일");
                formatDate = sdfNow.format(date);

//                int leg_num = 0, arm_num = 0, gym_num = 0;
                set_count=a;

//

//                myRef=database.getReference("board");
//                myRef.child(formatDate).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        //for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                            Map<String, Object> childUpdates = new HashMap<>();
//                            Map<String, Object> postValues = null;
//
//                            CurrentPost currentPost = new CurrentPost();
//                            postValues = currentPost.toMap();
//
//                            childUpdates.put(formatDate, postValues);
//                            myRef.updateChildren(childUpdates);
//                        //}
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });




                myRef=database.getReference("board");
                myRef.child(formatDate).addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                // Get user value
                                //for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                                CurrentPost post = dataSnapshot.getValue(CurrentPost.class);
                                if(post==null){
                                    post.exer4=0;
                                }
                                post.exer4+=1;

                                Map<String, Object> childUpdates = new HashMap<>();
                                Map<String, Object> postValues = null;

                                postValues = post.toMap();
//                                    if(post.exer1==0){
//                                        childUpdates.put(formatDate,postValues);
//                                        myRef.updateChildren(childUpdates);
//                                    }
                                childUpdates.put(formatDate, postValues);
                                myRef.updateChildren(childUpdates);
                                Log.i("dbdb", "eye_num : " + post.exer4);
                                //}
                                finish();
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Log.w("dbdb", "getUser:onCancelled", databaseError.toException());
                            }
                        });





                Intent intent = new Intent(BodyExerciseActivity.this, PopupActivity.class);
                startActivityForResult(intent,1);
                finish();
            }

        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            tv_num_set.setText(msg.arg1 +"");
            tv_num_set_times.setText(msg.arg2+"");
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // MediaPlayer 해지
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }



    private class GlideDrawableImageViewTarget {
        public GlideDrawableImageViewTarget(ImageView gif) {
        }
    }
}
