package com.bimco.chippet.service;

import java.util.Map;

import com.bimco.chippet.MainActivity;
import com.bimco.chippet.R;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;



class Notification {
    
    static int NOTIFICATION_ID = 315;
    
    private Context mContext;
    private NotificationManager mNotificationManager;
    
    Notification(Context context) {
        mContext = context;
        mNotificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
    }
    
    void show(String string) {
        Intent intent = new Intent(mContext, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0);
        
        String message = (string == null) ? mContext.getString(R.string.hint) : string;
        
 
        @SuppressWarnings("deprecation")
		android.app.Notification notification = new android.app.Notification.Builder(mContext)
                                                    .setContentText(message)
                                                    .setSmallIcon(R.drawable.ic_launcher)
                                                    .setContentIntent(pendingIntent)
                                                    .getNotification();
        mNotificationManager.notify(NOTIFICATION_ID, notification);
        

    }
    
    void dismiss() {
        mNotificationManager.cancel(NOTIFICATION_ID);
    }
    
}
