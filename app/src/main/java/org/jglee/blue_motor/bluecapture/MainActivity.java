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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	private ListView mMenuList = null;
	
	private ArrayAdapter<String> mAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mMenuList = (ListView)findViewById(R.id.menu_list);
		
		mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		//mAdapter.add("Find Device");
		mAdapter.add("LED");
		mAdapter.add("RGB");
		mAdapter.add("Servo");
		mAdapter.add("I Beacon");
        
		mMenuList.setAdapter(mAdapter);
		mMenuList.setOnItemClickListener(itemClick);
	}
	
	private OnItemClickListener itemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent _i = null;
			switch (position) {
			case 0:
				_i = new Intent( MainActivity.this, LEDActivity.class );
				startActivity(_i);
				break;
			case 1:
				_i = new Intent( MainActivity.this, RGBActivity.class );
				startActivity(_i);
				break;
			case 2:
				_i = new Intent( MainActivity.this, ServoActivity.class );
				startActivity(_i);
				break;
			case 3:
				_i = new Intent( MainActivity.this, IBeaconActivity.class );
				startActivity(_i);
				break;

			default:
				break;
			}
		}
		
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_find) {
			Intent _i = null;
			_i = new Intent( MainActivity.this, FIndDeviceActivity.class );
			startActivity(_i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
