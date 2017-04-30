package day1.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

//反射字段
public class Demo4 {

	// 反射字段public String name="aaa";
	@Test
	public void test1() throws Exception{
		Person p=new Person();
		Class clazz=Class.forName("day1.reflect.Person");
		Field f=clazz.getField("name");
/*		String name=(String) f.get(p);//已知字段类型
		System.out.println(name);*/
		
		//获取字段的值
		Object value=f.get(p);
		
		//获取字段的类型
		Class type=f.getType();
		if(type.equals(String.class)){
			String svalue=(String)value;
			System.out.println(svalue);
		}

		//设置字段的类型
		f.set(p,"xxx");
		System.out.println(p.name);
	}
	
	//反射字段 private int password=123;
	@Test
	public void test2() throws Exception{
		Person p=new Person();
		Class clazz=Class.forName("day1.reflect.Person");
		Field f=clazz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
	
	//反射字段private static int age=23;
		@Test
		public void test3() throws Exception{
			Person p=new Person();
			Class clazz=Class.forName("day1.reflect.Person");
			Field f=clazz.getDeclaredField("age");
			f.setAccessible(true);
			System.out.println(f.get(p));//get方法没重载 即使是静态也需要传递p
		}
}
