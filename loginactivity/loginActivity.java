package com.example.sois.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class loginActivity extends AppCompatActivity {
    EditText etemail, etpassword;
    DatabaseHelper DBOBJ;
    // Button btnlogin;
    TextView tvlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etemail = (EditText) findViewById(R.id.et_email);
        etpassword = (EditText) findViewById(R.id.et_password);
        tvlogin = (TextView) findViewById(R.id.tv_login);
        // btnlogin=(Button)findViewById(R.id.btn_login);
        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginActivity.this, register.class);
                startActivity(i);

            }
        });

        String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                "\\@" +

                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                "(" +

                "\\." +

                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                ")+";


        String email = etemail.getText().toString();

        Matcher matcher = Pattern.compile(validemail).matcher(email);


        if (matcher.matches()) {
            Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(getApplicationContext(), "Enter Valid Email-Id", Toast.LENGTH_LONG).show();
        }
    }
}



