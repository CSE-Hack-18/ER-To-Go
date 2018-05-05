package com.er_to_go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserQueueStatus extends AppCompatActivity {

    //data from Bundle b
    //private String username = getIntent().getBundleExtra("username");
    private int age = getIntent().getIntExtra("age", 0);
    private int intensity = getIntent().getIntExtra("intensity", 0);
    private int bodypart = getIntent().getIntExtra("bodypart", 0);
    private boolean recurring = getIntent().getBooleanExtra("recurring", false);

    //data from Bundle c
    private int expectedTime = getIntent().getIntExtra("expectedTime", 0);


    String greet = "Dear " + bodypart;
    String state = "Average waiting time based on your injury: " + 30 + "minutes";
    String information = "You have input the following information:\nage:" + age +"\nintensity: " + intensity + "\nbodypart: " + bodypart + "\nrecurring: " + recurring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_queue_status);

        TextView greeting = findViewById(R.id.greetUser);
        greeting.setText(greet);


        TextView status = findViewById(R.id.userStatus);
        status.setText(state);

        TextView info = findViewById(R.id.showInput);
        status.setText(information);



    }
}
