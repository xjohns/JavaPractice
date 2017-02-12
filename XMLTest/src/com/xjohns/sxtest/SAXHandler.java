package com.xjohns.sxtest;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	int bookIndex = 0;
	@Override
	/**
	 * ��������xml�ļ��Ŀ�ʼ��ǩ
	 */
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//����DefaultHandler���startElement����
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals("book")){
			bookIndex ++;
			//��ʼ����bookԪ�ص�����
			System.out.println("=============��ʼ������" + bookIndex + "��������============");
//			//��֪bookԪ�������Ե����ƣ������������ƻ�ȡ����ֵ
//			String value = attributes.getValue("id");
//			System.out.println("book������ֵ�ǣ�" + value);
			//��֪��bookԪ�������Ե������Լ�����
			int num = attributes.getLength();
			for (int i = 0; i < num; i++){
				System.out.print("bookԪ�صĵ�" + (i + 1) + "���������ǣ�" + attributes.getQName(i));
				System.out.println("---����ֵ�ǣ�" + attributes.getValue(i));
			}
		}
		else if (!qName.equals("bookstore")){
			System.out.print("�ڵ����ǣ�" + qName);
		}
	}
	
	/**
	 * ��������xml�ļ��Ľ�����ǩ
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//����DefaultHandler���endElement����
		super.endElement(uri, localName, qName);
		//�ж��Ƿ�һ�����Ѿ���������
		if (qName.equals("book")){
			System.out.println("=============����������" + bookIndex + "��������============");
		}
		
	}
	
	/**
	 * ������ʶ������ʼ
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("SAX������ʼ");
	}
	
	/**
	 * ������ʶ��������
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("SAX��������");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String value = new String(ch, start, length);
		if (!value.trim().equals("")){
			System.out.println("---�ڵ�ֵ�ǣ�" + value);
		}
	}

}
