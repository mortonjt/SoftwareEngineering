package com.bimco.chippet.service;


import com.bimco.chippet.data.ClipboardTextGetter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;



public class ClipboardWatchService extends Service {
    
    private Notification mNotification;
    private ClipboardTextGetter mGetter;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mGetter = new ClipboardTextGetter(this);
        mNotification = new Notification(this);
     
        OnClipboardChangeListenerImpl listener = new OnClipboardChangeListenerImpl(mGetter, mNotification);
        mGetter.addOnClipboardChangeListener(listener);
    }
    
   
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return START_STICKY;
        }
        
   
        mNotification.show(mGetter.getText());
        
        return START_STICKY;
    }

}
