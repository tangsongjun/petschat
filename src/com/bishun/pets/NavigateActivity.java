package com.bishun.pets;

import com.bishun.pets.adapter.NavigateAdapter;

import android.os.Bundle;
import android.widget.GridView;

public class NavigateActivity extends BaseActivity {
	private GridView mGridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigate);
		mGridView = (GridView)findViewById(R.id.gridview);
		init();
	}

	private void init() {
		mGridView.setAdapter(new NavigateAdapter(this));
	}

}
