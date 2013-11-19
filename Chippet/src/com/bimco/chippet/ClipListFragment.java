package com.bimco.chippet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bimco.chippet.service.ClipboardWatchService;

import android.app.ListFragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



//A fragment represents a portion of user interface in an Activity
// This ClipListFragment is a portion of MainActivity interface. 
// This is the portion where we display a list of clips. 
public class ClipListFragment extends ListFragment {
	
	/*
	 * This is the array list stored all the clips
	 */
	public static List<String> allClips = new ArrayList<String>();
	

	// Instead of using a constructor, I am using a static method 
	// to create a ClipListFragment
	public static ClipListFragment newInstance() {
		return new ClipListFragment();
	}

	// This method is called whenever the MainActivity is created
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.e("On Activity Created Reached", "On Activity Created");

		// Using ArrayAdatper, we will be able to display list of string in a single TextView
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_fragment, R.id.text);
        
		setListAdapter(adapter);
        Collections.reverse(allClips);
		adapter.addAll(allClips);
		Collections.reverse(allClips);
        
	}
	


	/**
	 * Here, if we click one of the item on the list, it will set the primary clip
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		String s = (String) (getListAdapter().getItem(position));
		ClipData clip = ClipData.newPlainText("label", s);
		ClipboardWatchService.mClipboardManager.setPrimaryClip(clip);
		allClips.remove(position);

	}

}
