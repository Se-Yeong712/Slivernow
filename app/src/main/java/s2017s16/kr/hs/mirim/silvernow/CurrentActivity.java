
package s2017s16.kr.hs.mirim.silvernow;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.EventLogTags;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrentActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView day, ex, set;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase Database;
    ChildEventListener child;

    BarChart number_barChart;
    BarChart day_barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        //ActionBar actionbar=getActionBar();
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);


        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("");

        child = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        //파이어베이스에서 가져온 운동 종류 - 많은 순으로 최대 7개 갖고오면 되지 않을까
        ArrayList<String> number_labelList = new ArrayList();
        ArrayList<Integer> number_valList = new ArrayList();


        //파이어베이스에서 가져온 날짜별 운동 개수
        ArrayList<String> day_labelList = new ArrayList();
        ArrayList<Integer> day_valList = new ArrayList();


        number_labelList.add("눈운동");
        number_labelList.add("팔운동");
        number_labelList.add("다리운동");

        number_valList.add(1);
        number_valList.add(3);
        number_valList.add(6);


        day_labelList.add("4/15");
        day_labelList.add("4/16");
        day_labelList.add("4/17");
        day_labelList.add("4/18");
        day_labelList.add("4/19");
        day_labelList.add("4/20");
        day_labelList.add("4/21");

        day_valList.add(5);
        day_valList.add(7);
        day_valList.add(6);
        day_valList.add(2);
        day_valList.add(7);
        day_valList.add(1);
        day_valList.add(2);

        number_barChart = findViewById(R.id.current_number_chart);
        day_barChart = findViewById(R.id.current_day_chart);

        BarChartGraph(number_labelList, number_valList, number_barChart);
        BarChartGraph(day_labelList, day_valList, day_barChart);
        //List listA = new ArrayList();
    }

    private void BarChartGraph(ArrayList<String> labelList, ArrayList<Integer> valList, BarChart barChart) {

        ArrayList<BarEntry> entries = new ArrayList<>();

        for(int i=0; i < valList.size();i++){
            entries.add(new BarEntry(valList.get(i), i));
        }

        BarDataSet depenses = null;
        if (barChart==number_barChart) {
            depenses = new BarDataSet (entries, "운동별 현황");
        } else if (barChart==day_barChart) {
            depenses = new BarDataSet (entries, "날짜별 현황");
        }

        Legend number_legend = number_barChart.getLegend();
        number_legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);

        Legend day_legend = day_barChart.getLegend();
        day_legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);

        depenses.setAxisDependency(YAxis.AxisDependency.LEFT);
        depenses.setValueTextSize(10);

        ArrayList<String> labels = new ArrayList<String>();
        for(int i=0; i < labelList.size(); i++){
            labels.add((String) labelList.get(i));
        }

        BarData data = new BarData(labels,depenses); // 라이브러리 v3.x 사용하면 에러 발생함
        //depenses.setColors(ColorTemplate.VORDIPLOM_COLORS);
        depenses.setColors(ColorTemplate.JOYFUL_COLORS);

        barChart.setDescription("");
        barChart.getLegend().setEnabled(false);

        barChart.setData(data);
        barChart.animateXY(1000,1000);
        barChart.invalidate();

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setLabelCount(6, false);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setGranularity(0.1f);

        Legend l = barChart.getLegend();
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);


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
}