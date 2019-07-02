package s2017s16.kr.hs.mirim.silvernow;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //    static ViewPager pager;
    Toolbar toolbar;

    Button btn_first;
    Button btn_second;
    Button btn_third;

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

        btn_first = (Button)findViewById(R.id.btn_first);
        btn_second = (Button)findViewById(R.id.btn_second);
        btn_third = (Button)findViewById(R.id.btn_third);

//        pager = (ViewPager)findViewById(R.id.pager);
//        pager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
//        pager.setCurrentItem(1);
        btn_second.setBackgroundColor(getResources().getColor(R.color.TabSelected));
        callFragment(1);

        View.OnClickListener movePageListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.btn_first:
                        btn_first.setBackgroundColor(getResources().getColor(R.color.TabSelected));
                        btn_second.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        btn_third.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        callFragment(0);
                        break;
                    case R.id.btn_second:
                        btn_first.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        btn_second.setBackgroundColor(getResources().getColor(R.color.TabSelected));
                        btn_third.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        callFragment(1);
                        break;
                    case R.id.btn_third:
                        btn_first.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        btn_second.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        btn_third.setBackgroundColor(getResources().getColor(R.color.TabSelected));
                        callFragment(2);
                        break;
                }
//                pager.setCurrentItem(tag);
            }
        };



        btn_first.setOnClickListener(movePageListener);
        btn_first.setTag(0);
        btn_second.setOnClickListener(movePageListener);
        btn_second.setTag(1);
        btn_third.setOnClickListener(movePageListener);
        btn_third.setTag(2);
    }

//    private class pagerAdapter extends FragmentStatePagerAdapter
//    {
//        public pagerAdapter(FragmentManager fm )
//        {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch(position)
//            {
//                case 0:
//                    return new Tab1Activity();
//                case 1:
//
//                    return new Tab2Activity();
//                case 2:
//
//                    return new Tab3Activity();
//                default:
//                    return null;
//            }
//        }
//
//        @Override
//        public int getCount() {
//            // total page count
//            return 3;
//        }
//
//    }


    private void callFragment(int frament_no) {

        // 프래그먼트 사용을 위해
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (frament_no) {
            case 0:
                // '프래그먼트1' 호출
                Tab1Activity fragment1 = new Tab1Activity();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;
            case 1:
                // '프래그먼트1' 호출
                Tab2Activity fragment2 = new Tab2Activity();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;

            case 2:
                // '프래그먼트2' 호출
                Tab3Activity fragment3 = new Tab3Activity();
                transaction.replace(R.id.fragment_container, fragment3);
                transaction.commit();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.action_settings:

                Toast.makeText(getApplicationContext(), "이미지출처\n\n나의 운동 현황 아이콘 : Icons made by Flat Icons from www.flaticon.com is licensed by CC 3.0 BY\n나의 운동 알람 아이콘 : Icons made by Flat Icons from www.flaticon.com is licensed by CC 3.0 BY\n나의 운동 알람 벨 : Icons made by Freepik from www.flaticon.com is licensed by CC 3.0 BY\n운동마당 눈 : Icons made by Freepik from www.flaticon.com is licensed by CC 3.0 BY\n운동마당 다리 : Icons made by Freepik from www.flaticon.com is licensed by CC 3.0 BY\n운동마당 팔 : Icons made by Freepik from www.flaticon.com is licensed by CC 3.0 BY\n운동마당 맨몸체조 : Icons made by Freepik from www.flaticon.com is licensed by CC 3.0 BY\n", Toast.LENGTH_LONG).show();
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