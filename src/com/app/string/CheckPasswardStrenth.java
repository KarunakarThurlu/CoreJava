package com.app.string;

public class CheckPasswardStrenth {
	
	public static void main(String[] args) {

		String s="132abc";
		int digitcount=0;
		int charcount=0;
		for(int i=0;i<s.length()-1;i++){
			if(Character.isDigit(s.charAt(i)) ){
				int in=(int)s.charAt(i);
				int nin=(int)s.charAt(i+1);
				if(nin-in==1) {
					digitcount=digitcount+1;
					if(digitcount==2)
						break;
				}else {
					digitcount=0;
				}
			}
			if(Character.isLetter(s.charAt(i))){
				int in=(int)s.charAt(i);
				int nin=(int)s.charAt(i+1);
				if(nin-in==1) {
					charcount=charcount+1;
					if(charcount==2)
						break;
				}else {
					charcount=0;
				}
			}
		}
		if(charcount==2 || digitcount==2) {
			System.out.println("weak passward");
		}else {
			System.out.println("strong passward");
		}
	}
}
