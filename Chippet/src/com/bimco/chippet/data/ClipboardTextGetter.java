package com.bimco.chippet.data;

import java.util.LinkedList;
import java.util.Queue;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;

public class ClipboardTextGetter {

	private ClipboardManager mClipboardManager;
	private Queue<String> clipQueue;
	/*
	 * We want to add a data structure to store the clips
	 * 1) SharedPreferences
	 * 2) Queue (*)
	 * 3) Heap 
	 */
	public ClipboardTextGetter(Context context) {
		mClipboardManager = (ClipboardManager) context
				.getSystemService(Context.CLIPBOARD_SERVICE);
		this.addOnClipboardChangeListener();
		clipQueue = new LinkedList<String>();
	}
	
	/*
	 * Returns the Clip at the top of the queue
	 */
	public String pop(){
		String head = clipQueue.poll();
		return head;
	}
	public void add(String s){
		clipQueue.add(s);
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
		try{
			ClipData clipData = mClipboardManager.getPrimaryClip();
			Item itemAt = clipData.getItemAt(0);
			return itemAt.getText().toString();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * Note: This automatically appends the string to the queue
	 */
	public void addOnClipboardChangeListener() {
		/*
		 * Every time clipboard has the primary clip changed, this is called
		 */

		mClipboardManager.addPrimaryClipChangedListener(new OnPrimaryClipChangedListener() {

			@Override
			public void onPrimaryClipChanged() {
				try{
					ClipData currentClip = mClipboardManager.getPrimaryClip();
					Item itemAt = currentClip.getItemAt(0);
					String cliptext = itemAt.getText().toString();
					Log.e("Adding string",cliptext);
					add(cliptext);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
        });
				
	}	
}
