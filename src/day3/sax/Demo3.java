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
		// 1 创建解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2 创建解析器
		SAXParser sp = factory.newSAXParser();
		// 3 得到读取器
		XMLReader reader = sp.getXMLReader();
		// 4 设置内容处理器
		BeanListHandler handle=new BeanListHandler();
		reader.setContentHandler(handle);
		// 5 读取xml文档内容
		reader.parse("src/book.xml");

		List<Book>list=handle.getBook();
		System.out.println(list);
	}
}

// 把xml文档中的每一本书封装到一个book对象，并把多个book对象放在一个list集合返回 
class BeanListHandler extends DefaultHandler {
	private List list=new ArrayList();
	private String currentTag;
	private Book book;
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		currentTag=name;
		if("书".equals(currentTag)){
			book=new Book();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("书名".equals(currentTag)){
			String name=new String (ch,start,length);
			book.setName(name);
		}
		if("作者".equals(currentTag)){
			String author=new String (ch,start,length);
			book.setAuthor(author);
		}
		if("售价".equals(currentTag)){
			String price=new String (ch,start,length);
			book.setPrice(price);
		}
	}

	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		if(name.equals("书")){
			list.add(book);
			book=null;
		}
		currentTag=null;
	}

	public List getBook(){
		return list;
	}
}