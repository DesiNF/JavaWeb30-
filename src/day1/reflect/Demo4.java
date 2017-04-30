package day1.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

//�����ֶ�
public class Demo4 {

	// �����ֶ�public String name="aaa";
	@Test
	public void test1() throws Exception{
		Person p=new Person();
		Class clazz=Class.forName("day1.reflect.Person");
		Field f=clazz.getField("name");
/*		String name=(String) f.get(p);//��֪�ֶ�����
		System.out.println(name);*/
		
		//��ȡ�ֶε�ֵ
		Object value=f.get(p);
		
		//��ȡ�ֶε�����
		Class type=f.getType();
		if(type.equals(String.class)){
			String svalue=(String)value;
			System.out.println(svalue);
		}

		//�����ֶε�����
		f.set(p,"xxx");
		System.out.println(p.name);
	}
	
	//�����ֶ� private int password=123;
	@Test
	public void test2() throws Exception{
		Person p=new Person();
		Class clazz=Class.forName("day1.reflect.Person");
		Field f=clazz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));
	}
	
	//�����ֶ�private static int age=23;
		@Test
		public void test3() throws Exception{
			Person p=new Person();
			Class clazz=Class.forName("day1.reflect.Person");
			Field f=clazz.getDeclaredField("age");
			f.setAccessible(true);
			System.out.println(f.get(p));//get����û���� ��ʹ�Ǿ�̬Ҳ��Ҫ����p
		}
}
