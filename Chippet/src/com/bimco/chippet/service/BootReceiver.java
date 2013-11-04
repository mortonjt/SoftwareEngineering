package com.bimco.chippet.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.bimco.chippet.setting.NotificationSetting;
import com.bimco.chippet.setting.NotificationSettingChangeAction;
import com.bimco.chippet.setting.NotificationSettingChangeActionImpl;


public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationSettingChangeAction action = new NotificationSettingChangeActionImpl(context);
        NotificationSetting notificationSetting = new NotificationSetting(context, action);
        notificationSetting.act();
    }

}
