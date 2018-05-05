package com.er_to_go;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class RedirectAndSend extends AppCompatActivity {

    static int ep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);


        Bundle b = getIntent().getExtras();
        if(b == null)
            return;

        ep = emergencyPriority(
                b.getInt("age"),
                b.getInt("intensity"),
                b.getInt("bodypart"),
                b.getBoolean("reoccuring")
        );

        // Send All the stuff to some server or something.

        Intent intent = new Intent(RedirectAndSend.this, ClientQueue.class);
        Bundle c = new Bundle();
        c.putInt("expectedTime", 30);
        c.putInt("ep", ep);
        intent.putExtras(b);
        intent.putExtras(c);
        startActivity(intent);
        finish();

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
