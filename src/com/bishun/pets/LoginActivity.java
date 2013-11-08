package com.bishun.pets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity implements OnClickListener{
	private EditText name;
	private EditText password;
	private Button login;
	private Button register;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
	}

	private void init() {
		name = (EditText) findViewById(R.id.et_username);
		password = (EditText)findViewById(R.id.et_password);
		login = (Button)findViewById(R.id.btn_loging);
		register = (Button)findViewById(R.id.btn_register);
		login.setOnClickListener(this);
		register.setOnClickListener(this);
	}
	
	private boolean checkLoginInfo(){
		String name = this.name.getText().toString().trim();
		String password = this.password.getText().toString().trim();
		if(TextUtils.isEmpty(name)||TextUtils.isEmpty(password)){
			showToast("用户名和密码不能为空");
			return false;
		}
		return true;
	}
	

	@Override
	public void onClick(View v) {
		if(v == login){
			if(checkLoginInfo()){
				lauchActivity(MainActivity.class);
				finish();
			}
			
		}
	}
	
	
}
