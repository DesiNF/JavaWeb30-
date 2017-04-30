package day1.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

/**
 * ʹ��beanutils����bean�����ԣ���������
 * @author Administrator
 *test3 �Լ�дת�����Ļ�  ��birthdayΪ��getbirthday����null
 *test4 ϵͳ�Դ���ת���� ���������������getbirthday�ᱨ��
 */
public class Demo1 {

	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException{
		Person p=new Person();
		BeanUtils.setProperty(p, "name", "xxc");
		
		System.out.println(p.getName());
	}
	
	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException{
		String name="aaa";
		String password="123";
		String age="23";
		String birthday="1999-09-09";
		
		Person p=new Person ();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);//String ת��int  ֻ֧��8�ֻ�������
		//BeanUtils.setProperty(p, "birthday", birthday);//�޷�ת��Data
		
		System.out.println(p.getAge());
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		//System.out.println(p.getBirthday());
	}
	
	@Test
	public void test3() throws IllegalAccessException, InvocationTargetException{
		String name="aaa";
		String password="123";
		String age="23";
		String birthday="1999-09-09";
		
		//Ϊ�������ڸ���bean��birthday�����ϣ����Ǹ�beanutilsע��һ������ת����
		ConvertUtils.register(new Converter(){
			public <T> T convert(Class<T> type, Object value) {
				if(value==null){
					return null;
				}
				if(!(value instanceof String)){
					throw new ConversionException("ֻ֧��String���͵�ת��");
				}
				//�������ֵΪ���ַ������ؿ�
				String str =(String)value;
				if(str.trim().equals("")){
					return null;
				}
				SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
				try{
					return (T) sdf.parse(str);
				}catch(ParseException e){
					throw new RuntimeException(e);//�쳣�����ܶ�
				}
			}
		}, Date.class);
		
		Person p=new Person ();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);//String ת��int  ֻ֧��8�ֻ�������
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println(p.getAge());
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());//Thu Sep 09 00:00:00 CST 1999
		Date date=p.getBirthday();
		System.out.println(date.toLocaleString());//1999-9-9 0:00:00
	}
	
	@Test
	public void test4() throws IllegalAccessException, InvocationTargetException{
		String name="aaa";
		String password="123";
		String age="23";
		String birthday="1999-09-09";
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);//ʱ��ת����
		
		Person p=new Person ();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);//String ת��int  ֻ֧��8�ֻ�������
		BeanUtils.setProperty(p, "birthday", birthday);
		
		System.out.println(p.getAge());
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());
		Date date=p.getBirthday();
		System.out.println(date.toLocaleString());
	}
	
	@Test
	public void test5() throws IllegalAccessException, InvocationTargetException{
		Map map=new HashMap();
		map.put("name", "Desinf");
		map.put("password", "123");
		map.put("age", "23");
		map.put("birthday", "1999-09-09");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person p=new Person();
		BeanUtils.populate(p, map);
		
		System.out.println(p.getAge());
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getBirthday());
	}
}
