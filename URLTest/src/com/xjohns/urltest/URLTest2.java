package com.xjohns.urltest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {

	public static void main(String[] args) {
		try {
			//����URL����
			URL url = new URL("http://www.baidu.com");
			//ͨ��openStream()��ȡ�ֽ�������
			InputStream is = url.openStream();
			//���ֽ�������ת��Ϊ�ַ�������
			InputStreamReader isr = new InputStreamReader(is ,"utf-8");
			//Ϊ�ַ���������ӻ���
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();//��ȡ����
			while (data != null){//ѭ����ȡ����
				System.out.println(data);
				data = br.readLine();
			}
			is.close();
			isr.close();
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
