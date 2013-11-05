package com.bimco.chippet;
import com.bimco.chippet.data.ClipboardTextGetter;
import com.bimco.chippet.setting.NotificationSetting;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	//Data structure for all the copied text
	ClipboardTextGetter textGetter;

	// private TextView mCopiedText;
	private Button mCopiedText;
	private Button mCopiedTextTester;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		mCopiedText = (Button)findViewById(R.id.text_copied);
		mCopiedText.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

				ClipData clip = ClipData.newPlainText("label", textGetter.getText());
				clipboard.setPrimaryClip(clip);
				Toast.makeText(MainActivity.this,
						R.string.copied,
						Toast.LENGTH_SHORT).show();

			}
		});
		mCopiedTextTester = (Button)findViewById(R.id.text_tester);
		
		/**
		 * Questions:
		 * 1) Probably need another class for this
		 * 2) How to handle multiple copies???
		 */
		mCopiedTextTester.setText("This is a Tester to show the copy function of the button");
		mCopiedTextTester.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

				ClipData clip = ClipData.newPlainText("label", "This is a tester to show the copy function of this button");
				clipboard.setPrimaryClip(clip);//?? This will have to be replaced with a proper queue
				/*Toast = pop up message*/ 
				Toast.makeText(MainActivity.this,
						R.string.copied,
						Toast.LENGTH_SHORT).show();

			}
		});
		/*
		 * Runs in the background
		 * Notification is a service that is run in the notification menu 
		 */
		final NotificationSetting notificationSetting = new NotificationSetting(this);
		notificationSetting.act();

	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 * 
	 * This occurs when application is in the foreground (aka. not in the background)
	 */
	protected void onResume() {
		super.onResume();
		/*
		 * Does this clear out the ClipboardTextGetter (aka. is memory lost)?
		 */
		textGetter = new ClipboardTextGetter(this);

		if (textGetter.getText() == null) {
			mCopiedText.setText(R.string.hint);
		} else {
			mCopiedText.setText(textGetter.getText());
		}
	}



}
