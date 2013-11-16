package com.bimco.chippet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;

import com.bimco.chippet.service.ClipboardWatchService;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.ClipData.Item;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
//private TextView mCopiedText;
	private static final long REPEAT_TIME = 1000 * 1;
	private Button mCopiedText;
	/**
	 * Basic ideas:
	 * 1) The clipboard data structure is only being called HERE
	 * 2) The global variable that ties everything together is the clipboard manager
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mCopiedText = (Button)findViewById(R.id.text_copied);
		mCopiedText.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SharedPreferences clipPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
				Map<String,?> clipmap = clipPreferences.getAll();
				ArrayList<String> clips = new ArrayList<String>((Collection<? extends String>) clipmap.values());
				for(int i = 0 ; i<clips.size();i++){
					String s = clips.get(i);
		    		Log.e("List",s);
				}
				Toast.makeText(MainActivity.this,
						R.string.copied,
						Toast.LENGTH_SHORT).show();
			}
		});

		Intent i = new Intent(getApplicationContext(), ClipboardWatchService.class);
		PendingIntent pending = PendingIntent.getBroadcast(getApplicationContext(), 0, i,
				PendingIntent.FLAG_CANCEL_CURRENT);
		Calendar cal = Calendar.getInstance();
		// Start 30 seconds after boot completed
		cal.add(Calendar.SECOND, 1);		
		// Fetch every second
		// InexactRepeating allows Android to optimize the energy consumption
		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		//am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(), pending);
		am.setInexactRepeating(AlarmManager.RTC_WAKEUP,
				cal.getTimeInMillis(), REPEAT_TIME, pending);
	}
	
	@Override
	/**
	 * This occurs when application is in the foreground (aka. not in the background)
	 */
	protected void onResume() {
		super.onResume();
	}



}
