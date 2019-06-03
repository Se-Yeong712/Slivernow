package s2017s16.kr.hs.mirim.silvernow;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Tab2Activity extends Fragment {
    public Tab2Activity()
    {
        // required
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,Bundle SavedInstanceState){
        View v = inflater.inflate(R.layout.activity_tab2, container, false);

        Button b_current=v.findViewById(R.id.b_current);
        Button b_alarm=v.findViewById(R.id.b_alarm);

        b_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((MainActivity)getActivity(),CurrentActivity.class);
                startActivity(intent);
            }
        });

        b_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((MainActivity)getActivity(),AlarmSetActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}

