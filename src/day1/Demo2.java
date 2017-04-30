package day1;

import org.junit.Assert;
import org.junit.Test;

public class Demo2 {

	Person p=new Person();
	
	@Test
	public void TestRun(){
		p.run();
		
		//╤оят
		Assert.assertEquals("2", p.run());
	}
}
