package s2017s16.kr.hs.mirim.silvernow;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class CurrentActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button database;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase Database;
    ChildEventListener child;

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
        databaseReference = FirebaseDatabase.getInstance().getReference();



;


    }
}
