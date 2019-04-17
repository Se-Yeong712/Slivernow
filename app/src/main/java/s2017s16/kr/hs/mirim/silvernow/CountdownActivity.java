package s2017s16.kr.hs.mirim.silvernow;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class CountdownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        ImageView count_gif = findViewById(R.id.count_gif);
        CountdownActivity.GlideDrawableImageViewTarget count_target = new CountdownActivity.GlideDrawableImageViewTarget(count_gif);
        Glide.with(this).load(R.raw.countdown2).into(count_gif);
        startCountDown();
    }
    private void startCountDown() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(CountdownActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

    private class GlideDrawableImageViewTarget {
        public GlideDrawableImageViewTarget(ImageView gif) {
        }
    }
}
