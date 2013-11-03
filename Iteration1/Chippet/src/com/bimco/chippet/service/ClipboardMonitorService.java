package com.bimco.chippet.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ClipboardMonitorService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	private static void showServiceNotification(Context context){
		NotificationManager notificationManager = (NotificationManager) context.getSystemService("Notification");
		Notification notification = new Notification();
		//PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, ), 0);
	}
	
*/
}
