package com.er_to_go;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class ClientQueue extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get variables sent here.
        Bundle b = getIntent().getExtras();
        int value = -1; // or other values
        if(b == null)
            return;

        value = b.getInt("expectedTime");

        setContentView(R.layout.client); // Do Something.

        TextView tv = findViewById(R.id.waitTIme);
        tv.setText(value + " min");

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.your_turn);
            }
        };
        Button fnd;
        fnd = findViewById(R.id.goFindRoom);

        fnd.setOnClickListener(listener);

    }

}
