package day2.generic;
import java.util.*;

import org.junit.Test;
public class Demo2 {

	@Test
	public void test1(){
		List<String >list =new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		//普通迭代
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			String value=it.next();
			System.out.println(value);
		}
		//增强for循环
		for(String s:list){
			System.out.println(s);
		}
	}
	
	@Test
	public void test2(){
		Map<Integer,String>map=new HashMap<Integer,String>();
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		
		System.out.println(map);//{1=aa, 2=bb, 3=cc}
		
		//传统keyset entryset
		Set<Map.Entry<Integer, String>>set=map.entrySet();
		Iterator<Map.Entry<Integer, String>> it=set.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, String>entry=it.next();
			int key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+"="+value);
		}
		
		//增强for
		for(Map.Entry<Integer, String>entry:map.entrySet()){
			int key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+"="+value);
		}
	}
}
