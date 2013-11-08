package com.bishun.pets;

import com.bishun.pets.adapter.FriendAdapter;

import android.os.Bundle;
import android.widget.ListView;

public class FriendActivity extends BaseActivity {
	private ListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend);
		init();
		test();
	}

	private void init() {
		mListView = (ListView) findViewById(R.id.friend_list);
	}
	
	private void test(){
		FriendAdapter adapter = new FriendAdapter(this);
		mListView.setAdapter(adapter);
	}
	
}
