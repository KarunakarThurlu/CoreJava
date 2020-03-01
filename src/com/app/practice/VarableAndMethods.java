package com.app.practice;

public class VarableAndMethods {
	
	static	String name="Kula";
	static	String phone ="9000414340";
	static	int cardno=898757;
	static float money=78;

	public static void main(String[] args) {
		
		 showMyAccountBalance(name,phone,cardno,money);

		
		}
static	void showMyAccountBalance(String name,String phone,int cardno,float money)
	{
		System.out.println("hello..."+name+" hello   your "+ money);
	}

}
