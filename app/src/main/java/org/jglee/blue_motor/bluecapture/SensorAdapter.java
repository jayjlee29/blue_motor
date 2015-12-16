/* 
 * Copyright (C) Mtrust Systems, Inc - All Rights Reserved
 * Written by feelon2 <feelon2@gmail.com>, 2015-05-06
 * 
 * */

package org.jglee.blue_motor.bluecapture;

import java.util.ArrayList;
import java.util.Collection;

import org.altbeacon.beacon.Beacon;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SensorAdapter extends BaseAdapter {

	private ArrayList<Beacon> mList = null;
	private LayoutInflater mLayoutInflater = null; 
	private SparseBooleanArray mSelectedItemsIds  = new SparseBooleanArray();
	
	private TextView mTitle = null;
	private TextView mMajor = null;
	private TextView mMinor = null;
	private TextView mName = null;
	private TextView mAccuracy = null;

	public SensorAdapter(Context context) {
		super();
		mList = new ArrayList<Beacon>();
		mLayoutInflater = LayoutInflater.from(context);
	}
	public Beacon getItem(int position) {
		return mList.get(position);
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public void toggleSelection(int position) {
		selectView(position, !mSelectedItemsIds.get(position));
	}


	public ArrayList<Beacon> getArrayList() {
		return mList;
	}

	public void removeSelection() {
		mSelectedItemsIds = new SparseBooleanArray();
		notifyDataSetChanged();
	}

	public void remove(Beacon object) {
		mList.remove(object);
		notifyDataSetChanged();
	}

	public void clear() {
		mList.clear();
	}
	
	public void updateAllBeacons(Collection<Beacon> beacons) {
		synchronized (beacons) {
			mList = new ArrayList<Beacon>(beacons);
		}	
	}

	public void selectView(int position, boolean value) {
		if (value)
			mSelectedItemsIds.put(position, value);
		else
			mSelectedItemsIds.delete(position);
		notifyDataSetChanged();
	}

	public int getSelectedCount() {
		return mSelectedItemsIds.size();
	}

	public SparseBooleanArray getSelectedIds() {
		return mSelectedItemsIds;
	}

	public boolean isPositionChecked(int position) {
		Boolean result = mSelectedItemsIds.get(position);
		return result == null ? false : result;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mLayoutInflater.inflate( R.layout.adapter_beacon_user, parent, false);
		}
		
		
		mTitle = (TextView) convertView.findViewById(R.id.adapter_beacon_user_title);
		mMajor = (TextView) convertView.findViewById(R.id.adapter_beacon_user_major);;
		mMinor = (TextView) convertView.findViewById(R.id.adapter_beacon_user_minor);;
		mName = (TextView) convertView.findViewById(R.id.adapter_beacon_user_name);;
		mAccuracy = (TextView) convertView.findViewById(R.id.adapter_beacon_user_accuracy);;
		
		Beacon _becon = mList.get(position);
		
		mTitle.setText(_becon.getId1().toString());
		mMajor.setText(_becon.getId2().toString());
		mMinor.setText(_becon.getId3().toString());
		mName.setText(_becon.getBluetoothName());
		mAccuracy.setText( Double.toString( _becon.getDistance() ) );
		
		return convertView;
	}


}
