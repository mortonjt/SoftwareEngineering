package com.bimco.chippet.setting;

import com.bimco.chippet.service.ClipboardWatchService;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class NotificationSetting {

	private Context mContext;

	public NotificationSetting(Context context) {
		mContext = context;
	}

	public void act() {
		actInEnabled();
	}

	public void actInEnabled() {
		Log.d("tech_tec", "start service");
		/*
		 * This starts service
		 * Question: Do we want to keep this in here, or move it to MainActivity
		 */
		mContext.startService(new Intent(mContext, ClipboardWatchService.class));
	}

}
