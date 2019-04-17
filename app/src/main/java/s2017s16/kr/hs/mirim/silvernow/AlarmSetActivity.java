package s2017s16.kr.hs.mirim.silvernow;

import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import android.view.View;

public class AlarmSetActivity extends AppCompatActivity {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    Context context;
    PendingIntent pendingIntent;
    Toolbar toolbar;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_set);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        //ActionBar actionbar=getActionBar();
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    public void showAlarmDialog(View view) {
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(getSupportFragmentManager(), "timePicker");

    }
//        this.context = this;
//
//        // 알람매니저 설정
//        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
//
//        // 타임피커 설정
//        alarm_timepicker = findViewById(R.id.time_picker);
//
//        // Calendar 객체 생성
//        final Calendar calendar = Calendar.getInstance();
//
//        // 알람리시버 intent 생성
//        final Intent my_intent = new Intent(this.context, Alarm_Receiver.class);
//
//        // 알람 시작 버튼
//        Button alarm_on = (Button)findViewById(R.id.btn_start);
//        alarm_on.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View v) {
//
//                // calendar에 시간 셋팅
//                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
//                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());
//
//                // 시간 가져옴
//                int hour = alarm_timepicker.getHour();
//                int minute = alarm_timepicker.getMinute();
//                Toast.makeText(AlarmSetActivity.this,"Alarm 예정 " + hour + "시 " + minute + "분",Toast.LENGTH_SHORT).show();
//
//                // reveiver에 string 값 넘겨주기
//                my_intent.putExtra("state","alarm on");
//
//                pendingIntent = PendingIntent.getBroadcast(AlarmSetActivity.this, 0, my_intent,
//                        PendingIntent.FLAG_UPDATE_CURRENT);
//
//                // 알람셋팅
//                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                        pendingIntent);
//            }
//        });
//
//        // 알람 정지 버튼
//        Button alarm_off = findViewById(R.id.btn_finish);
//        alarm_off.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Toast.makeText(context, "", Toast.LENGTH_SHORT).show();.makeText(MainActivity.this,"Alarm 종료",Toast.LENGTH_SHORT).show();
//                // 알람매니저 취소
//                alarm_manager.cancel(pendingIntent);
//
//                my_intent.putExtra("state","alarm off");
//
//                // 알람취소
//                sendBroadcast(my_intent);
//            }
//        });


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
}
