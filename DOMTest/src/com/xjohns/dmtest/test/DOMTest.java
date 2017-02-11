package com.xjohns.dmtest.test;

import java.io.IOException;

import javax.jws.soap.SOAPBinding;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {

	public static void main(String[] args) {
		//����DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			//����DocumentBuilder����
			DocumentBuilder db = dbf.newDocumentBuilder();
			//ͨ��DocumentBuilder��parse��������xml�ļ���������org.w3c.dom�µ�Document�������
			Document doc = db.parse("domTest.xml");
			//��ȡ����book�ڵ�ļ���
			NodeList bookList = doc.getElementsByTagName("book");
			//ͨ��NodeList��getLength�������Ի�ȡbookList�ĳ���
			System.out.println("һ����" + bookList.getLength() + "����");
			//����ÿһ��book�ڵ�
			for (int i = 0; i < bookList.getLength(); i++){
				System.out.println("===============���濪ʼ������" + ( i + 1) + "���������=============");
				//ͨ��item(i)������ȡһ��book�ڵ㣬nodelist������ֵ��0��ʼ
				Node book = bookList.item(i);
				//��ȡbook�ڵ���������Լ���
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("��" + (i + 1) + "���鹲��" + attrs.getLength() +"������");
				//����book������
				for (int j = 0; j < attrs.getLength(); j++){
					//ͨ��item(index)������ȡbook�ڵ��ĳһ����
					Node attr = attrs.item(j);
					//��ȡ��������
					System.out.println("������" + attr.getNodeName());
					//��ȡ����ֵ
					System.out.println("����ֵ" + attr.getNodeValue());
				}
//				//ǰ�᣺�Ѿ�֪��book�ڵ�����ֻ����1��id����
//				//��book�ڵ����ǿ������ת����ת��Element����
//				Element book = (Element) bookList.item(i);
//				//ͨ��getAttribute("id")������ȡ����ֵ
//				String attrValue = book.getAttribute("id");
//				System.out.println("id���Ե�����ֵΪ" + attrValue);
				//����book�ڵ���ӽڵ�
				NodeList childNodes = book.getChildNodes();
				//����childNodes��ȡÿ���ڵ�Ľڵ����ͽڵ�ֵ��xml�ڵ�������ʱ�ո�+������һ���ڵ㣩
				System.out.println("��" + (i + 1) + "���鹲��" + childNodes.getLength() + "�ӽڵ�");
				for (int k = 0; k < childNodes.getLength(); k++){
					//����text���͵�node��element���͵�node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
						//��ȡelement���͵Ľڵ���
						System.out.println("��" + (k + 1) + "���ڵ�Ľڵ���Ϊ" + childNodes.item(k).getNodeName());
						//��ȡelement���͵Ľڵ�ֵ
						System.out.println("--�ڵ�ֵΪ" + childNodes.item(k).getFirstChild().getNodeValue());
						//Ҳ���Ի�ȡ�ڵ�ֵ�������Ƿ����ı����ݣ������ʹ��
//						System.out.println("--�ڵ�ֵΪ" + childNodes.item(k).getTextContent());
					}
				}
				System.out.println("===============����������" + ( i + 1) + "���������=============");
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
