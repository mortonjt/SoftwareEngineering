package com.bimco.chippet;

import com.bimco.chippet.service.ClipboardWatchService;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private static final String TAG_LIST = "list";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		   
        this.startService(new Intent(this, ClipboardWatchService.class));
        
        /**
         * This will start the ClipListFragment, which will be used to display a list of data
         */
        Fragment fragment = getFragmentManager().findFragmentByTag(TAG_LIST);
        if (fragment == null) {
            fragment = ClipListFragment.newInstance();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(android.R.id.content, fragment, TAG_LIST);
            ft.commit();
        }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		
		final CharSequence[] items = {"2", "4", "8", "10"};
		Log.e("Seeting", "Setting");
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Choose how many clips to display:");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(which==0)
					ClipListFragment.numClips=2;
				else if(which==1)
					ClipListFragment.numClips=4;
				else if(which ==2)
					ClipListFragment.numClips =8;
				else
					ClipListFragment.numClips = 10;
				
			}
		});
		
		AlertDialog alert = builder.create();
		alert.show();
		
		return super.onOptionsItemSelected(item);
	}

}
