package com.bimco.chippet.service;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.bimco.chippet.MainActivity;
import com.bimco.chippet.R;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

/**
 * 
 * @author jamie
 * This is the service that copies clips and stores them into a data structure
 * 
 * There are 3 different data structures being used here
 * 1) A queue to keep track of the order in which clips were copied
 * 2) A set to make sure that duplicate words aren't copied
 * 3) A SharedPreferences object to store the clipboard words
 * 
 * Now there are two different ways to access the clipboard
 * 1) Obtain access to the ClipboardWatchService
 * (e.g. 
 * private final String SERVICE ="com.bimco.chippet.service.ClipboardWatchService";
 * )
 * 
 * 2) Obtain access to the SharedPreferences
 * (e.g.
 * clipPreferences = PreferenceManager.getDefaultSharedPreferences(this);
 * )
 * 
 * Things to consider
 * 1) The SharedPreferences is created only in onCreate.  Will we want to save/load SharedPreferences?
 */


public class ClipboardWatchService extends Service {
    
	/*Since the ClipboardManager is global
	this is the only variable that we have to change*/
	private ClipboardManager mClipboardManager;
	private OnPrimaryClipChangedListener mClipListener;
	private Set<String> clipSet;
	private Queue<String> clipQueue;
	private SharedPreferences clipPreferences;
	private int numElements = 3;  //This needs to be initalized by config file 
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
 		clipQueue = new LinkedList<String>();
 		clipPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }
    /**
     * Adds clip to the data structure
     */
    public void addClip(String cliptext){
    	if(!clipSet.contains(cliptext)){
    		clipSet.add(cliptext);
    		clipQueue.add(cliptext);
    		Editor editor = clipPreferences.edit();
			editor.putString(cliptext, cliptext);
			Log.e("Adding string",cliptext);
			if(clipQueue.size()>numElements){
    			String removed = clipQueue.poll();
    			clipSet.remove(removed);
    			editor.remove(removed);
    			Log.e("Removing string",removed);
    		}
    		editor.commit();
    		
    	}
    }

    private void savePreferences(String key, String value) {
    	SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    	Editor editor = sharedPreferences.edit();
    	editor.putString(key, value);
    	editor.commit();	
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
    			//if(!clipSet.contains(cliptext)){
    			addClip(cliptext);    			
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
