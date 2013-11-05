package com.bimco.chippet.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.bimco.chippet.setting.NotificationSetting;

/**
 * 
 * @author Yu
 * This can interact with any other application (e.g. Chrome, Text messenger)
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
    
        NotificationSetting notificationSetting = new NotificationSetting(context);
        notificationSetting.act();
    }

}
