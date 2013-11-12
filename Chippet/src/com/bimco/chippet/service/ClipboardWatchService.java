package com.bimco.chippet.service;


import com.bimco.chippet.data.ClipboardTextGetter;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * 
 * @author jamie
 * This is the service
 */


public class ClipboardWatchService extends Service {
    
	/*Since the ClipboardManager is global
	this is the only variable that we have to change*/
	private ClipboardManager mClipboardManager;
    /*
     * (non-Javadoc)
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    /**
     * Creates clipboard service
     */
    @Override
    public void onCreate() {
        super.onCreate();

 		mClipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);        

//        mGetter = new ClipboardTextGetter(this);         
//        OnClipboardChangeListenerImpl listener = new OnClipboardChangeListenerImpl(mGetter);
//        mGetter.addOnClipboardChangeListener(listener);
    }
    
    
    @Override
    /**
     * Starts services
     */
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return START_STICKY;
        }
        ClipData clip = ClipData.newIntent("Intent",intent);
        mClipboardManager.setPrimaryClip(clip);
        /*mNotification.show(mGetter.getText());
        */
        return START_STICKY;
    }

}
