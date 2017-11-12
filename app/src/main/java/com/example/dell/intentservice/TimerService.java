package com.example.dell.intentservice;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Dell on 11/13/2017.
 */

public class TimerService extends IntentService {
    public TimerService() {
        super("Timer Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Timer", "Timerservice is started");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        super.onStartCommand(intent, flags, startId);
        return START_STICKY;

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            int time = 5;
            for (int i = 0; i < time; i++) {
                Log.v("timer", "i=" + i);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }

            }
            NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
            nb.setContentText("Timer done");
            nb.setContentTitle("hi");
            nb.setSmallIcon(R.mipmap.ic_launcher);
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(1,nb.build());
            return;
        }
        ResultReceiver receiver = intent.getParcelableExtra("receiver");
        int time = intent.getIntExtra("timer", 0);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("message", "Counting done....");
        receiver.send(1234, bundle);
    }
}
