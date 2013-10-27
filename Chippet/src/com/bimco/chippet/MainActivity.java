package com.bimco.chippet;

import java.util.List;

import com.bimco.chippet.data.ClipperDataSource;
import com.bimco.chippet.data.ClipperItem;

import android.os.Bundle;
import android.app.Activity;
import android.util.*;
import android.view.Menu;

/**
 * This class represent the primary screen
 */
public class MainActivity extends Activity {
	
	private ClipperDataSource dataSource;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        dataSource = new ClipperDataSource();
        List<ClipperItem> clipperLists = dataSource.findAll();
        ClipperItem clipper = clipperLists.get(0); 
        
        
        Log.i("CLIPOER", clipper.getKey());
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
