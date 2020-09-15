package com.fdmgroup.makeup_tutorial.model;

public enum StyleType {
	
	BRIDAL("Bridal"),
	THEATRICAL("Theatrical"),
	NATURAL("Natural");
	
	private String name;
	
	private StyleType(String type){
		name = type;
	}
	
	public String getName() {
		return name;
	}

	public static String getUserType(int index){
		return StyleType.values()[index].toString();
	}

}
