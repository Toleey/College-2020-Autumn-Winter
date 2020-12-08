package org.bw.newssystem.javabean.test;

import org.bw.newssystem.pojo.News_Users;
import org.junit.jupiter.api.Test;


public class TestFS {
	
	/**
	 * 测试为什么javabean中必须有个无参构造器
	 * */
	
	@Test
	public void test() {
		//News_Users users = new News_Users();
		//根据类的全路径加载当前类到内存，并且使用无参构造方法产生相应的实例（对象）
		
		
		News_Users users ;
		try {
			users = (News_Users) Class.forName("org.bw.newsystem.pojo.News_Users").newInstance();
			System.out.println(users);
		} catch (Exception e) {
			// TODO: handle exception
		}
			
				
				
	}


}
