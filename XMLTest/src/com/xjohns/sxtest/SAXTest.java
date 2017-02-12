package com.xjohns.sxtest;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXTest {

	public static void main(String[] args) {
		//��ȡSAXParserFactory��ʵ��
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//��ȡSAXParserʵ��
		try {
			SAXParser parser = factory.newSAXParser();
			//����һ��SAXHandler����ʵ��
			SAXHandler handler = new SAXHandler();
			parser.parse("XMLTest.xml", handler);
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
