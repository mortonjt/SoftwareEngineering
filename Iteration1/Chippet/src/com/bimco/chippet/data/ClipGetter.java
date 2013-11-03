package com.bimco.chippet.data;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;

/**
 * This will help to get the text from android system clipboard.
 * 
 *
 */
public class ClipGetter {

	private ClipboardManager mClipboardManager;

	public ClipGetter(Context context) {
		mClipboardManager = (ClipboardManager) context
				.getSystemService(Context.CLIPBOARD_SERVICE);
	}

	public String getText() {
		if (!(mClipboardManager.hasPrimaryClip())) {
			return null;
		}
		ClipData clipData = mClipboardManager.getPrimaryClip();
		Item item = clipData.getItemAt(0);
		return item.getText().toString();
	}

	public void addOnClipboardChangeListener(
			OnPrimaryClipChangedListener listener) {
		mClipboardManager.addPrimaryClipChangedListener(listener);
	}

}
