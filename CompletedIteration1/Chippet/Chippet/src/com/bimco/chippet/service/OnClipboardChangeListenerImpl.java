package com.bimco.chippet.service;



import com.bimco.chippet.data.ClipboardTextGetter;

import android.content.ClipboardManager.OnPrimaryClipChangedListener;

class OnClipboardChangeListenerImpl implements OnPrimaryClipChangedListener {
    
    private ClipboardTextGetter mGetter;
    private Notification mNotification;
    
    public OnClipboardChangeListenerImpl(ClipboardTextGetter getter, Notification notification) {
        mGetter = getter;
        mNotification = notification;
    }

    @Override
    public void onPrimaryClipChanged() {
        mNotification.show(mGetter.getText());
    }
    
}
