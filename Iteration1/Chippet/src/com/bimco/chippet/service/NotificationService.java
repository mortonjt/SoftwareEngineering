package com.bimco.chippet.service;

import com.bimco.chippet.MainActivity;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class NotificationService {
	private Context mContext;
	private NotificationManager mNotificationManager;
	
	public NotificationService(Context context){
		mContext = context;
		mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
	}
	
	public void show(int stringLength, String string){
		 Intent intent = new Intent(mContext, MainActivity.class);
	     PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0);
	     
	}

}
