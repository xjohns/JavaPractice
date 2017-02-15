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
			//创建URL对象
			URL url = new URL("http://www.baidu.com");
			//通过openStream()获取字节输入流
			InputStream is = url.openStream();
			//将字节输入流转化为字符输入流
			InputStreamReader isr = new InputStreamReader(is ,"utf-8");
			//为字符输入流添加缓存
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();//读取数据
			while (data != null){//循环读取数据
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
