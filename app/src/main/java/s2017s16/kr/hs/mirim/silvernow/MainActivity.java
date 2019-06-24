package s2017s16.kr.hs.mirim.silvernow;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
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
    //static ViewPager pager;
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

        View.OnClickListener movePageListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                int tag = (int)view.getTag();
                switch(tag){
                    case 0:
                        btn_first.setBackgroundColor(getResources().getColor(R.color.TabSelected));
                        btn_second.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        btn_third.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case 1:
                        btn_first.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        btn_second.setBackgroundColor(getResources().getColor(R.color.TabSelected));
                        btn_third.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case 2:
                        btn_first.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        btn_second.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        btn_third.setBackgroundColor(getResources().getColor(R.color.TabSelected));
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