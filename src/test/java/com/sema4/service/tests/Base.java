package com.sema4.service.tests;

import java.util.ArrayList;
import java.util.Arrays;

class Base {
	public static void main(String[] args) {
//		int arr[] = {3,1,2,3};
//		
//		int count=0;
//		for(int i=1;i<arr.length;i++) {
//			count=0;
//			for(int j=1;j<=arr[i];j++) {
//				if(j%2!=0) {
//					count=count+j;
//				}
//			}
//			System.out.println(count);
//		}
		
//		int a[] = {1};
//		Base base = new Base();
//		base.incr(a);
//		System.out.println(a[a.length-1]);
		q3();
		
	}
	public void incr(int[] i) {
		i[i.length-1]++;
	}
	
	public static void q3() {
		String date[] = {"4","1st Mar 1984","2nd Feb 2013","4th Apr 1990", "23rd Jan 2011"};
		
		ArrayList<String> months = new ArrayList<>(Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"));
		
		String finalArray[] = new String[date.length-1];
		String temp[];
		String finalValue = null,first=null,third=null;
		int second;
		int length = date.length;
		for(int i=1;i<length;i++) {
			temp = date[i].split(" ");
			
			if(temp[0].contains("st")) {
				first = temp[0].substring(0, temp[0].indexOf("st"));
			}
			else if(temp[0].contains("nd")) {
				first = temp[0].substring(0, temp[0].indexOf("nd"));
			}
			else if(temp[0].contains("th")) {
				first = temp[0].substring(0, temp[0].indexOf("th"));
			}
			else if(temp[0].contains("rd")) {
				first = temp[0].substring(0, temp[0].indexOf("rd"));
			}
			else {
				finalValue = null;
			}
			
			second = months.indexOf(temp[1])+1;
			
			if(1900 <= Integer.parseInt(temp[2]) && Integer.parseInt(temp[2]) <= 2100) {
				third = temp[2];
			}
			else {
				finalValue = null;
			}
			
			String secondStr = second+"";
			secondStr = secondStr.length()==1?("0"+secondStr):secondStr;
			first = first.length()==1?("0"+first):first;
			System.out.println(third+"-"+ secondStr +"-"+ first);
			
			finalArray[i-1] = third+"-"+ secondStr +"-"+ first;
		}
	}
	
	
	
	
	
	
}


