package day3.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

//��ȡxml�ĵ��ĵڶ�����   <����>book2</����>
public class Demo1 {

	@Test
	public void read() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("��").get(1);
		String value = book.element("����").getText();
		String attr = book.element("����").attributeValue("name");
		System.out.println(value);
		System.out.println(attr);
	}

	// �ڵ�һ���������� <�ۼ�>200Ԫ</�ۼ�>
	@Test
	public void add() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = document.getRootElement().element("��");
		book.addElement("�ۼ�").setText("200Ԫ");

		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/book.xml"), "UTF-8"));
		writer.write(document);// UTF-8
		writer.close();
	}

	// �ڵ�һ����ָ��λ������ <�ۼ�>200Ԫ</�ۼ�>
	@Test
	public void add2() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = document.getRootElement().element("��");
		List list = book.elements();
		Element price=DocumentHelper.createElement("�ۼ�");
		price.setText("100Ԫ");
		list.add(2, price);
		
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/book.xml"), "UTF-8"));
		writer.write(document);// UTF-8
		writer.close();
	}
	//ɾ��add2��ӵ��ۼ�
	@Test
	public void delete() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		
		Element price=document.getRootElement().element("��").element("�ۼ�");
		price.getParent().remove(price);
		
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/book.xml"), "UTF-8"));
		writer.write(document);// UTF-8
		writer.close();
	}
	
	//ɾ��add2��ӵ��ۼ�
		@Test
		public void update() throws Exception{
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("src/book.xml"));
			
			Element book=(Element) document.getRootElement().elements("��").get(1);
			book.element("����").setText("hehe");
			
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/book.xml"), "UTF-8"));
			writer.write(document);// UTF-8
			writer.close();
		}
}
