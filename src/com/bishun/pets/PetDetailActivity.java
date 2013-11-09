package com.bishun.pets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class PetDetailActivity extends BaseActivity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pet_detatil);
		Intent intent =getIntent();
		TextView name = (TextView)findViewById(R.id.name);
		name.setText(intent.getStringExtra("name"));
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		showToast("功能正在开发中");
		
	}

}
