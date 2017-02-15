package com.xjohns.urltest;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		try {
			//����һ��URLʵ��
			URL imooc = new URL("http://www.imooc.com");
			//?�����ʾ������#��ʾê��
			URL url = new URL(imooc, "/index.html?username=xjohns#test");
			System.out.println("Э�飺" + url.getProtocol());
			System.out.println("������" + url.getHost());
			System.out.println("�˿ڣ�" + url.getPort());
			System.out.println("�ļ�·����" + url.getPath());
			System.out.println("��ѯ�ַ�����" + url.getQuery());
			System.out.println("ʹ������Ϣ��" + url.getUserInfo());
			System.out.println("��Ȩ���֣�" + url.getAuthority());
			System.out.println("�ļ�����" + url.getFile());
			System.out.println("Ĭ�϶˿ںţ�" + url.getDefaultPort());
			System.out.println("ê�㣺" + url.getRef());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
