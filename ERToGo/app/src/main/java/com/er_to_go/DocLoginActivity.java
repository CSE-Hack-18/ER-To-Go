package com.er_to_go;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DocLoginActivity extends AppCompatActivity {
private Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_login);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRoomsAndPatientsQueue();

            }
        });
    }
    public void openRoomsAndPatientsQueue(){
        Intent intent = new Intent(this, RoomsAndPatientsQueue.class);
        startActivity(intent);
    }
}
