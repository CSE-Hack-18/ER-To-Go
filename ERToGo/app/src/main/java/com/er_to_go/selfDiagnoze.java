package com.er_to_go;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class selfDiagnoze extends AppCompatActivity {

    Button leg;
    Button arm;
    Button head;
    Button chest;
    Button stomach;

    Intent goToBodyPart;

    Intent goToLeg;
    Intent goToArm;
    Intent goToHead;
    Intent goToChest;
    Intent goToStomach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self_diag);

        head = findViewById(R.id.HEAD);


        View.OnClickListener lHead = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(selfDiagnoze.this, BodyPartActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", 0); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                finish();
            }
        };
        head.setOnClickListener(lHead);


    }

}



