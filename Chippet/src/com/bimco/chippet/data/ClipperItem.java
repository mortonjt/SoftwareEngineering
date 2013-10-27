package com.bimco.chippet.data;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClipperItem {
	private String key;
	private String text;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Placing the name of the class before the name of the method means that we
	 * are going to be returning an instance of this class from this method.
	 * 
	 * @return an instance of this class from this method
	 * 
	 */
	@SuppressLint("SimpleDateFormat") public static ClipperItem getNew() {

		// Locale can be used to create a data time stamp
		Locale locale = new Locale("en_US");
		Locale.setDefault(locale);

		// A simple data format class takes a string pattern that indicates the
		// format of the date time we want to get. The Z means add notation that
		// shows the offset from Greenwich mean time. We will have a completely
		// unique data time stamp that's generated from the android device. And
		// the format is sort-able from when it was created.
		String pattern = "yyyy-MM-dd HH:mm:ss Z";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		
		String key = formatter.format(new Date());
		
		// using the default no argument constructor
		ClipperItem clipper = new ClipperItem();
		
		clipper.setKey(key);
		clipper.setText("");
		return clipper;
		
	}

}
