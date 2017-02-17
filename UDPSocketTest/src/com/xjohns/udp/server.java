package com.xjohns.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * 服务器端，用于实现客户端的登录
 */

public class server {

	public static void main(String[] args) {
		try {
			/*
			 * 接收客户端发送的数据
			 */
			//创建服务器端，指定端口
			DatagramSocket socket = new DatagramSocket(8800);
			//创建数据报，接收client发送的数据
			byte [] data = new byte [1024];//创建字节数组，指定接收的数据包的大小
			DatagramPacket packet = new DatagramPacket(data, data.length);
			//通过socket的receive()接收数据
			System.out.println("=====服务器已启动，等待客户端连接=====");
			socket.receive(packet);//此方法在接收到数据报之前会一直阻塞
			//读取数据
			String info = new String(data, 0, packet.getLength());
			System.out.println("这里是服务器，客户端说：" + info);
			/*
			 * 向客户端响应数据
			 */
			//定义客户端的地址、端口、数据
			InetAddress address = packet.getAddress();
			int port = 8800;
			byte [] data2 = "欢迎！".getBytes();
			//创建数据报，包含响应的数据信息
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
			//响应客户端
			socket.send(packet2);
			//关闭资源
			socket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
