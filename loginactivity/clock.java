package com.example.sois.loginactivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class clock extends AppCompatActivity {
    private final String channel_id = "Notifications";
    private final int NOTIFICATION_ID = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        TextView notify = (TextView) findViewById(R.id.tv_notify);
        Button btn = (Button) findViewById(R.id.btn_notify);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display();
                Intent i = new Intent(clock.this, Final.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });
    }

    public void Display() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channel_id);
        builder.setSmallIcon(R.drawable.appnotification);
        builder.setContentTitle("DIABETES PRO");
        builder.setContentText(" WE CARE FOR YOU, SUGER LEVEL CHECK ");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(001, builder.build());

    }

}
