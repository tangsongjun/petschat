package com.bishun.pets.bussines;

public class NavigateMode {
	private String name;
	private int iconresid;
	
	public NavigateMode(String name, int iconresid) {
		super();
		this.name = name;
		this.iconresid = iconresid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIconresid() {
		return iconresid;
	}
	public void setIconresid(int iconresid) {
		this.iconresid = iconresid;
	}
}
