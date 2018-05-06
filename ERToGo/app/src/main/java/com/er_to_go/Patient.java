package com.er_to_go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Patient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient);


        Bundle b = getIntent().getExtras();
        String value = ""; // or other values
        if(b != null)
            value = b.getString("str");
        else
            return;

        TextView inj =
                findViewById(R.id.patient_stuff);
        inj.setText(value);

        int pos = ((int)(Math.random() * 100) % BodyPartActivity.images.length);

        ImageView img = findViewById(R.id.BODY_PART_IMAGE2);
        img.setImageResource(BodyPartActivity.images[pos]);



    }

}
