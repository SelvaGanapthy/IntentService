package com.example.dell.intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MessageReceiver receiver=new MessageReceiver(new Message());
        Intent i=new Intent(this,TimerService.class);
        i.putExtra("timer",10);
        i.putExtra("receiver",receiver);
        startService(i);
    }
    public class Message
    {
        public void displayMessage(int resultcode,Bundle resultdata)
        {
String message=resultdata.getString("message");
            Toast.makeText(getApplicationContext(),resultcode+" "+message,Toast.LENGTH_SHORT).show();
        }
    }
}
