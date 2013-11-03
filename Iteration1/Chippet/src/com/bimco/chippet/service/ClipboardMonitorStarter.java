package com.bimco.chippet.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * When booting is completed, it starts ClipboardMonitor service to monitor the
 * states of clipboard
 * 
 */
public class ClipboardMonitorStarter extends BroadcastReceiver{
	private final String TAG = "CHIPPET";

	@Override
	public void onReceive(Context context, Intent intent) {
		if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
			ComponentName service = context.startService(new Intent(context, ClipboardMonitor.class));
			if(service==null){
				Log.e(TAG, "Can't start service" + ClipboardMonitor.class.getName());
			}
			Log.i(TAG, "The services started");
		}
		else{
			Log.e(TAG, "Received unexpected intent" + intent.toString());
		}
		
	}

}
