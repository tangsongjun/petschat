package com.bishun.pets.bussines;

public class Pets {
	private String name;
	private boolean sex;
	private int age;
	private String iconpath;
	private String address;
	private float weight;
	private String colour;
	private String range;
	
	public Pets(String name, boolean sex, int age, String iconpath,
			String address, float weight, String colour, String range) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.iconpath = iconpath;
		this.address = address;
		this.weight = weight;
		this.colour = colour;
		this.range = range;
	}
	
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIconpath() {
		return iconpath;
	}
	public void setIconpath(String iconpath) {
		this.iconpath = iconpath;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
}
