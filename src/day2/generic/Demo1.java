package day2.generic;

import java.util.*;
/**
 * 
 * @author Administrator
 *·ºÐÍ
 */
public class Demo1 {

	public static void main(String args[]){
		List list=new ArrayList();
		list.add("a");
		Integer i=(Integer) list.get(0);//±¨´í
		
		List<String > list1=new ArrayList<String>();
		list1.add("aaa");
		String str=list1.get(0);
	}
}
