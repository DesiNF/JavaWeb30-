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

//读取xml文档的第二本书   <书名>book2</书名>
public class Demo1 {

	@Test
	public void read() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element root = document.getRootElement();
		Element book = (Element) root.elements("书").get(1);
		String value = book.element("书名").getText();
		String attr = book.element("书名").attributeValue("name");
		System.out.println(value);
		System.out.println(attr);
	}

	// 在第一本书上新增 <售价>200元</售价>
	@Test
	public void add() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = document.getRootElement().element("书");
		book.addElement("售价").setText("200元");

		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/book.xml"), "UTF-8"));
		writer.write(document);// UTF-8
		writer.close();
	}

	// 在第一本书指定位置新增 <售价>200元</售价>
	@Test
	public void add2() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));

		Element book = document.getRootElement().element("书");
		List list = book.elements();
		Element price=DocumentHelper.createElement("售价");
		price.setText("100元");
		list.add(2, price);
		
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/book.xml"), "UTF-8"));
		writer.write(document);// UTF-8
		writer.close();
	}
	//删除add2添加的售价
	@Test
	public void delete() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		
		Element price=document.getRootElement().element("书").element("售价");
		price.getParent().remove(price);
		
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/book.xml"), "UTF-8"));
		writer.write(document);// UTF-8
		writer.close();
	}
	
	//删除add2添加的售价
		@Test
		public void update() throws Exception{
			SAXReader reader = new SAXReader();
			Document document = reader.read(new File("src/book.xml"));
			
			Element book=(Element) document.getRootElement().elements("书").get(1);
			book.element("作者").setText("hehe");
			
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/book.xml"), "UTF-8"));
			writer.write(document);// UTF-8
			writer.close();
		}
}
