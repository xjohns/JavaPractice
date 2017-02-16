package com.xjohns.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 */

public class server {

	public static void main(String[] args) {
			try {
				//创建服务端socket，指定绑定的端口并监听此端口
				ServerSocket ss = new ServerSocket(8888);
				System.out.println("======服务器即将启动，等待客户端连接======");
				//通过accept()开始监听，并等待客户端的连接
				Socket socket = ss.accept();
				//获取输入流，并读取客户端信息
				InputStream is = socket.getInputStream();//获取字节输入流
				InputStreamReader isr = new InputStreamReader(is);//将字节输入流转换为字符输入流
				BufferedReader br = new BufferedReader(isr);//为其添加缓存
				String data = null;
				while ((data = br.readLine()) != null){//循环读取客户端信息
					System.out.println("这里是服务器，客户端说：" + data);
				}
				socket.shutdownInput();//关闭输入流
				//获取输出流，响应客户端的请求
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os);//将字节输出流转换为打印流
				pw.write("欢迎！");
				pw.flush();
				//关闭相关资源
				pw.close();
				os.close();
				br.close();
				isr.close();
				is.close();
				socket.close();
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}

}
