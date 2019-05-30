package s2017s16.kr.hs.mirim.silvernow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by dbstn on 2019-05-30.
 */

public class PopupActivity extends AppCompatActivity {
    Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_popup);

        okBtn = (Button) findViewById(R.id.okBtn);
    }


    public void mOk(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent,1);
        finish();
    }


}