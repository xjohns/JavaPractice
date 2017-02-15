package com.xjohns.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DOM4JTest {

	public static void main(String[] args) {
		// 解析xml文件
		// 创建SAXRreader对象的实例
		SAXReader reader = new SAXReader();
		try {
			//通过SAXRreader对象的read方法加载xml文件,获取docunment对象
			org.dom4j.Document document = reader.read(new File("src/res/XMLTest.xml"));
			//通过document对象获取根节点bookstore
			Element bookstore = document.getRootElement();
			//通过Element对象的elementIterator()获取迭代器
			Iterator it = bookstore.elementIterator();
			//遍历迭代器，获取根节点中的信息
			while (it.hasNext()){
				System.out.println("=========开始遍历书籍=========");
				Element book = (Element) it.next();
				//获取book的属性名及属性值
				List <Attribute> bookattr = book.attributes();
				for (Attribute attr : bookattr){
					System.out.println("节点名：" + attr.getName() + "--节点值：" + attr.getValue());
				}
				Iterator itr = book.elementIterator();
				while (itr.hasNext()){
					Element bookChild = (Element) itr.next();
					System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
				}
				System.out.println("=========结束遍历书籍=========");
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
