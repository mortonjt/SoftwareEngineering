package com.bimco.chippet;

import com.bimco.chippet.data.ClipboardTextGetter;
import com.bimco.chippet.greeting.InitialDescriptionView;
import com.bimco.chippet.setting.NotificationSetting;
import com.bimco.chippet.setting.NotificationSettingChangeActionImpl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
    
    private TextView mCopiedText;
    private TextView mLengthText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();
        
        new InitialDescriptionView(this).showIfInitialLaunch(); 
        
        mCopiedText = (TextView)findViewById(R.id.text_copied);
       

        NotificationSettingChangeActionImpl action = new NotificationSettingChangeActionImpl(this);
        final NotificationSetting notificationSetting = new NotificationSetting(this, action);

        CheckBox notificationSettingCheckBox = (CheckBox)findViewById(R.id.checkBox_notification_setting);
        notificationSettingCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                notificationSetting.setSetting(isChecked);
            }
        });
        
        notificationSettingCheckBox.setChecked(notificationSetting.getSetting());
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
