package com.er_to_go;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class RedirectAndSend extends AppCompatActivity {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        spinner = (ProgressBar)findViewById(R.id.progressBar1);

        Bundle b = getIntent().getExtras();
        if(b == null)
            return;

        int ep = emergencyPriority(
                b.getInt("age"),
                b.getInt("intensity"),
                b.getInt("bodypart"),
                b.getBoolean("recurring")
        );

        // Send All the stuff to some server or something.

        Intent intent = new Intent(this, ClientQueue.class);
        Bundle c = new Bundle();
        c.putInt("expectedTime", 30);
        intent.putExtras(b);
        intent.putExtras(c);
        startActivity(intent);
        startActivity(intent);
    }

    public int emergencyPriority(int age, int intensity, int bodyPart, boolean reoccuring) {
        int result = -1;

        result += ((bodyPart+1)*(age/10));

        result += result*(intensity *0.3);

        if (reoccuring) {
            result /= 1.3;
        }

        return result;
    }

}
