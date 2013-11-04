package com.bimco.chippet.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import android.content.Context;
import android.content.SharedPreferences;

public class ClipDataSource {

	

	private static final String PREFKEY = "clipss";
	private SharedPreferences clipPrefs;
	private Context context;
	
	public ClipDataSource(Context context) {
		clipPrefs = context.getSharedPreferences(PREFKEY, Context.MODE_PRIVATE);
		this.context = context;
	}
	
	public List<ClipboardTextGetter> findAll() {
		
		Map<String, ?> clipsMap = clipPrefs.getAll();
		
		SortedSet<String> keys = new TreeSet<String>(clipsMap.keySet());
		
		List<ClipboardTextGetter> clipList = new ArrayList<ClipboardTextGetter>();
		for (String key : keys) {
			ClipboardTextGetter clip = new ClipboardTextGetter(context);
			clip.setKey(key);
			clip.setText((String) clipsMap.get(key));
			clipList.add(clip);
		}
		
		return clipList;
		
	}
	
	public boolean update(ClipboardTextGetter clip) {
		
		SharedPreferences.Editor editor = clipPrefs.edit();
		editor.putString(clip.getKey(), clip.getText());
		editor.commit();
		return true;
	}
	
	public boolean remove(ClipboardTextGetter clip) {
		
		if (clipPrefs.contains(clip.getKey())) {
			SharedPreferences.Editor editor = clipPrefs.edit();
			editor.remove(clip.getKey());
			editor.commit();
		}
		
		return true;
	}
	
}
