package day2.xml.exam;
import java.io.*;
public class Main {

	public static void main(String args[]){
		
		try{
		System.out.println("���ѧ����(a)   ɾ��ѧ����(b)   ����ѧ����(c)");
		System.out.print("������������ͣ�");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String type=br.readLine();
		
		if(type.equals("a")){
			System.out.print("������ѧ������ �� ");
			String name=br.readLine();
			
			System.out.print("������ѧ��׼���ţ� ");
			String examid=br.readLine();
			
			System.out.print("������ѧ�����֤�ţ� ");
			String  idcard=br.readLine();
			
			System.out.print("������ѧ�����ڵ� �� ");
			String location=br.readLine();
			
			System.out.print("������ѧ���ɼ� �� ");
			String grade=br.readLine();
			
			Student s=new Student();
			s.setExamid(examid);
			s.setGrade(Double.parseDouble(grade));
			s.setIdcard(idcard);
			s.setName(name);
			s.setLocation(location);
			
			StudentDao dao=new StudentDao();
			dao.add(s);
			
			System.out.println("��ӳɹ�");
		}else if(type.equals("b")){
			System.out.print("������Ҫɾ����ѧ��������");
			String name=br.readLine();
			try{
			StudentDao dao=new StudentDao();
			dao.delete(name);
			System.out.println("ɾ���ɹ�");
			}catch(StudentNotExistException e){
				System.out.println("�û������ڣ�");
			}
		}else if(type.equals("c")){
			System.out.print("������Ҫ��ѯѧ����׼���ţ�");
			String examid=br.readLine();
			StudentDao dao=new StudentDao();
			
			System.out.println("ѧ��������"+dao.find(examid).getName());
			System.out.println("ѧ�����֤�ţ�"+dao.find(examid).getIdcard());
			System.out.println("ѧ��׼���ţ�"+dao.find(examid).getExamid());
			System.out.println("ѧ�����ڵأ�"+dao.find(examid).getLocation());
			System.out.println("ѧ���ɼ���"+dao.find(examid).getGrade());
			
		}else{
			System.out.println("��֧�ֵĲ�����");
		}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�������");
		}
	}
}
