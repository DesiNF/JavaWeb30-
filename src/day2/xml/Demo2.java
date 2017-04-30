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

//ʹ��dom��ʽ��xml���н���
public class Demo2 {
	/**
	 * 1 �������� 2 �õ�dom������ 3 ����xml�ĵ����õ������ĵ���document
	 * 
	 * @throws Exception
	 */

	// ��ȡ��һ������
	@Test
	public void read1() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		NodeList list = document.getElementsByTagName("����");
		Node node = list.item(1);
		String content = node.getTextContent();
		System.out.println(content);
	}

	// �������б�ǩ������
	@Test
	public void read2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Node root = document.getElementsByTagName("���").item(0);
		list(root);
	}

	private void list(Node node) {

		if (node instanceof Element) {// ֻ��ȡ��ǩ
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node child = list.item(i);
			list(child);
		}
	}

	// <���� name="xxx">book1</����> ��ȡname������
	@Test
	public void read3() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");
		Element node = (Element) document.getElementsByTagName("����").item(0);
		System.out.println(node.getAttribute("name"));
	}

	// �ڵ�һ��������һ���ڵ�
	@Test
	public void add1() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		// �����ڵ�
		Element ele = document.createElement("����");
		ele.setTextContent("add");

		// �Ѵ����Ľڵ�ҵ���һ������
		Element book = (Element) document.getElementsByTagName("��").item(0);// Node��Element����
																			// ǿת
		book.appendChild(ele);

		// �Ѹ��º��ڴ�д��xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	// ��ָ��λ�����ӽڵ�
	@Test
	public void add2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		// �����ڵ�
		Element ele = document.createElement("����");
		ele.setTextContent("add");

		// �õ��ο��ڵ�
		Element refNode = (Element) document.getElementsByTagName("�ۼ�").item(0);

		// �õ�Ҫ���̵Ľڵ�
		Element book = (Element) document.getElementsByTagName("��").item(0);// Node��Element����
																			// ǿת

		// ��book�ڵ��ָ��λ�ò���
		book.insertBefore(ele, refNode);// ��ele����refNodeǰ��

		// �Ѹ��º��ڴ�д��xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	// ��xml�ĵ��ڵ����������
	@Test
	public void addAttr() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Element bookname = (Element) document.getElementsByTagName("����").item(0);
		bookname.setAttribute("name", "xxx");

		// �Ѹ��º��ڴ�д��xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	@Test
	public void delete1() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		// �õ�Ҫɾ���Ľڵ�
		Element e = (Element) document.getElementsByTagName("����").item(0);

		// �õ�Ҫɾ���Ľڵ�İְ�
		Element book = (Element) document.getElementsByTagName("��").item(0);

		book.removeChild(e);

		// �Ѹ��º��ڴ�д��xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}

	@Test
	public void delete2() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		// �õ�Ҫɾ���Ľڵ�
		Element e = (Element) document.getElementsByTagName("����").item(0);
		e.getParentNode().removeChild(e);

		// �Ѹ��º��ڴ�д��xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
	
	@Test
	public void updata() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/book.xml");

		Element e = (Element) document.getElementsByTagName("����").item(0);
		e.setTextContent("���º�");

		// �Ѹ��º��ڴ�д��xml
		TransformerFactory tffactory = TransformerFactory.newInstance();
		Transformer tf = tffactory.newTransformer();
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream("src/book.xml")));
	}
}
