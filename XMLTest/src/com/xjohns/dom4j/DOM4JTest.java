package com.xjohns.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JTest {

	public static void main(String[] args) {
		// ����xml�ļ�
		// ����SAXRreader�����ʵ��
		SAXReader reader = new SAXReader();
		try {
			//ͨ��SAXRreader�����read��������xml�ļ�,��ȡdocunment����
			org.dom4j.Document document = reader.read(new File("src/res/XMLTest.xml"));
			//ͨ��document�����ȡ���ڵ�bookstore
			Element bookstore = document.getRootElement();
			//ͨ��Element�����elementIterator()��ȡ������
			Iterator it = bookstore.elementIterator();
			//��������������ȡ���ڵ��е���Ϣ
			while (it.hasNext()){
				System.out.println("=========��ʼ�����鼮=========");
				Element book = (Element) it.next();
				//��ȡbook��������������ֵ
				List <Attribute> bookattr = book.attributes();
				for (Attribute attr : bookattr){
					System.out.println("�ڵ�����" + attr.getName() + "--�ڵ�ֵ��" + attr.getValue());
				}
				Iterator itr = book.elementIterator();
				while (itr.hasNext()){
					Element bookChild = (Element) itr.next();
					System.out.println("�ڵ�����" + bookChild.getName() + "--�ڵ�ֵ��" + bookChild.getStringValue());
				}
				System.out.println("=========���������鼮=========");
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
