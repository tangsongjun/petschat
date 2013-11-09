package com.bishun.pets;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class BaseActivityGroup extends ActivityGroup implements OnClickListener {
	protected ViewPager mViewPager;
	protected MyPagerAdapter myAdapter;

	protected LayoutInflater mInflater;
	protected List<View> mListViews;
	protected View bottom1 = null;
	protected View bottom2 = null;
	protected View bottom3 = null;
	protected RelativeLayout mainView=null;
	protected LocalActivityManager mLocalActivityManager;
	
	protected ImageView tab_1;
	
	protected ImageView tab_2;
	
	protected ImageView tab_3;
	
	protected ImageView tab_4;
	
	protected ImageView tab_5;
	
	protected ImageView tab_6;
	
	protected ImageView tab_7;
	
	/*当前tab页*/
	protected ImageView ivCurrentTab=null;//
	//activity id
	protected final String ACTIVITY_TAB1="tab1";
	protected final String ACTIVITY_TAB2="tab2";
	protected final String ACTIVITY_TAB3="tab3";
	protected final String ACTIVITY_TAB4="tab4";
	protected final String ACTIVITY_TAB5="tab5";
	protected final String ACTIVITY_TAB6="tab6";
	protected final String ACTIVITY_TAB7="tab7";
	protected final String ACITIVTY_SCHEDULE = "scheduleactivity";
	protected String currentActivityId="";//当前activity id
	private Intent intent1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();
		initTabWigdit();
		intent1 = new Intent(this, UserInfoActivity.class);
		startActivity2SwichView(ACTIVITY_TAB1, intent1, tab_1);
	}
	
	private void init() {
		// TODO Auto-generated method stub 
		mLocalActivityManager=this.getLocalActivityManager();
		mInflater=getLayoutInflater();
		mViewPager=(ViewPager)findViewById(R.id.viewpagerLayout);
		mainView=(RelativeLayout)findViewById(R.id.mainView);
		bottom1=mInflater.inflate(R.layout.bottom1, null);
		bottom2=mInflater.inflate(R.layout.bottom2, null);
		bottom3 = mInflater.inflate(R.layout.bottom3, null);
		mListViews=new ArrayList<View>();
		mListViews.add(bottom1);
		mListViews.add(bottom2);
		mListViews.add(bottom3);
		myAdapter=new MyPagerAdapter();
		mViewPager.setAdapter(myAdapter);
	}
	protected void initTabWigdit(){
		//bottom1
		tab_1=(ImageView)bottom1.findViewById(R.id.tab_1);
		tab_1.setOnClickListener(this);
		tab_2=(ImageView)bottom1.findViewById(R.id.tab_2);
		tab_2.setOnClickListener(this); 
		tab_3=(ImageView)bottom1.findViewById(R.id.tab_3);
		tab_3.setOnClickListener(this);
		//bottom2
		tab_4=(ImageView)bottom2.findViewById(R.id.tab_4);
		tab_4.setOnClickListener(this);
		tab_5=(ImageView)bottom2.findViewById(R.id.tab_5);
		tab_5.setOnClickListener(this);
		tab_6=(ImageView)bottom2.findViewById(R.id.tab_6);
		tab_6.setOnClickListener(this); 

		//bottom3
//		ivTabContact=(ImageView)bottom3.findViewById(R.id.tab_contact);
//		ivTabContact.setOnClickListener(this); 	 
		tab_7 = (ImageView)bottom3.findViewById(R.id.tab_7);
		tab_7.setOnClickListener(this);
	
	}
	/**
	 * change current activity by id
	 * @param id
	 * @param intent
	 */
	protected void startActivity2SwichView(String id,Intent intent,View v){
			if(!currentActivityId.equalsIgnoreCase(id)){
				mainView.removeAllViews();
				if(intent != null){
					Window _Window=mLocalActivityManager.startActivity(id, intent);
					mainView.addView(_Window.getDecorView()); 
				}
				swichTabState(id,(ImageView)v);
				currentActivityId=id;
			}
	}
	
	@Override
	public void onClick(View v) {
	
		Intent intent = null;
		
		switch (v.getId()) {
		
		case R.id.tab_1:
			intent = new Intent();
			intent.setClass(this, UserInfoActivity.class);
			startActivity2SwichView(ACTIVITY_TAB1, intent, v);
			break;

		case R.id.tab_2:
			intent = new Intent();
			intent.setClass(this, NavigateActivity.class);
			startActivity2SwichView(ACTIVITY_TAB2, intent, v);
			break;
		case R.id.tab_3:
			intent = new Intent();
			intent.setClass(this, FriendActivity.class);
			startActivity2SwichView(ACTIVITY_TAB3, intent, v);
//			Toast.makeText(this, "开发中。。。", Toast.LENGTH_SHORT).show();
			break;
		case R.id.tab_4:
			startActivity2SwichView(ACTIVITY_TAB4, intent, v);
			Toast.makeText(this, "开发中。。。", Toast.LENGTH_SHORT).show();
			break;
		case R.id.tab_5:
			startActivity2SwichView(ACTIVITY_TAB5, intent, v);
			Toast.makeText(this, "开发中。。。", Toast.LENGTH_SHORT).show();
			break;
		case R.id.tab_6:
			startActivity2SwichView(ACTIVITY_TAB6, intent, v);
			Toast.makeText(this, "开发中。。。", Toast.LENGTH_SHORT).show();
			break;
//		case R.id.tab_email:
//			
//			break;
		case R.id.tab_7:
			startActivity2SwichView(ACTIVITY_TAB7, intent, v);
			Toast.makeText(this, "开发中。。。", Toast.LENGTH_SHORT).show();

			break;
		}
		
	}
	/**
	 * change tab state 
	 * @param activityId
	 * @param currentTab
	 */
	protected void swichTabState(String activityId,ImageView currentTab){
		if(ivCurrentTab!=null){
			//前一个tab
			switch (ivCurrentTab.getId()) {
			case R.id.tab_1:
				this.tab_1.setImageResource(R.drawable.my);
				break;
			case R.id.tab_2:
				this.tab_2.setImageResource(R.drawable.daohang1);
				break;
			case R.id.tab_3:
				this.tab_3.setImageResource(R.drawable.friends);
				break;
			case R.id.tab_4:
				this.tab_4.setImageResource(R.drawable.market);
				break;
			case R.id.tab_5:
				this.tab_5.setImageResource(R.drawable.experience);
				break;
			case R.id.tab_6:
				this.tab_6.setImageResource(R.drawable.message1);
				break;
			
			case R.id.tab_7:
				this.tab_7.setImageResource(R.drawable.photo);
				break;
			}
		}
		//当前tab
		ivCurrentTab=currentTab;
		switch (currentTab.getId()) {
		case R.id.tab_1:
			this.tab_1.setImageResource(R.drawable.my_v);
			break;
		case R.id.tab_2:
			this.tab_2.setImageResource(R.drawable.daohang2);
			break;
		case R.id.tab_3:
			this.tab_3.setImageResource(R.drawable.friends_v);
			break;
		case R.id.tab_4:
			this.tab_4.setImageResource(R.drawable.market_v);
			break;
		case R.id.tab_5:
			this.tab_5.setImageResource(R.drawable.experience_v);
			break;
		case R.id.tab_6:
			this.tab_6.setImageResource(R.drawable.message1_v);
			break;
		
		case R.id.tab_7:
			currentTab.setImageResource(R.drawable.photo_v);
			break;
		}
		
	}
	
	private class MyPagerAdapter extends PagerAdapter {

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
//			Log.d("k", "destroyItem");
			((ViewPager) arg0).removeView(mListViews.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
//			Log.d("k", "finishUpdate");
		}

		@Override
		public int getCount() {
//			Log.d("k", "getCount");
			return mListViews.size();
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
//			Log.d("k", "instantiateItem");
			((ViewPager) arg0).addView(mListViews.get(arg1), 0);
			return mListViews.get(arg1);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
//			Log.d("k", "isViewFromObject");
			return arg0 == (arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
//			Log.d("k", "restoreState");
		}

		@Override
		public Parcelable saveState() {
//			Log.d("k", "saveState");
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
//			Log.d("k", "startUpdate");
		}

	}
	
	
}
