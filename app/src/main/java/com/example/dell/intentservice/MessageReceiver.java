package com.example.dell.intentservice;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by Dell on 11/13/2017.
 */

public class MessageReceiver extends ResultReceiver {
    private MainActivity.Message message;
    public MessageReceiver(MainActivity.Message message) {
        super(new Handler());
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
      message.displayMessage(resultCode, resultData);
    }
}
