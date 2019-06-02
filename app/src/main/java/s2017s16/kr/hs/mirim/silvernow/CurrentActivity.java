
package s2017s16.kr.hs.mirim.silvernow;

import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.EventLogTags;
import android.util.Log;
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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CurrentActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txt1;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase Database;
    ChildEventListener child;

    BarChart number_barChart;
    BarChart day_barChart;


    String[] exercise = {"눈 운동 ","다리 운동","팔 운동","허리 운동"};
    String[] days = new String[7];

    ArrayList<Integer> arrExer = new ArrayList<Integer>();
    ArrayList<Integer> arrDay = new ArrayList<Integer>();

    int[] dayVal = new int[7];
    int[] exerVal = new int[4];

    Calendar cal = new GregorianCalendar(Locale.KOREA);
    SimpleDateFormat fm = new SimpleDateFormat("MM월dd일");
    String searchDay,searchExer;

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

        txt1 = (TextView)findViewById(R.id.txt1);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("");

        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR,-6);

        //searchDay = fm.format(cal.getTime());
        //postFirebaseDatabase(true);

        setDays();
        getFirebaseDatabase();




        //List listA = new ArrayList();
    }

/*    public void postFirebaseDatabase(boolean add){

        String day = searchDay;
        int exer1 = 1;
        int exer2 = 5;
        int exer3 = 2;
        int exer4 = 3;

        databaseReference = FirebaseDatabase.getInstance().getReference();
        Map<String, Object> childUpdates = new HashMap<>();
        Map<String, Object> postValues = null;
        if(add){
            CurrentPost post = new CurrentPost(day, exer1, exer2, exer3,exer4);
            postValues = post.toMap();
        }
        childUpdates.put("/board/" + searchDay, postValues);
        databaseReference.updateChildren(childUpdates);
    }*/

    public void getFirebaseDatabase(){

        Database = FirebaseDatabase.getInstance();

        databaseReference = Database.getReference("board");


        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    CurrentPost get = postSnapshot.getValue(CurrentPost.class);
                    String day = get.day;
                    int[] set={get.exer1,get.exer2,get.exer3,get.exer4};

                    dataValue(day,set);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        databaseReference.addValueEventListener(postListener);

    }

    public void setDays(){
        for(int i=0;i<days.length;i++){
            days[i] = fm.format(cal.getTime());
            cal.add(Calendar.DAY_OF_YEAR,1);
            //Toast.makeText(getApplicationContext(),"date" + days[i], Toast.LENGTH_SHORT).show();
        }
    }

    public void dataValue(String day,int set[]){
        for(int i=0;i<days.length;i++){
            if(day.equalsIgnoreCase(days[i])){

                arrDay.add(set[0]+set[1]+set[2]+set[3]);
                dayVal[i] = set[0]+set[1]+set[2]+set[3];
            }
        }
        if(day.equalsIgnoreCase(days[6])){

            exerVal[0]=set[0];
            exerVal[1]=set[1];
            exerVal[2]=set[2];
            exerVal[3]=set[3];

        }

       // txt1.setText();
        drawGraph();

    }

    public void drawGraph(){
        //파이어베이스에서 가져온 운동 종류 - 많은 순으로 최대 7개 갖고오면 되지 않을까
        ArrayList<String> number_labelList = new ArrayList();
        ArrayList<Integer> number_valList = new ArrayList();


        //파이어베이스에서 가져온 날짜별 운동 개수
        ArrayList<String> day_labelList = new ArrayList();
        ArrayList<Integer> day_valList = new ArrayList();

        for(int i=0;i<exercise.length;i++){
            number_labelList.add(exercise[i]);
            number_valList.add(exerVal[i]);
        }



        for(int i=0;i<days.length;i++){
            day_labelList.add(days[i]);
            day_valList.add(dayVal[i]);

        }



        number_barChart = findViewById(R.id.current_number_chart);
        day_barChart = findViewById(R.id.current_day_chart);

        BarChartGraph(number_labelList, number_valList, number_barChart);
        BarChartGraph(day_labelList, day_valList, day_barChart);

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
        //depenses.setColors(ColorTemplate.JOYFUL_COLORS);
        depenses.setColor(Color.rgb(0,136,255));

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
