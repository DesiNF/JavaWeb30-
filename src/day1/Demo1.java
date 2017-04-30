package day1;
import org.junit.*;

public class Demo1 {

	Person p=new Person();
	
	@Before
	public void before(){
		System.out.println("before!");
	}
	@Test
	public void TestRun(){
		p.run();
	}
	@Test
	public void TestEat(){
		p.eat();
	}
	@After
	public void after(){
		System.out.println("After!");
		p=null;
	}
}
