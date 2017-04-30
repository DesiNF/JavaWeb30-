package day1.reflect;

import java.util.*;
import java.io.*;
import java.lang.*;
public class Person {
	
	public String name="aaa";
	private int password=123;
	private static int age=23;

	public Person(){
		System.out.println("Person");
	}
	public Person(String name){
		System.out.println("Person name");
	}
	public Person(String name,int password){
		System.out.println("Person name password");
	}
	private Person(List list){
		System.out.println("Person list");
	}
	
	public void aal(){
		System.out.println("aal");
	}
	public void aal(String name,int password){
		System.out.println(name+" "+password);
	}
	
	/*public Class[] aal (String name,int []password){
		return new Class[](String.class);
	}*/
	private void aal(String in){
		System.out.println(in);
	}
	public static void aal(int num){
		System.out.println(num);
	}
	
	public static void main(String args[]){
		System.out.println("main");
	}
}
