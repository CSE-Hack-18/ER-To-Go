package com.er_to_go;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DocLoginActivity extends AppCompatActivity {
    private Button button3;
    private EditText Name;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_login);
        button3 = (Button) findViewById(R.id.button3);

        Name = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Doc1")) && (userPassword.equals("123"))
                || (userName.equals("Doc2")) && (userPassword.equals("1234"))
                || (userName.equals("Doc3")) && (userPassword.equals("12345"))
                || (userName.equals("Doc4")) && (userPassword.equals("123456"))
                || (userName.equals("Doc5")) && (userPassword.equals("1234678"))) {
            Toast.makeText(this, "Successfully logged in :)", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, RoomsAndPatientsQueue.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Username or password are incorrect, Try again!", Toast.LENGTH_LONG).show();
        }
    }

}

