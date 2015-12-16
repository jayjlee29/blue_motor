/* 
 * Copyright (C) Mtrust Systems, Inc - All Rights Reserved
 * Written by feelon2 <feelon2@gmail.com>, 2015-05-06
 * 
 * */
package org.jglee.blue_motor.bluecapture;

import java.util.ArrayList;
import java.util.Collection;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.startup.BootstrapNotifier;
import org.altbeacon.data.BeaconName;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.widget.ListView;

/**
 * https://altbeacon.github.io/android-beacon-library/samples.html
 * @author dyoung
 * @author Matt Tyler
 */
public class IBeaconActivity extends Activity implements BeaconConsumer {
	protected static final String TAG = "MonitoringActivity";
	private BeaconManager beaconManager;
	
	private ListView mRegionListView;
	private SensorAdapter mRangingListAdapter;
	public ArrayList<Beacon> mRangedBeacons = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ibeacon);

		mRangedBeacons = new ArrayList<Beacon>();
		mRegionListView = (ListView)findViewById(R.id.list_ranging);
		mRangingListAdapter = new SensorAdapter(this);
		mRegionListView.setAdapter(mRangingListAdapter);
		
		beaconManager = BeaconManager.getInstanceForApplication(this);
		//�����ļ� ����
		beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout(BeaconName.NAME_1));
		beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout(BeaconName.NAME_2));
		//alt beacon
		beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout(BeaconName.NAME_3));
	        
		// Ž�� �޴��� ����	
		beaconManager.bind(this);
		
	}
	
	@Override 
	protected void onDestroy() {
		super.onDestroy();
		beaconManager.unbind(this);
	}
	@Override
	public void onBeaconServiceConnect() {

		beaconManager.setRangeNotifier(new RangeNotifier() {

			@Override
			public void didRangeBeaconsInRegion(Collection<Beacon> arg0, Region arg1) {
				//���� ����
				logToDisplay(arg0);
			}
		});


		try {
			//����Ž��
			beaconManager.startRangingBeaconsInRegion(new Region("backgroundRegion", null, null, null));
		} catch (RemoteException e) {
			e.printStackTrace();
		}


	}
	
	 private void logToDisplay( final Collection<Beacon> arg0 ) {
	    	runOnUiThread(new Runnable() {
	    	    public void run() {
	    	    	if( mRangingListAdapter != null ){
	    	    		// ����� ������Ʈ
						mRangingListAdapter.clear();
						mRangingListAdapter.updateAllBeacons(arg0);
						mRangingListAdapter.notifyDataSetChanged();
					}            	
	    	    }
	    	});
	    }
}