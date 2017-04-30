package day1;

import org.junit.Test;

public class Demo3 {

	@Test
	public void test(){
		print(Grade.E);
	}
	public void print(Grade g){
		String value=g.getValue();
		System.out.println(value);
	}
}
enum Grade{
	A("100-90"),B("89-80"),C("79-70"),D("69-60"),E("59-0");
	private String value;//封装每个对象对应的分数
	private Grade(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
}