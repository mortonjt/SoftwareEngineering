package com.bimco.chippet.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OnBootReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Notification mNotification = new Notification(context);
		mNotification.startClipBoardWatchService();
		
	}
	
	

}
