package com.bimco.chippet.data;

import java.util.*;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 
 * This class is going to hid all of the functionality that's used to put, get,
 * and remove data items from he shared preferences data storage
 */
public class ClipperDataSource {

	private static final String PREFKEY = "clipper";
	private SharedPreferences clipperPrefs;

	public ClipperDataSource(Context context) {
		clipperPrefs = context.getSharedPreferences(PREFKEY,
				Context.MODE_PRIVATE);
	}

	/**
	 * return a list of clipperItems
	 * 
	 * @return a list of clipperItems
	 */
	public List<ClipperItem> findAll() {

		// Retrieve data, unsorted
		Map<String, ?> clipperMap = clipperPrefs.getAll();

		// sort the data
		// The keySet returns a list of all the keys for all the clippers in the
		// shared preferences, the TreeSet automatically sorts the data, and
		// returns
		// it in a sorted set.
		SortedSet<String> keys = new TreeSet<String>(clipperMap.keySet());

		List<ClipperItem> clipperList = new ArrayList<ClipperItem>();

		// Loop through the keys and add associated clipper to the clipperList
		// object
		for (String key : keys) {
			ClipperItem clipper = new ClipperItem();
			clipper.setKey(key);
			clipper.setText((String) clipperMap.get(key));
			clipperList.add(clipper);
		}

		return clipperList;
	}

	// We may deleted this two methods since we might not need them
	public boolean update(ClipperItem clipper) {

		SharedPreferences.Editor editor = clipperPrefs.edit();
		editor.putString(clipper.getKey(), clipper.getText());
		editor.commit();
		return true;

	}

	public boolean remove(ClipperItem clipper) {
		
		if (clipperPrefs.contains(clipper.getKey())) {
			
			SharedPreferences.Editor editor = clipperPrefs.edit();
			editor.remove(clipper.getKey());
			editor.commit();
		}
		return true;
	}

}
