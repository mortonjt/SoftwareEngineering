package com.bimco.chippet.service;

import com.bimco.chippet.MainActivity;
import com.bimco.chippet.data.ClipGetter;

import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.util.Log;

/**
 * This will listen to any change on the clipboard. 
 * For example, if a user copied a new clip, this listener will know
 *
 */
public class PrimaryClipChangedListener implements OnPrimaryClipChangedListener {

    @Override
    public void onPrimaryClipChanged() {
    	
            Log.d("LISTENER", "copyclip reached");                                        
    }

}