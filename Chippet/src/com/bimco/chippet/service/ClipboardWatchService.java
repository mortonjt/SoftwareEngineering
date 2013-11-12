package com.bimco.chippet.service;


import java.util.HashSet;
import java.util.Set;

import com.bimco.chippet.MainActivity;
import com.bimco.chippet.R;
import com.bimco.chippet.data.ClipboardTextGetter;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * 
 * @author jamie
 * This is the service
 */


public class ClipboardWatchService extends Service {
    
	/*Since the ClipboardManager is global
	this is the only variable that we have to change*/
	private ClipboardManager mClipboardManager;
	private OnPrimaryClipChangedListener mClipListener;
	private Set<String> clipSet;
    
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
        clipSet = new HashSet<String>(20);
 		mClipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
    }
    
    @Override
    /**
     * Starts services (aka. checks clipboard every second)
     */
    public int onStartCommand(Intent intent, int flags, int startId) {
    	try{
    		if ((mClipboardManager.hasPrimaryClip())) {
    			ClipData.Item item = mClipboardManager.getPrimaryClip().getItemAt(0);
    			String cliptext = item.getText().toString();
    			if(!clipSet.contains(cliptext)){
    				clipSet.add(cliptext);
    				Log.e("Adding string",cliptext);
    			}
    		}else{
    			ClipData clip = ClipData.newPlainText("simple text","Hello, World!");
    	        mClipboardManager.setPrimaryClip(clip);
    		}
    	}
    	catch(Exception e){
    		Log.e("Caught","Exception");
    		e.printStackTrace();
    		System.exit(0);
    	}
    	if (intent == null) {
            return START_STICKY;
        }
        
        return START_STICKY;
    }

}
