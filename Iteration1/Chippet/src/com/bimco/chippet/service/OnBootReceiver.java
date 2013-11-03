package com.bimco.chippet.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OnBootReceiver extends BroadcastReceiver{

    private static final String TAG = "Boot Receiver";
    
	@Override
	public void onReceive(Context context, Intent intent) {
		//Log.d(TAG,"Received");
        Intent startServiceIntent = new Intent(context, NotificationService.class);
        context.startService(startServiceIntent);
		
	}

}
