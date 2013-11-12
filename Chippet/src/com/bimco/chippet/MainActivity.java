package com.bimco.chippet;
import com.bimco.chippet.data.ClipboardTextGetter;
import com.bimco.chippet.service.ClipboardWatchService;


import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	//Data structure for all the copied text
	private ClipboardTextGetter textGetter;

	//private TextView mCopiedText;
	private Button mCopiedText;
	//private Button mCopiedTextTester;
	/**
	 * Basic ideas:
	 * 1) The clipboard data structure is only being called HERE
	 * 2) The global variable that ties everything together is the clipboard manager
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textGetter = new ClipboardTextGetter(this);
		
		
		mCopiedText = (Button)findViewById(R.id.text_copied);		
		mCopiedText.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				/*				
				* ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
				ClipData clipData = clipboard.getPrimaryClip();
				Item itemAt = clipData.getItemAt(0);
				String s = itemAt.getText().toString();
 				*/
				String s = textGetter.pop();
				mCopiedText.setText(s);
				//ClipData clip = ClipData.newPlainText("label", "This is a tester to show the copy function of this button");
				//clipboard.setPrimaryClip(clip);//?? This will have to be replaced with a proper queue
				/*Toast = pop up message*/ 
				Toast.makeText(MainActivity.this,
						R.string.copied,
						Toast.LENGTH_SHORT).show();

			}
		});
		
		this.startService(new Intent(this, ClipboardWatchService.class));		
		
		
		/*
		 * Runs in the background
		 * Notification is a service that is run in the notification menu 
		 */
/*		final NotificationSetting notificationSetting = new NotificationSetting(this);
		notificationSetting.act();
*/
	}


	@Override
	/**
	 * This occurs when application is in the foreground (aka. not in the background)
	 */
	protected void onResume() {
		super.onResume();
		
		/*
		 * Does this clear out the ClipboardTextGetter (aka. is memory lost)?
		 */
		mCopiedText.setText(R.string.hint);
		/*
		textGetter = new ClipboardTextGetter(this);
		if (textGetter.getText() == null) {
			mCopiedText.setText(R.string.hint);
		} else {
			mCopiedText.setText(textGetter.getText());
		}
*/	
	}



}
