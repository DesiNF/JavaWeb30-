package day3.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo3 {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
		// 1 ������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2 ����������
		SAXParser sp = factory.newSAXParser();
		// 3 �õ���ȡ��
		XMLReader reader = sp.getXMLReader();
		// 4 �������ݴ�����
		BeanListHandler handle=new BeanListHandler();
		reader.setContentHandler(handle);
		// 5 ��ȡxml�ĵ�����
		reader.parse("src/book.xml");

		List<Book>list=handle.getBook();
		System.out.println(list);
	}
}

// ��xml�ĵ��е�ÿһ�����װ��һ��book���󣬲��Ѷ��book�������һ��list���Ϸ��� 
class BeanListHandler extends DefaultHandler {
	private List list=new ArrayList();
	private String currentTag;
	private Book book;
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		currentTag=name;
		if("��".equals(currentTag)){
			book=new Book();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("����".equals(currentTag)){
			String name=new String (ch,start,length);
			book.setName(name);
		}
		if("����".equals(currentTag)){
			String author=new String (ch,start,length);
			book.setAuthor(author);
		}
		if("�ۼ�".equals(currentTag)){
			String price=new String (ch,start,length);
			book.setPrice(price);
		}
	}

	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		if(name.equals("��")){
			list.add(book);
			book=null;
		}
		currentTag=null;
	}

	public List getBook(){
		return list;
	}
}