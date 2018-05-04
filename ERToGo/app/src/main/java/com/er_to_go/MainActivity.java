package com.er_to_go;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;





public class MainActivity extends AppCompatActivity {

    Button rightLeg;
    Intent goToBodyPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rightLeg = (Button)findViewById(R.id.rightLeg);
        goToBodyPart = new Intent(this, BodyPartActivity.class);

        setContentView(R.layout.self_diagnoze);

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                startActivity(goToBodyPart);
            }
        };
        rightLeg.setOnClickListener(btnListener);
    }

}



