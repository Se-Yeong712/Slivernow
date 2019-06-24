package s2017s16.kr.hs.mirim.silvernow;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import s2017s16.kr.hs.mirim.silvernow.gym.GymArmActivity;
import s2017s16.kr.hs.mirim.silvernow.gym.GymBodyActivity;
import s2017s16.kr.hs.mirim.silvernow.gym.GymEyeActivity;
import s2017s16.kr.hs.mirim.silvernow.gym.GymLegActivity;

public class Tab3Activity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_tab3, container, false);

        Button b_eye=v.findViewById(R.id.b_eye);
        Button b_leg=v.findViewById(R.id.b_leg);
        Button b_arm=v.findViewById(R.id.b_arm);
        Button b_gym=v.findViewById(R.id.b_gym);

        b_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((MainActivity)getActivity(), GymEyeActivity.class);
                startActivity(intent);
            }
        });
        b_leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((MainActivity)getActivity(), GymLegActivity.class);
                startActivity(intent);
            }
        });
        b_arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((MainActivity)getActivity(), GymArmActivity.class);
                startActivity(intent);
            }
        });
        b_gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((MainActivity)getActivity(), GymBodyActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
//        b_eye.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent((MainActivity)getActivity(),GymEyeActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        b_eye.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(getActivity(), GymEyeActivity.class);
//                startActivity(intent2);
//            }
//        });
//
//        b_leg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(getActivity(), GymLegActivity.class);
//                startActivity(intent2);
//            }
//        });
//
//        b_alarm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), AlarmSetActivity.class);
//                startActivity(intent);
//            }
//        });

