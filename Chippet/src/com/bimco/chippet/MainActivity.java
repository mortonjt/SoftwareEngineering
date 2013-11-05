package com.bimco.chippet;
import com.bimco.chippet.data.ClipboardTextGetter;
import com.bimco.chippet.greeting.InitialDescriptionView;
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
       
       
        new InitialDescriptionView(this).showIfInitialLaunch(); 
         
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
       
       mCopiedTextTester.setText("This is a Tester to show the copy function of the button");
       mCopiedTextTester.setOnClickListener(new View.OnClickListener() {
       
		@Override
		public void onClick(View v) {
			ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		
			ClipData clip = ClipData.newPlainText("label", "This is a tester to show the copy function of this button");
			clipboard.setPrimaryClip(clip);
			 Toast.makeText(MainActivity.this,
                     R.string.copied,
                     Toast.LENGTH_SHORT).show();
			
		}
	});

        final NotificationSetting notificationSetting = new NotificationSetting(this);
        notificationSetting.act();
     
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	textGetter = new ClipboardTextGetter(this);
    	
    	if (textGetter.getText() == null) {
    		mCopiedText.setText(R.string.hint);
    	} else {
    		mCopiedText.setText(textGetter.getText());
    	}
    }
  
    

}
