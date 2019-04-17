package s2017s16.kr.hs.mirim.silvernow;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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


public class EyeExerciseActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button b_stop;
    Button b_main;
    MediaPlayer mediaPlayer;

    TextView tv_title; //Intent로 전달받을 페이지 제목 - 운동 이름
    TextSwitcher ts_num_set;
    TextView tv_num_set; // Intent로 전달받을 세트수
    TextSwitcher ts_num_set_times;
    TextView tv_num_set_times; // Intent로 전달받을 세트당 횟수

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eyeexercise);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        //ActionBar actionbar=getActionBar();
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        mediaPlayer = MediaPlayer.create(EyeExerciseActivity.this, R.raw.music);
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
                Intent intent = new Intent(EyeExerciseActivity.this,EyeActivity.class);
                Toast.makeText(getApplicationContext(), "운동을 종료합니다", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });


        /*
        ImageView gif = findViewById(R.id.gif);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(gif);
        Glide.with(this).load(R.raw.eye).into(gif);

        ImageView count_gif = findViewById(R.id.count_gif);
        GlideDrawableImageViewTarget count_target = new GlideDrawableImageViewTarget(count_gif);
        Glide.with(this).load(R.raw.eye_count).into(count_gif);
        */



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // MediaPlayer 해지
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.action_settings:

                Toast.makeText(getApplicationContext(), "환경설정 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }//onOptionsItemSelected

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    private class GlideDrawableImageViewTarget {
        public GlideDrawableImageViewTarget(ImageView gif) {
        }
    }
}
