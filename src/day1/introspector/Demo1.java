package day1.introspector;

import java.beans.*;
import java.beans.Introspector;
import java.lang.reflect.Method;

import org.junit.Test;
/**
 * ��ʡ��
 * @author Administrator
 *javaBean
 */
public class Demo1 {

	// �õ�bean��������
	@Test
	public void test1() throws Exception {
		BeanInfo info = Introspector.getBeanInfo(Person.class, Object.class);// �õ���������
		// BeanInfo info=Introspector.getBeanInfo(Person.class);//�õ��������԰���Class
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor ps : pds) {
			System.out.println(ps.getName());
		}
	}

	// ����bean��age����
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		// �õ����Ե�д���� Ϊ���Ը�ֵ
		Method method = pd.getWriteMethod();
		method.invoke(p, 45);
		System.out.println(p.getAge());

		method = pd.getReadMethod();
		System.out.println(method.invoke(p, null));
	}

	// ��ȡ��ǰ���Ե�����
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		System.out.println(pd.getPropertyType());
	}
}
