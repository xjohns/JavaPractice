package com.xjohns.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * �ͻ���
 */

public class client {

	public static void main(String[] args) {
		try {
			//�����ͻ���socket��ָ����������ַ�Ͷ˿�
			Socket socket = new Socket("localhost", 8888);
			//��ȡ���������������˷�����Ϣ
			OutputStream os = socket.getOutputStream();//�ֽ������
			PrintWriter pw = new PrintWriter(os);//�������ת��Ϊ��ӡ��
			pw.println("�û�����admin; ���룺123");
			pw.flush();//��ջ�������ˢ�´�ӡ��
			socket.shutdownOutput();//�ر������
			//��ȡ����������ȡ����˵���Ӧ
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = null;
			while ((data = br.readLine()) != null){//ѭ����ȡ�ͻ�����Ϣ
				System.out.println("�����ǿͻ��ˣ�����˻�Ӧ˵��" + data);
			}
			//�ر������Դ
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
