package com.er_to_go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserQueueStatus extends AppCompatActivity {

    //data from Bundle b
    //private String username = getIntent().getBundleExtra("EXTRA_SESSION_ID");
    private int age = getIntent().getIntExtra("age", 0);
    private int intensity = getIntent().getIntExtra("intensity", 0);
    private int bodypart = getIntent().getIntExtra("bodypart", 0);
    private boolean recurring = getIntent().getBooleanExtra("recurring", false);

    //data from Bundle c
    private int expectedTime = getIntent().getIntExtra("expectedTime", 0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_queue_status);
    }

}
