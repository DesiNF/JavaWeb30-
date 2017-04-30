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
	
	//����ö�ٵĳ��÷���
	@Test
	public void test1(){
		System.out.println(Grade1.C.name());
		System.out.println(Grade1.C.ordinal());
		
		String str="B";
		//Grade1 g=Grade1.valueOf(str);//�ַ���תö��
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
			return "��";
		}
	},B("89-80"){
		public String localValue(){
			return "��";
		}
	},C("79-70"){
		public String localValue(){
			return "��";
		}
	},D("69-60"){
		public String localValue(){
			return "��";
		}
	},E("59-0"){
		public String localValue(){
			return "������";
		}
	};
	private String value;//��װÿ�������Ӧ�ķ���
	private Grade1(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
	public abstract String localValue();
}