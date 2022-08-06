package com.app.string;

import java.util.ArrayList;
import java.util.List;

public class GenateParanthasis {
	
	public static void main(String[] args) {
		int open=3;
		int close=3;
		String op="";
		List<String> list=new ArrayList<>();
		List<String> res=genarateParanthasis(list,open,close,op);
		System.out.println(res);
	}
	
	public static  List<String> genarateParanthasis(List<String> list,int open,int close, String op){
		if(open==0 && close==0) {
			list.add(op);
			 
		}
		if(open==close) {
			genarateParanthasis(list,open-1,close,op+"(");
		}else {
			if(open>0) {
				genarateParanthasis(list,open-1,close,op+"(");
			}
			if(close>0) {
				genarateParanthasis(list,open,close-1,op+")");
			}
		}
		return list;
	}
}
