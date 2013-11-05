package com.bimco.chippet.greeting;

import android.content.Context;
import android.content.SharedPreferences;



public class InitialDescriptionView {
    
    static final String FILE_NAME = "initial";
    static final String INITIAL_LAUNCH_KEY = "initial_launch";
    
    private Context mContext;
    
    public InitialDescriptionView(Context context) {
        mContext = context;
    }
    
    public void showIfInitialLaunch() {
       
        SharedPreferences preferences = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        if (preferences.getBoolean(INITIAL_LAUNCH_KEY, false)) {
            return;
        }
        preferences.edit().putBoolean(INITIAL_LAUNCH_KEY, true).commit();
        
    }
    
}
