package com.bimco.chippet.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.bimco.chippet.setting.NotificationSetting;


public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
    
        NotificationSetting notificationSetting = new NotificationSetting(context);
        notificationSetting.act();
    }

}
