package com.xjohns.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * �������ˣ�����ʵ�ֿͻ��˵ĵ�¼
 */

public class server {

	public static void main(String[] args) {
		try {
			/*
			 * ���տͻ��˷��͵�����
			 */
			//�����������ˣ�ָ���˿�
			DatagramSocket socket = new DatagramSocket(8800);
			//�������ݱ�������client���͵�����
			byte [] data = new byte [1024];//�����ֽ����飬ָ�����յ����ݰ��Ĵ�С
			DatagramPacket packet = new DatagramPacket(data, data.length);
			//ͨ��socket��receive()��������
			System.out.println("=====���������������ȴ��ͻ�������=====");
			socket.receive(packet);//�˷����ڽ��յ����ݱ�֮ǰ��һֱ����
			//��ȡ����
			String info = new String(data, 0, packet.getLength());
			System.out.println("�����Ƿ��������ͻ���˵��" + info);
			/*
			 * ��ͻ�����Ӧ����
			 */
			//����ͻ��˵ĵ�ַ���˿ڡ�����
			InetAddress address = packet.getAddress();
			int port = 8800;
			byte [] data2 = "��ӭ��".getBytes();
			//�������ݱ���������Ӧ��������Ϣ
			DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
			//��Ӧ�ͻ���
			socket.send(packet2);
			//�ر���Դ
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
