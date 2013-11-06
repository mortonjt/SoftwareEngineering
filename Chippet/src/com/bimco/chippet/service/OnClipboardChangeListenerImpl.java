package com.bimco.chippet.service;



import com.bimco.chippet.data.ClipboardTextGetter;

import android.content.ClipboardManager.OnPrimaryClipChangedListener;

public class OnClipboardChangeListenerImpl implements OnPrimaryClipChangedListener {
    
    private ClipboardTextGetter mGetter;
    
    public OnClipboardChangeListenerImpl(ClipboardTextGetter getter) {
        mGetter = getter;
    }

    @Override
    public void onPrimaryClipChanged() {
        //mNotification.show(mGetter.getText());
    }
    
}
