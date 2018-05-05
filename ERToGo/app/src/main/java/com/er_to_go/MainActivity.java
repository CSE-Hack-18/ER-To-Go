package com.er_to_go;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO move somewhere else.
        Intent goToSelfDiagnoze = new Intent(this, selfDiagnoze.class);
        startActivity(goToSelfDiagnoze);
    }
}



