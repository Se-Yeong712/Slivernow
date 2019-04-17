package s2017s16.kr.hs.mirim.silvernow;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.app.ActivityGroup;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import s2017s16.kr.hs.mirim.silvernow.R;

@SuppressWarnings("deprecation")
//public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {
public class MainActivity extends AppCompatActivity{
    Toolbar toolbar;
    private TabHost tabhost;
    TextView t_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        //ActionBar actionbar=getActionBar();
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        tabhost = (TabHost) findViewById(R.id.tabhost);
        TabHost.TabSpec spec;
        tabhost.setup();

        for(int i=0; i<tabhost.getTabWidget().getChildCount(); i++){
            TextView tv = (TextView)tabhost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            //tv.setTextColor(Color.parseColor("#ffffff"));
            tv.setTextSize(20);
           // tv.setTypeface(typeface);
        }

        spec = tabhost.newTabSpec("tab1").setContent(R.id.tab1).setIndicator("운동상식");
        tabhost.addTab(spec);

        spec = tabhost.newTabSpec("Tab2").setContent(R.id.tab2).setIndicator("나의운동");
        tabhost.addTab(spec);

        spec = tabhost.newTabSpec("Tab3").setContent(R.id.tab3).setIndicator("운동마당");
        tabhost.addTab(spec);

        tabhost.setCurrentTab(1);
        //tabhost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor(String.valueOf(R.color.TabSelected)));

        t_date = (TextView) findViewById(R.id.date);
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy년MM월dd일");
        String formatDate = sdfNow.format(date);

        t_date.setText(formatDate);

        Button b_eye = findViewById(R.id.b_eye);
        Button b_leg=findViewById(R.id.b_leg);
        Button b_alarm=findViewById(R.id.b_alarm);
        Button b_current=findViewById(R.id.b_current);

        b_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent current = new Intent(MainActivity.this, CurrentActivity.class);
                startActivity(current);
            }
        });

        b_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, GymEyeActivity.class);
                startActivity(intent2);

//                Intent intent = new Intent(MainActivity.this, GymActivity.class);
//                Window window = getLocalActivityManager().startActivity("TAB3", intent);
//                setContentView(window.getDecorView());

            }
        });

        b_leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, GymLegActivity.class);
                startActivity(intent2);

//                Intent intent = new Intent(MainActivity.this, GymActivity.class);
//                Window window = getLocalActivityManager().startActivity("TAB3", intent);
//                setContentView(window.getDecorView());

            }
        });

        b_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlarmSetActivity.class);
                startActivity(intent);
//                Intent intent = new Intent(MainActivity.this, AlarmSetActivity.class);
//                Window window = getLocalActivityManager().startActivity("TAB2", intent);
//                setContentView(window.getDecorView());
            }
        });
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


}//MainActivity