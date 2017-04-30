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
 * 使用beanutils操纵bean的属性（第三方）
 * @author Administrator
 *test3 自己写转换器的话  若birthday为空getbirthday返回null
 *test4 系统自带的转换器 在遇到上述情况下getbirthday会报错
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
		BeanUtils.setProperty(p, "age", age);//String 转成int  只支持8种基本类型
		//BeanUtils.setProperty(p, "birthday", birthday);//无法转换Data
		
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
		
		//为了让日期赋到bean的birthday属性上，我们给beanutils注册一个日期转换器
		ConvertUtils.register(new Converter(){
			public <T> T convert(Class<T> type, Object value) {
				if(value==null){
					return null;
				}
				if(!(value instanceof String)){
					throw new ConversionException("只支持String类型的转换");
				}
				//如果生日值为空字符串返回空
				String str =(String)value;
				if(str.trim().equals("")){
					return null;
				}
				SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
				try{
					return (T) sdf.parse(str);
				}catch(ParseException e){
					throw new RuntimeException(e);//异常链不能断
				}
			}
		}, Date.class);
		
		Person p=new Person ();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);//String 转成int  只支持8种基本类型
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
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);//时间转换器
		
		Person p=new Person ();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);//String 转成int  只支持8种基本类型
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
