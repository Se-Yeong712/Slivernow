package s2017s16.kr.hs.mirim.silvernow;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DowonYoon on 2017-07-11.
 */

@IgnoreExtraProperties
public class CurrentPost {
    public String day;
    public int exer1;
    public int exer2;
    public int exer3;
    public int exer4;


    public CurrentPost(){
        // Default constructor required for calls to DataSnapshot.getValue(FirebasePost.class)
    }

    public CurrentPost(String day, int exer1,int exer2,int exer3,int exer4) {


        this.day = day;
        this.exer1 = exer1;
        this.exer2 = exer2;
        this.exer3 = exer3;
        this.exer4 = exer4;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("MM월dd일");
        String formatDate = sdfNow.format(date);

        result.put("day", formatDate);
        result.put("exer1", exer1);
        result.put("exer2", exer2);
        result.put("exer3", exer3);
        result.put("exer4", exer4);
        return result;
    }
}