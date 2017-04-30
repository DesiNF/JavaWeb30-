package day2.xml.exam;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
//xml的一些方法  获取document 和写入xml
public class XmlUtils {

	public static String Filename="src/day2/xml/exam/exam.xml";
	//获得document
	public static Document getDocument() throws Exception{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		return builder.parse(Filename);
		
	}
	
	//写入xml
	public static void write2Xml(Document document) throws Exception{
		TransformerFactory factory=TransformerFactory.newInstance();
		Transformer tf=factory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream(Filename)));
	}
}
