/* 
 * Copyright (C) Mtrust Systems, Inc - All Rights Reserved
 * Written by feelon2 <feelon2@gmail.com>, 2015-05-06
 * 
 * */
package org.jglee.blue_motor.bluecapture;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

import org.jglee.blue_motor.R;

public class LEDActivity extends ActionBarActivity {

	private Switch mSwitch = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.led);
		mSwitch = (Switch) findViewById(R.id.led_switch);
		mSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				byte[] col = null;
				if( isChecked == true ){
					// On/Off ���¿� ��� ��ް��� ���� �Ұ�
					//LED ���°� ���
					col = new byte[]{ (byte)1, -1};
				}else{
					col = new byte[]{ (byte)0, -1};
				}
				//���
				if( FIndDeviceActivity.fIndDeviceActivity != null){
					FIndDeviceActivity.fIndDeviceActivity.OnDataChangeListener(col);
				}
			}
		});
	}

}
