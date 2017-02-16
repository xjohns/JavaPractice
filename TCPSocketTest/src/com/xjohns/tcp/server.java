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
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 */

public class server {

	public static void main(String[] args) {
			try {
				//���������socket��ָ���󶨵Ķ˿ڲ������˶˿�
				ServerSocket ss = new ServerSocket(8888);
				System.out.println("======�����������������ȴ��ͻ�������======");
				//ͨ��accept()��ʼ���������ȴ��ͻ��˵�����
				Socket socket = ss.accept();
				//��ȡ������������ȡ�ͻ�����Ϣ
				InputStream is = socket.getInputStream();//��ȡ�ֽ�������
				InputStreamReader isr = new InputStreamReader(is);//���ֽ�������ת��Ϊ�ַ�������
				BufferedReader br = new BufferedReader(isr);//Ϊ����ӻ���
				String data = null;
				while ((data = br.readLine()) != null){//ѭ����ȡ�ͻ�����Ϣ
					System.out.println("�����Ƿ��������ͻ���˵��" + data);
				}
				socket.shutdownInput();//�ر�������
				//��ȡ���������Ӧ�ͻ��˵�����
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os);//���ֽ������ת��Ϊ��ӡ��
				pw.write("��ӭ��");
				pw.flush();
				//�ر������Դ
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
