package com.xjohns.urltest;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		try {
			//创建一个URL实例
			URL imooc = new URL("http://www.imooc.com");
			//?后面表示参数，#表示锚点
			URL url = new URL(imooc, "/index.html?username=xjohns#test");
			System.out.println("协议：" + url.getProtocol());
			System.out.println("主机：" + url.getHost());
			System.out.println("端口：" + url.getPort());
			System.out.println("文件路径：" + url.getPath());
			System.out.println("查询字符串：" + url.getQuery());
			System.out.println("使用者信息：" + url.getUserInfo());
			System.out.println("授权部分：" + url.getAuthority());
			System.out.println("文件名：" + url.getFile());
			System.out.println("默认端口号：" + url.getDefaultPort());
			System.out.println("锚点：" + url.getRef());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
