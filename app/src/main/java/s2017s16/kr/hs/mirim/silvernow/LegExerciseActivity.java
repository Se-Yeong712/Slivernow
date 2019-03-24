package s2017s16.kr.hs.mirim.silvernow;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.util.LogWriter;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;


public class LegExerciseActivity extends AppCompatActivity {
    Toolbar toolbar;
    ProgressBar progressbar;
    Button b_stop;
    Button b_main;
    MediaPlayer mediaPlayer;
//    TimerTask time;
//    int timer_sec = 0;
//    int num=0;
//    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_exercise);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        //ActionBar actionbar=getActionBar();
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

//        progressbar=findViewById(R.id.progressbar);
//        Count();

        mediaPlayer = MediaPlayer.create(LegExerciseActivity.this, R.raw.music);
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
                Intent intent = new Intent(LegExerciseActivity.this,LegActivity.class);
                Toast.makeText(getApplicationContext(), "운동을 종료합니다", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        ImageView gif = findViewById(R.id.gif);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(gif);
        Glide.with(this).load(R.raw.leg).into(gif);

        ImageView count_gif = findViewById(R.id.count_gif);
        GlideDrawableImageViewTarget count_target = new GlideDrawableImageViewTarget(count_gif);
        Glide.with(this).load(R.raw.leg_count).into(count_gif);
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
                Intent intent = new Intent(LegExerciseActivity.this,GymLegActivity.class);
                startActivity(intent);
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

//    public void Count(){
//        time = new TimerTask() {
//
//            @Override
//            public void run() {
//                Log.i("Test", "Timer start");
//                Update();
//                timer_sec++;
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(time, 0, 1000);
//    }
//
//    protected void Update() {
//        Runnable updater = new Runnable() {
//            public void run() {
//                num+=5;
//                progressbar.setProgress(num);
//            }
//        };
//        handler.post(updater);
//    }
}
