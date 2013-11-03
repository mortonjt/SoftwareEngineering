package com.bimco.chippet.setting;

import com.bimco.chippet.service.ClipboardWatchService;

import android.content.Context;
import android.content.Intent;
import android.util.Log;



public class NotificationSettingChangeActionImpl implements NotificationSettingChangeAction {
    
    private Context mContext;
    
    public NotificationSettingChangeActionImpl(Context context) {
        mContext = context;
    }
    
    @Override
    public void actInEnabled() {
        Log.d("tech_tec", "start service");
        mContext.startService(new Intent(mContext, ClipboardWatchService.class));
    }

    @Override
    public void actInDisabled() {
        Log.d("tech_tec", "stop service");
        mContext.stopService(new Intent(mContext, ClipboardWatchService.class));
    }

}
