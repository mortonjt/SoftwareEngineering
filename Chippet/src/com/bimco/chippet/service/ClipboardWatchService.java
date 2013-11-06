package com.bimco.chippet.service;


import com.bimco.chippet.data.ClipboardTextGetter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;



public class ClipboardWatchService extends Service {
    
/*    private Notification mNotification;
*/
	private ClipboardTextGetter mGetter;

    /*
     * (non-Javadoc)
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mGetter = new ClipboardTextGetter(this); 
        
        OnClipboardChangeListenerImpl listener = new OnClipboardChangeListenerImpl(mGetter);
        mGetter.addOnClipboardChangeListener(listener);
    }
    
   
    @Override
    /*
     * (non-Javadoc)
     * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
     Question: 
     1) What is START_STICKY?
     2) What does this do!?!!
     */
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return START_STICKY;
        }
        /*mNotification.show(mGetter.getText());
        */
        return START_STICKY;
    }

}
