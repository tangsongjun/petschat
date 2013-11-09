package com.bishun.pets.adapter;

import java.util.ArrayList;

import com.bishun.pets.PetDetailActivity;
import com.bishun.pets.R;
import com.bishun.pets.bussines.Pets;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<Pets> mPets = new ArrayList<Pets>();
	
	public FriendAdapter(Context context){
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
		for (int i = 0; i < 30; i++) {
			Pets pet = new Pets("花太郎"+i,i%2==0,i,"","上海",i,"白色","5.5km/1970-1-1");
			mPets.add(pet);
		}
	}

	@Override
	public int getCount() {
		
		return mPets == null ? 0 : mPets.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Myholdler myholdler = null;
		final Pets pet = mPets.get(position);
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.adapter_friend, null);	
			myholdler = new Myholdler();
			myholdler.icon = (ImageView) convertView.findViewById(R.id.icon);
			myholdler.range = (TextView)convertView.findViewById(R.id.tv_range);
			myholdler.name = (TextView)convertView.findViewById(R.id.tv_name);
			myholdler.address = (TextView)convertView.findViewById(R.id.tv_address);
			convertView.setTag(myholdler);
		}else {
			myholdler = (Myholdler) convertView.getTag();
			
		}
		myholdler.range.setText(pet.getRange());
		myholdler.name.setText(pet.getName());
		myholdler.address.setText(pet.getAddress());
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mContext, PetDetailActivity.class);
				intent.putExtra("name", pet.getName());
				mContext.startActivity(intent);
				
			}
		});
		return convertView;
	}
	final class Myholdler{
		ImageView icon;
		TextView name;
		TextView range;
		TextView address;
	}
}
