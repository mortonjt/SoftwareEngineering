package com.bimco.chippet;

import java.util.List;

import com.bimco.chippet.data.ClipperDataSource;
import com.bimco.chippet.data.ClipperItem;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.util.*;
import android.view.Menu;
import android.widget.ArrayAdapter;

/**
 * This class represent the primary screen
 */
public class MainActivity extends ListActivity {

	private ClipperDataSource dataSource;
	private List<ClipperItem> clipperList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dataSource = new ClipperDataSource(this);
		
		refreshDisplay();
	}

	private void refreshDisplay() {
		clipperList = dataSource.findAll();
		ArrayAdapter<ClipperItem> adapter = new ArrayAdapter<ClipperItem>(this,
				R.layout.list_item_layout, clipperList);
		setListAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
