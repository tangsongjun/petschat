package com.bishun.pets.adapter;

import java.util.ArrayList;

import com.bishun.pets.R;
import com.bishun.pets.bussines.NavigateMode;

import android.R.mipmap;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NavigateAdapter extends BaseAdapter {
	
	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<NavigateMode> navigateMode = new ArrayList<NavigateMode>();
	
	public NavigateAdapter(Context context){
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
			NavigateMode mode = new NavigateMode("养猫须知", R.drawable.ycat1);
			navigateMode.add(mode);
			mode = new NavigateMode("养狗须知", R.drawable.ydog1);
			navigateMode.add(mode);
			mode = new NavigateMode("宠物交友", R.drawable.yfrend1);
			navigateMode.add(mode);
			mode = new NavigateMode("宠物市场", R.drawable.ymar1);
			navigateMode.add(mode);
			mode = new NavigateMode("宠物优惠", R.drawable.yyou2);
			navigateMode.add(mode);
			mode = new NavigateMode("我的相册", R.drawable.ypic1);
			navigateMode.add(mode);
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return navigateMode.size();
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
		final NavigateMode mode = navigateMode.get(position);
		convertView = mInflater.inflate(R.layout.adapter_navigate, null);
		ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
		TextView name = (TextView)convertView.findViewById(R.id.name);
		icon.setBackgroundResource(mode.getIconresid());
		name.setText(mode.getName());
		icon.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, mode.getName()+"功能正在开发中。。。。", 0).show();
			}
		});
		return convertView;
	}

}
