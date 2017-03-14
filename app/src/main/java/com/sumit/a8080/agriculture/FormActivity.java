package com.sumit.a8080.agriculture;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Date;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setAlarm(View view)  {
        Log.e("abc","sdvb" + "");
        try {
            Calendar cal = Calendar.getInstance();
            long millis=cal.getTimeInMillis();
            millis+=5000;
            //millis+=25*24*3600*1000;
            cal.setTimeInMillis(millis);
            String dateString="";
            Log.e("ss", cal.toString());
            Calendar current = Calendar.getInstance();
            if (cal.compareTo(current) <= 0) {
//The set Date/Time already passed
                Toast.makeText(getApplicationContext(), "Invalid Date/Time", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
                int randomRequestCode = (int) (cal.getTimeInMillis());
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), randomRequestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
            }
        }catch (Exception e){
            Log.e("ss",e.toString());
        }
        Intent i=new Intent(this,LandScapActivity.class);
        startActivity(i);
    }
}
