package day1.reflect;

public class Demo1 {
/**
 * ∑¥…‰£∫º”‘ÿ¿‡
 * @param args
 * @throws Exception
 */
	public static void main(String args[])throws Exception{
		//1
		Class clazz=Class.forName("/JavaWebDay30/src/day1/reflect/Person");
		//2
		Class clazz1=new Person().getClass();
		//3
		Class clazz2=Person.class;
	}
}
