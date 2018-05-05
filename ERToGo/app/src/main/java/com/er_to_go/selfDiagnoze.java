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

        leg = findViewById(R.id.LEG);
        arm = findViewById(R.id.ARM);
        head = findViewById(R.id.HEAD);
        chest = findViewById(R.id.CHEST);
        stomach = findViewById(R.id.STOMACH);

        //goToBodyPart = new Intent(this, BodyPartActivity.class);

        /*
        goToLeg = new Intent(this, legActivity.class);
        goToArm = new Intent(this, armActivity.class);
        goToHead = new Intent(this, headActivity.class);
        goToChest = new Intent(this, chestActivity.class);
        goToStomach = new Intent(this, stomachActivity.class);
        */




        View.OnClickListener lLeg = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
            }
        };
        leg.setOnClickListener(lLeg);

        View.OnClickListener lArm = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
            }
        };
        arm.setOnClickListener(lArm);

        View.OnClickListener lHead = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
            }
        };
        head.setOnClickListener(lHead);

        View.OnClickListener lChest = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
            }
        };
        chest.setOnClickListener(lChest);

        View.OnClickListener lStomach = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO
            }
        };
        chest.setOnClickListener(lStomach);




    }

}



