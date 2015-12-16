/* 
 * Copyright (C) Mtrust Systems, Inc - All Rights Reserved
 * Written by feelon2 <feelon2@gmail.com>, 2015-05-06
 * 
 * */
package org.jglee.blue_motor.bluecapture;

import com.example.bluecapture.R.integer;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class RGBActivity extends ActionBarActivity {

	private SeekBar rBar = null;
	private SeekBar gBar = null;
	private SeekBar bBar = null;

	private TextView rText = null;
	private TextView gText = null;
	private TextView bText = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rgb);
		rBar = (SeekBar)findViewById(R.id.r_bar);
		gBar = (SeekBar)findViewById(R.id.g_bar);
		bBar = (SeekBar)findViewById(R.id.b_bar);
		
		rText = (TextView)findViewById(R.id.r_label);
		gText = (TextView)findViewById(R.id.g_label);
		bText = (TextView)findViewById(R.id.b_label);

		rBar.setOnSeekBarChangeListener(red);
		gBar.setOnSeekBarChangeListener(green);
		bBar.setOnSeekBarChangeListener(blue);
	}

	private OnSeekBarChangeListener red = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			rText.setText(Integer.toString(rBar.getProgress()));
			Byte r , g , b;
			r = (byte) rBar.getProgress();
			g = (byte) gBar.getProgress();
			b = (byte) bBar.getProgress();
			//�÷��� �����
			int chosenColor = Color.rgb(rBar.getProgress(), gBar.getProgress(), bBar.getProgress());
			
			byte[] col = new byte[]{(byte) Color.red(chosenColor), (byte) Color.green(chosenColor), (byte) Color.blue(chosenColor)};
			// ���
			if( FIndDeviceActivity.fIndDeviceActivity != null){
				FIndDeviceActivity.fIndDeviceActivity.OnDataChangeListener(col);
			}
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub

		}
	};
	private OnSeekBarChangeListener green = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			gText.setText(Integer.toString(gBar.getProgress()));	
			Byte r , g , b;
			r = (byte) rBar.getProgress();
			g = (byte) gBar.getProgress();
			b = (byte) bBar.getProgress();
			
			int chosenColor = Color.rgb(rBar.getProgress(), gBar.getProgress(), bBar.getProgress());
			
			byte[] col = new byte[]{(byte) Color.red(chosenColor), (byte) Color.green(chosenColor), (byte) Color.blue(chosenColor)};
			if( FIndDeviceActivity.fIndDeviceActivity != null){
				FIndDeviceActivity.fIndDeviceActivity.OnDataChangeListener(col);
			}
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub

		}
	};
	private OnSeekBarChangeListener blue = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			bText.setText(Integer.toString(bBar.getProgress()));	
//			Byte r , g , b;
//			r = (byte) rBar.getProgress();
//			g = (byte) gBar.getProgress();
//			b = (byte) bBar.getProgress();
			
			int chosenColor = Color.rgb(rBar.getProgress(), gBar.getProgress(), bBar.getProgress());
			
			byte[] col = new byte[]{(byte) Color.red(chosenColor), (byte) Color.green(chosenColor), (byte) Color.blue(chosenColor)};
			if( FIndDeviceActivity.fIndDeviceActivity != null){
				FIndDeviceActivity.fIndDeviceActivity.OnDataChangeListener(col);
			}
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub

		}
	};

}
