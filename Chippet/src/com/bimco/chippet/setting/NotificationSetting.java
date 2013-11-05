package com.bimco.chippet.setting;

import com.bimco.chippet.service.ClipboardWatchService;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class NotificationSetting {

	static final String FILE_NAME = "notification_setting";
	static final String KEY_NOTIFICATION_SETTING = "value";

	private SharedPreferences mPreferences;

	private Context mContext;

	public NotificationSetting(Context context) {
		mPreferences = (SharedPreferences) context.getSharedPreferences(
				FILE_NAME, Context.MODE_PRIVATE);

		mContext = context;
	}

	public void setSetting(boolean enabled) {
		mPreferences.edit().putBoolean(KEY_NOTIFICATION_SETTING, enabled)
				.commit();
		act();
	}

	public boolean getSetting() {
		return mPreferences.getBoolean(KEY_NOTIFICATION_SETTING, true);
	}

	public void act() {

		actInEnabled();

	}

	public void actInEnabled() {
		Log.d("tech_tec", "start service");
		mContext.startService(new Intent(mContext, ClipboardWatchService.class));
	}

}
