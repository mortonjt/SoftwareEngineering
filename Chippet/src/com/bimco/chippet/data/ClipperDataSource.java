package com.bimco.chippet.data;

import java.util.*;

/**
 * 
 * This class is going to hid all of the functionality that's used to put, get,
 * and remove data items from he shared preferences data storage
 */
public class ClipperDataSource {
	
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
