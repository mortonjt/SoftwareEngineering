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
	
	
	public ClipperDataSource(Context context){
		clipperPrefs = context.getSharedPreferences(PREFKEY, Context.MODE_PRIVATE);
	}
	
	/**
	 * return a list of clipperItems
	 * @return a list of clipperItems
	 */
	public List<ClipperItem> findAll(){
		
		List<ClipperItem> clipperList = new ArrayList<ClipperItem>();
		ClipperItem clipper = ClipperItem.getNew();
		clipperList.add(clipper);
		return clipperList;
	}
	
	
	
	public boolean update(ClipperItem clipper){
		
		return true;
		
	}
	
	public boolean remove(ClipperItem clipper){
		return true;
	}

}
