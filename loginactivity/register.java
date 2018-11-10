package com.example.sois.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    Button btnsubmit;
    DatabaseHelper DBOBJ;
    TextView tvReg;
    EditText namee, agee, weightt, heightt, bloodgroupp, sugarlevell;
    CheckBox male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DBOBJ = new DatabaseHelper(this);

        namee = (EditText) findViewById(R.id.et_name);
        agee = (EditText) findViewById(R.id.et_age);
        male = (CheckBox) findViewById(R.id.cb_male);
        female = (CheckBox) findViewById(R.id.cb_female);
        tvReg = (TextView) findViewById(R.id.tv_regi);
        btnsubmit = (Button) findViewById(R.id.btn_submit);

        textclickkk();
        CheckUser();

    }

    public void textclickkk() {
        tvReg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(register.this, patient_details.class);
                        startActivity(intent);
                    }
                }
        );
    }
    public void CheckUser(){
        btnsubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name=namee.getText().toString();
                        String age=agee.getText().toString();
                        String height=heightt.getText().toString();
                        String weight=weightt.getText().toString();
                        String bloodgroup=bloodgroupp.getText().toString();
                        String sugarlevel=sugarlevell.getText().toString();


                        int flag= DBOBJ.checkUser(name,age,weight,height,bloodgroup,sugarlevel);

                        if(flag==0)
                        {
                            Intent intent=new Intent(register.this,patient_details.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(register.this,"wrong Inputs",Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }

}

        /*tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(register.this, patient_details.class);
                startActivity(i);
            }
        });
    }

}
/*




public class Registration extends AppCompatActivity {

    //this is Login Page
    EditText EditName,EditPass;
    Button submit;
    DatabaseHelper DBOBJ;
    TextView txtxtx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        EditName=findViewById(R.id.textView);
        EditPass=findViewById(R.id.textView2);
        submit=findViewById(R.id.button);
        txtxtx=findViewById(R.id.textView4);
        CheckUser();
        textclickkk();
    }


 */