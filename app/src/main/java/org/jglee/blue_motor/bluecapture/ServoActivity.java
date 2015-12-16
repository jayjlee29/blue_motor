/* 
 * Copyright (C) Mtrust Systems, Inc - All Rights Reserved
 * Written by feelon2 <feelon2@gmail.com>, 2015-05-06
 * 
 * */
package org.jglee.blue_motor.bluecapture;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ServoActivity extends ActionBarActivity {

	private Button servo1 = null;
	private Button servo2 = null;
	private Button servo3 = null;
	private Button servo4 = null;
	private Button servo5 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.servo);
		servo1 = (Button)findViewById(R.id.servo_1);
		servo2 = (Button)findViewById(R.id.servo_2);
		servo3 = (Button)findViewById(R.id.servo_3);
		servo4 = (Button)findViewById(R.id.servo_4);
		servo5 = (Button)findViewById(R.id.servo_5);
		
		servo1.setOnClickListener(click);
		servo2.setOnClickListener(click);
		servo3.setOnClickListener(click);
		servo4.setOnClickListener(click);
		servo5.setOnClickListener(click);
	}

	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			 byte[] col = null;
			 // ���Ͱ� �����
			switch (v.getId()) {
			case R.id.servo_1:
				//0
				 col = new byte[]{  0x01, (byte)(0)};
				break;
			case R.id.servo_2:
				//45
				 col = new byte[]{  0x01, (byte)(45)};
				break;
			case R.id.servo_3:
				//90
				 col = new byte[]{  0x01, (byte)(90)};
				break;
			case R.id.servo_4:
				//115
				 col = new byte[]{  0x01, (byte)(135)};
				break;
			case R.id.servo_5:
				//180
				 col = new byte[]{  0x01, (byte)(180)};
				break;
			default:
				break;
			}
			//���
			if( FIndDeviceActivity.fIndDeviceActivity != null){
				FIndDeviceActivity.fIndDeviceActivity.OnDataChangeListener(col);
			}
		}
	};
}
