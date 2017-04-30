package day2.xml.exam;

import org.junit.Test;

public class StudentDaoTest {

	@Test
	public void testAdd(){
		StudentDao dao=new StudentDao();
		Student s=new Student();
		s.setIdcard("1");
		s.setExamid("2");
		s.setLocation("青岛");
		s.setName("王二狗");
		s.setGrade(89);
		dao.add(s);
	}
	@Test
	public void testFind(){
		StudentDao dao =new StudentDao();
		System.out.println(dao.find("222").getGrade());
	}
	@Test
	public void testDelete() throws StudentNotExistException{
		StudentDao dao=new StudentDao();
		dao.delete("王二狗");
	}

}
