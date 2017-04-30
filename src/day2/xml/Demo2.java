package day2.xml;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//使用dom方式对xml进行解析
public class Demo2 {
	/**
	 * 1 创建工厂 2 得到dom解析器 3 解析xml文档，得到代表文档的document
	 * 
	 * @throws Exception
	 */

	// 读取第一个书名
	@Test
	public void read1() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		NodeList list = document.getElementsByTagName("书名");
		Node node = list.item(1);
		String content = node.getTextContent();
		System.out.println(content);
	}

	// 遍历所有标签的名字
	@Test
	public void read2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Node root = document.getElementsByTagName("书架").item(0);
		list(root);
	}

	private void list(Node node) {

		if (node instanceof Element) {// 只读取标签
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			list(child);
		}
	}

	// <书名 name="xxx">book1</书名> 获取name的属性
	@Test
	public void read3() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		Element node = (Element) document.getElementsByTagName("书名").item(0);
		System.out.println(node.getAttribute("name"));
	}

	// 在第一本书增加一个节点
	@Test
	public void add1() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		// 创建节点
		Element ele = document.createElement("新增");
		ele.setTextContent("add");

		// 把创建的节点挂到第一本书上
		Element book = (Element) document.getElementsByTagName("书").item(0);// Node是Element父类
																			// 强转
		book.appendChild(ele);

		// 把更新后内存写回xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	// 在指定位置增加节点
	@Test
	public void add2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		// 创建节点
		Element ele = document.createElement("新增");
		ele.setTextContent("add");

		// 得到参考节点
		Element refNode = (Element) document.getElementsByTagName("售价").item(0);

		// 得到要挂崽的节点
		Element book = (Element) document.getElementsByTagName("书").item(0);// Node是Element父类
																			// 强转

		// 往book节点的指定位置插崽
		book.insertBefore(ele, refNode);// 将ele插在refNode前面

		// 把更新后内存写回xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	// 向xml文档节点上添加属性
	@Test
	public void addAttr() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Element bookname = (Element) document.getElementsByTagName("书名").item(0);
		bookname.setAttribute("name", "xxx");

		// 把更新后内存写回xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	@Test
	public void delete1() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		// 得到要删除的节点
		Element e = (Element) document.getElementsByTagName("新增").item(0);

		// 得到要删除的节点的爸爸
		Element book = (Element) document.getElementsByTagName("书").item(0);

		book.removeChild(e);

		// 把更新后内存写回xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	@Test
	public void delete2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		// 得到要删除的节点
		Element e = (Element) document.getElementsByTagName("新增").item(0);
		e.getParentNode().removeChild(e);

		// 把更新后内存写回xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	@Test
	public void updata() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Element e = (Element) document.getElementsByTagName("作者").item(0);
		e.setTextContent("更新后");

		// 把更新后内存写回xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
}
