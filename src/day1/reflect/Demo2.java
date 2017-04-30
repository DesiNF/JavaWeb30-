package day1.reflect;

import java.util.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.Test;

//������Ĺ��캯����������Ķ���
public class Demo2 {

	//���乹�캯��,public Person()
	@Test
	public void test1()throws Exception{
		Class clazz=Class.forName("day1.reflect.Person");
		Constructor c=clazz.getConstructor(null);
		Person p=(Person)c.newInstance(null);
		
		System.out.println(p.name);
	}
	
	//���乹�캯��,public Person(String name)
	@Test
	public void test2()throws Exception{
		Class clazz=Class.forName("day1.reflect.Person");
		Constructor c=clazz.getConstructor(String.class);
		Person p=(Person) c.newInstance("xx");
		System.out.println(p.name);
	}
	
	//���乹�캯��,public Person(String name,int password)
	@Test
	public void test3()throws Exception{
		Class clazz=Class.forName("day1.reflect.Person");
		Constructor c=clazz.getConstructor(String.class,int.class);
		Person p=(Person) c.newInstance("x",1);
		System.out.println(p.name);
	}
	
	//private Person(List list)
	@Test
	public void test4()throws Exception{
		Class clazz=Class.forName("day1.reflect.Person");
		Constructor c=clazz.getDeclaredConstructor(List.class);
		c.setAccessible(true);
		Person p=(Person) c.newInstance(new ArrayList());
		System.out.println(p.name);
	}
	//�����������һ��;�� ��Ч��test1
	@Test
	public void test5()throws Exception{
		Class clazz=Class.forName("day1.reflect.Person");
		Person p=(Person) clazz.newInstance();
		System.out.println(p);
	}
}
