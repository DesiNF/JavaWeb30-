package day2.xml.exam;
import java.io.*;
public class Main {

	public static void main(String args[]){
		
		try{
		System.out.println("添加学生：(a)   删除学生：(b)   查找学生：(c)");
		System.out.print("请输入操作类型：");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String type=br.readLine();
		
		if(type.equals("a")){
			System.out.print("请输入学生姓名 ： ");
			String name=br.readLine();
			
			System.out.print("请输入学生准考号： ");
			String examid=br.readLine();
			
			System.out.print("请输入学生身份证号： ");
			String  idcard=br.readLine();
			
			System.out.print("请输入学生所在地 ： ");
			String location=br.readLine();
			
			System.out.print("请输入学生成绩 ： ");
			String grade=br.readLine();
			
			Student s=new Student();
			s.setExamid(examid);
			s.setGrade(Double.parseDouble(grade));
			s.setIdcard(idcard);
			s.setName(name);
			s.setLocation(location);
			
			StudentDao dao=new StudentDao();
			dao.add(s);
			
			System.out.println("添加成功");
		}else if(type.equals("b")){
			System.out.print("请输入要删除的学生姓名：");
			String name=br.readLine();
			try{
			StudentDao dao=new StudentDao();
			dao.delete(name);
			System.out.println("删除成功");
			}catch(StudentNotExistException e){
				System.out.println("用户不存在！");
			}
		}else if(type.equals("c")){
			System.out.print("请输入要查询学生的准考号：");
			String examid=br.readLine();
			StudentDao dao=new StudentDao();
			
			System.out.println("学生姓名："+dao.find(examid).getName());
			System.out.println("学生身份证号："+dao.find(examid).getIdcard());
			System.out.println("学生准考号："+dao.find(examid).getExamid());
			System.out.println("学生所在地："+dao.find(examid).getLocation());
			System.out.println("学生成绩："+dao.find(examid).getGrade());
			
		}else{
			System.out.println("不支持的操作！");
		}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("输入错误");
		}
	}
}
