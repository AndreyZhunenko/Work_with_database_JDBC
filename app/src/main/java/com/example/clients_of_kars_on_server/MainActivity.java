package com.example.clients_of_kars_on_server;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText personName;
    EditText personSername;
    Button personSignUp;
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personName = findViewById(R.id.User_name);
        personSername = findViewById(R.id.User_sername);
        personSignUp = findViewById(R.id.SignUpButton);
        test = findViewById(R.id.testWork);
    }
    DatabaseHandler dbHandler = new DatabaseHandler();

    public void SignUpOnClick (View view){
        String myName = personName.getText().toString();
        String mySername = personSername.getText().toString();

        String result = dbHandler.signUpUser(myName, mySername);
        test.setText(result);
    }
}