package day1;

import org.junit.Test;

public class Demo4 {

	@Test
	public void test(){
		print(Grade1.A);
	}
	public void print(Grade1 g){//A B C D E
		String value=g.localValue();
		System.out.println(value);
	}
	
	//测试枚举的常用方法
	@Test
	public void test1(){
		System.out.println(Grade1.C.name());
		System.out.println(Grade1.C.ordinal());
		
		String str="B";
		//Grade1 g=Grade1.valueOf(str);//字符串转枚举
		Grade1 g=Grade1.valueOf(Grade1.class, str);
		System.out.println(g);
		System.out.println();
		
		Grade1 gs[]=Grade1.values();
		for(Grade1 x:gs)
			System.out.println(x);
	}
}




enum Grade1{
	A("100-90"){
		public String localValue(){
			return "优";
		}
	},B("89-80"){
		public String localValue(){
			return "良";
		}
	},C("79-70"){
		public String localValue(){
			return "中";
		}
	},D("69-60"){
		public String localValue(){
			return "差";
		}
	},E("59-0"){
		public String localValue(){
			return "不及格";
		}
	};
	private String value;//封装每个对象对应的分数
	private Grade1(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
	public abstract String localValue();
}