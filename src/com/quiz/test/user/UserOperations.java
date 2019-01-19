package com.anurag.test.user;

import java.util.ArrayList;





public class UserOperations {
	private UserOperations() {}
	private ArrayList<User> userList= new ArrayList<>();
	private static UserOperations itemOperations =null;
	public String addUser(User user){
		System.out.println(user.getName());
		if(searchUser(user.getName())==-1){
			this.userList.add(user);
			return "REGISTERED";
		}
		else
			return "USER Already Exists";
	}
	public int searchUser(String name){
		User user = new User();
		user.setName(name);
		
		System.out.println(userList.indexOf(user));
		return userList.indexOf(user);
		
	}
	

	public  static UserOperations getInstance(){
		synchronized(UserOperations.class){
			if(itemOperations==null){
				itemOperations = new UserOperations();
			}
		}
		return itemOperations;
	}
	public boolean checkUser(int result, String password) {
		// TODO Auto-generated method stub
		if(userList.get(result).getPassword().equals(password))
			{//System.out.println("t");

			return true;
			}
		else
		{
			//System.out.println("f");

			return false; }
	}
	
}
