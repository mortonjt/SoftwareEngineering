package com.bimco.chippet;

import com.bimco.chippet.data.ClipboardTextGetter;
import com.bimco.chippet.greeting.InitialDescriptionView;
import com.bimco.chippet.setting.NotificationSetting;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    
    private TextView mCopiedText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   
        
        new InitialDescriptionView(this).showIfInitialLaunch(); 
        
        mCopiedText = (TextView)findViewById(R.id.text_copied);
       

        final NotificationSetting notificationSetting = new NotificationSetting(this);

       
     
        notificationSetting.act();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        
        ClipboardTextGetter textGetter = new ClipboardTextGetter(this);
       
        if (textGetter.getText() == null) {
            mCopiedText.setText(R.string.hint);
        } else {
            mCopiedText.setText(textGetter.getText());
        }
    }
    

}
