package com.bimco.chippet.service;

import com.bimco.chippet.data.ClipGetter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * This will monitor the cliboard activity
 *
 */
public class ClipboardMonitor extends Service {

	private ClipGetter mGetter;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mGetter = new ClipGetter(this);
		PrimaryClipChangedListener listener = new PrimaryClipChangedListener();
		mGetter.addOnClipboardChangeListener(listener);
	}
}
