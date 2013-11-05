package com.bimco.chippet.data;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardTextGetter {

	private ClipboardManager mClipboardManager;
	/*
	 * We want to add a data structure to store the clips
	 * 1) SharedPreferences
	 * 2) Queue (*)
	 * 3) Heap 
	 */
	public ClipboardTextGetter(Context context) {
		mClipboardManager = (ClipboardManager) context
				.getSystemService(Context.CLIPBOARD_SERVICE);
	}

	/**
	 * This returns the latest copied clips from Clipboard. 
	 * @return the latest copied clips (text)
	 */
	public String getText() {
		if (mClipboardManager.hasPrimaryClip() == false) {
			return null;
		}
		
		/* 
		 *  Retrieves the most recent clip
			Note: ClipboardManager only stores one clip
		*/
		ClipData clipData = mClipboardManager.getPrimaryClip();
		Item itemAt = clipData.getItemAt(0);
		return itemAt.getText().toString();
	}
	public void addOnClipboardChangeListener(
			OnPrimaryClipChangedListener listener) {
		/*
		 * Every time clipboard has the primary clip changed, this is called
		 */
		mClipboardManager.addPrimaryClipChangedListener(listener);
	}	
}
