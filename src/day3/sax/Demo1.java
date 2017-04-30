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

/**
 * 
 * @author Administrator
 *sax解析xml
 */
public class Demo1 {

	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException{
		//1 创建解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2 创建解析器
		SAXParser sp=factory.newSAXParser();
		//3 得到读取器
		XMLReader reader=sp.getXMLReader();
		//4 设置内容处理器
		reader.setContentHandler(new ListHandler());
		//5 读取xml文档内容
		reader.parse("src/book.xml");
		
	}
}

class ListHandler implements ContentHandler{

	@Override
	public void characters(char[] ch, int localName, int name) throws SAXException {
		
		System.out.println(new String(ch,localName,name));
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endElement(String ch, String localName, String name) throws SAXException {
		System.out.println("</"+name+">");
	}

	@Override
	public void endPrefixMapping(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentLocator(Locator arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startElement(String url, String localName, String name, Attributes atts) throws SAXException {

		System.out.println("<"+name+">");
		
		for(int i=0;atts!=null&&i<atts.getLength();i++){
			String attName=atts.getQName(i);
			String attValue=atts.getValue(i);
			System.out.println(attName+"="+attValue);
		}
	}

	@Override
	public void startPrefixMapping(String arg0, String arg1) throws SAXException {
		// TODO Auto-generated method stub
		
	}
	
}