package com.example.sois.loginactivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class patient_details extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText namee,agee,weight,height,bloodgroup,sugarlevel;
    Button btnSubmit,btnR;
    TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        mydb=new DatabaseHelper(this);
        namee = (EditText) findViewById(R.id.etname);
        agee = (EditText) findViewById(R.id.etage);
        weight = (EditText) findViewById(R.id.etweight);
        height = (EditText) findViewById(R.id.etheight);
        bloodgroup = (EditText) findViewById(R.id.etbg);
        sugarlevel = (EditText) findViewById(R.id.etsugar);
      //  male = (CheckBox) findViewById(R.id.cb_male);
        //female = (CheckBox) findViewById(R.id.cb_female);
        txtview = (TextView) findViewById(R.id.txt_view);
        btnSubmit=(Button)findViewById(R.id.btn_submit);
        btnR=(Button)findViewById(R.id.btn_R);

        txtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(patient_details.this, clock.class);
                startActivity(i);
            }
        });

        AddData();
        viewAll();
       // textclick();
    }

  /*  public void textclick(){
        txtview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(patient_details.this,register.class);
                        startActivity(intent);
                    }
                }
        );
    }*/

    public void AddData() {
        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                   public void onClick(View view) {
                        boolean isInserted = mydb.insertData(namee.getText().toString(),
                                agee.getText().toString(),height.getText().toString(),weight.getText().toString(),bloodgroup.getText().toString(),sugarlevel.getText().toString());
                       if(isInserted==true)
                           Toast.makeText(patient_details.this,"Data inserted",Toast.LENGTH_LONG).show();
                       else
                           Toast.makeText(patient_details.this,"Data not inserted",Toast.LENGTH_LONG).show();

                    }
                }
        );

    }

    public void viewAll() {
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cr = mydb.getAlldata();
                if (cr.getCount() == 0) {
                    showmessage("Error", "Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (cr.moveToNext()) {
                    buffer.append("name :" + cr.getString(0) + "\n");
                    buffer.append("agee :" + cr.getString(1) + "\n");
                    buffer.append("height :" + cr.getString(2) + "\n");
                    buffer.append("weight :" + cr.getString(3) + "\n");
                    buffer.append("bloodgroup :" + cr.getString(4) + "\n");
                    buffer.append("sugarlevel :" + cr.getString(5) + "\n");
                    //buffer.append("NUM2 :" + cr.getString(2) + "\n");
                    //buffer.append("SUM :" + cr.getString(3) + "\n");


                }
                showmessage("Data", buffer.toString());
            }
        });
    }



    public void showmessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }




}

