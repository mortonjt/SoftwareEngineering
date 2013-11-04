package com.bimco.chippet.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardTextGetter {
	private String key;
	private String text;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private ClipboardManager mClipboardManager;

	public ClipboardTextGetter(Context context) {
		mClipboardManager = (ClipboardManager) context
				.getSystemService(Context.CLIPBOARD_SERVICE);
		Locale locale = new Locale("en_US");
		Locale.setDefault(locale);

		String pattern = "yyyy-MM-dd HH:mm:ss Z";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String key = formatter.format(new Date());
		this.setKey(key);
	}

	public String getText() {
		if (mClipboardManager.hasPrimaryClip() == false) {
			return null;
		}
		ClipData clipData = mClipboardManager.getPrimaryClip();
		Item itemAt = clipData.getItemAt(0);
		return itemAt.getText().toString();
	}

	public int getTextLength() {
		String text = getText();
		if (text == null) {
			return 0;
		}

		return text.length();
	}

	public void addOnClipboardChangeListener(
			OnPrimaryClipChangedListener listener) {
		mClipboardManager.addPrimaryClipChangedListener(listener);
	}
	
	@Override
	public String toString() {
		return this.getText();
	}

	public void setText(String text) {
			this.text = text;
		
	}
	
	
}
