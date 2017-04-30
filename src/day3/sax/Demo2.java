package day3.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Administrator sax����xml
 */
public class Demo2 {

	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
		// 1 ������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2 ����������
		SAXParser sp = factory.newSAXParser();
		// 3 �õ���ȡ��
		XMLReader reader = sp.getXMLReader();
		// 4 �������ݴ�����
		reader.setContentHandler(new TagValueHandler());
		// 5 ��ȡxml�ĵ�����
		reader.parse("src/book.xml");

	}
}

class TagValueHandler extends DefaultHandler {
	private String currentTag;//��ס��ǰ����������ʲô��ǩ
	private int needNumber=2;//��ס���ȡ�ڼ������߱�ǩ��ֵ
	private int currentNumber;//��ǰ�������ĵڼ���

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("����".equals(currentTag)&&currentNumber==needNumber){
			System.out.println(new String (ch,start,length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		currentTag=null;
	}

	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		currentTag=name;
		if(currentTag.equals("����")){
			currentNumber++;
		}
	}

}