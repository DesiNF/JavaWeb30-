package day1.reflect;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Method;

import org.junit.Test;

public class Demo3 {

	// 反射方法：public void aal()
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("day1.reflect.Person");
		Method method = clazz.getMethod("aal", null);
		method.invoke(p, null);
	}

	// 反射方法：public void aal(String name,int password)
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("day1.reflect.Person");
		Method method = clazz.getMethod("aal", String.class, int.class);
		method.invoke(p, "xx", 1);
	}

	// 反射方法：private void aal(InputStream in)
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("day1.reflect.Person");
		Method method = clazz.getDeclaredMethod("aal", String.class);
		method.setAccessible(true);
		method.invoke(p, "test");
	}

	// 反射方法:public static void all(int num)
	@Test
	public void test4() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("day1.reflect.Person");
		Method method = clazz.getMethod("aal", int.class);
		method.invoke(p, 1);
	}

	// 反射方法:public static void main(String args[])
	@Test
	public void test5() throws Exception {
		Class clazz = Class.forName("day1.reflect.Person");
		Method method = clazz.getMethod("main", String[].class);
		//method.invoke(null,(Object)new String[]{"aa","bb"});//两种方法(Object)让其拆分
		method.invoke(null,new Object[]{new String[]{"aa","bb"}});
		
		//Method.invoke(Object obj,Object...args)
	}

	
}
