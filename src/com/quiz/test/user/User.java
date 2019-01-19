package com.anurag.test.user;



public class User {
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String name,String password) {
		this.name=name;
		this.password=password;
	}
	public User() {}
	
	@Override
	public boolean equals(Object object){

		if(object instanceof User){
			
			User item = (User) object; // Downcasting
			
			if(item.name!=null && item.name.trim().length()>0){
				if(this.name.equals(item.name))
					return true;
				}
			}
			return false;			
		}
}

