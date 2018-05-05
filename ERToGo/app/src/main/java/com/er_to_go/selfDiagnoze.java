package com.er_to_go;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class selfDiagnoze extends AppCompatActivity {

    Button leg;
    Button arm;
    Button head;
    Button chest;
    Button stomach;
    Button other_button;


    Intent goToBodyPart;

    Intent goToLeg;
    Intent goToArm;
    Intent goToHead;
    Intent goToChest;
    Intent goToStomach;
    ImageView person;

    TextView descriptor;

    static String highlight = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.self_diag);

        head = findViewById(R.id.HEAD);
        leg = findViewById(R.id.LEG);
        arm = findViewById(R.id.ARM);
        chest = findViewById(R.id.CHEST);
        stomach = findViewById(R.id.STOMACH);
        descriptor = findViewById(R.id.highlighted_part);
        other_button = findViewById(R.id.OTHER_BUTTON);

        person = findViewById(R.id.PERSON);


        View.OnClickListener lHead = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setImageResource(R.drawable.head);

                if (!shouldHighlight("head")) {
                    Intent intent = new Intent(selfDiagnoze.this, BodyPartActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("key", 0); //Your id
                    intent.putExtras(b); //Put your id to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        };
        head.setOnClickListener(lHead);

        View.OnClickListener lArm = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setImageResource(R.drawable.arm);

                if (!shouldHighlight("arm")) {
                    Intent intent = new Intent(selfDiagnoze.this, BodyPartActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("key", 2);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        };
        arm.setOnClickListener(lArm);

        View.OnClickListener lLeg = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setImageResource(R.drawable.leg);

                if (!shouldHighlight("leg")) {
                    Intent intent = new Intent(selfDiagnoze.this, BodyPartActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("key", 1);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        };
        leg.setOnClickListener(lLeg);

        View.OnClickListener lChest = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setImageResource(R.drawable.chest);

                if (!shouldHighlight("chest")) {
                    Intent intent = new Intent(selfDiagnoze.this, BodyPartActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("key", 3);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        };
        chest.setOnClickListener(lChest);

        View.OnClickListener lStomach = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setImageResource(R.drawable.stomach);

                if (!shouldHighlight("stomach")) {
                    Intent intent = new Intent(selfDiagnoze.this, BodyPartActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("key", 4);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        };
        stomach.setOnClickListener(lStomach);


        View.OnClickListener lOther = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(selfDiagnoze.this, BodyPartActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", 5);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        };
        other_button.setOnClickListener(lOther);

    }

    public boolean shouldHighlight(String match) {
        boolean result = !highlight.equals(match);
        if (result) {
            highlight = match;
        } else {
            highlight = "";
        }
        descriptor.setText(highlight);
        return result;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}



