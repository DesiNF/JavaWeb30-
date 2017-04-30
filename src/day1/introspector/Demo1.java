package day1.introspector;

import java.beans.*;
import java.beans.Introspector;
import java.lang.reflect.Method;

import org.junit.Test;
/**
 * 内省包
 * @author Administrator
 *javaBean
 */
public class Demo1 {

	// 得到bean所有属性
	@Test
	public void test1() throws Exception {
		BeanInfo info = Introspector.getBeanInfo(Person.class, Object.class);// 得到自身属性
		// BeanInfo info=Introspector.getBeanInfo(Person.class);//得到所有属性包括Class
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor ps : pds) {
			System.out.println(ps.getName());
		}
	}

	// 操纵bean的age属性
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		// 得到属性的写方法 为属性赋值
		Method method = pd.getWriteMethod();
		method.invoke(p, 45);
		System.out.println(p.getAge());

		method = pd.getReadMethod();
		System.out.println(method.invoke(p, null));
	}

	// 获取当前属性的类型
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		System.out.println(pd.getPropertyType());
	}
}
