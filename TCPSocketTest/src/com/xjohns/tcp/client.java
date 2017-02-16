package com.xjohns.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 客户端
 */

public class client {

	public static void main(String[] args) {
		try {
			//创建客户端socket，指定服务器地址和端口
			Socket socket = new Socket("localhost", 8888);
			//获取输出流，向服务器端发送信息
			OutputStream os = socket.getOutputStream();//字节输出流
			PrintWriter pw = new PrintWriter(os);//将输出流转换为打印流
			pw.println("用户名：admin; 密码：123");
			pw.flush();//清空缓存区，刷新打印流
			socket.shutdownOutput();//关闭输出流
			//获取输入流，读取服务端的响应
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = null;
			while ((data = br.readLine()) != null){//循环读取客户端信息
				System.out.println("这里是客户端，服务端回应说：" + data);
			}
			//关闭相关资源
			br.close();
			pw.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
