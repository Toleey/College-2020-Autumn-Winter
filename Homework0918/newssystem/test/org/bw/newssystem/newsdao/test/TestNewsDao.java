package org.bw.newssystem.newsdao.test;

import java.util.List;

import org.bw.newssystem.dao.news.NewsDao;
import org.bw.newssystem.dao.news.impl.NewsDaoImpl;
import org.bw.newssystem.pojo.News;
import org.junit.jupiter.api.Test;

public class TestNewsDao {
	
	NewsDao nd = new NewsDaoImpl();
	
	@Test
	public void TestNewsDao() {
		
		try {
			
			List<News> list = nd.getNewsList();
			
			for( int i = 0;i < list.size();i++){
				System.out.println(list.get(i).getNtitle()+"作者:"+list.get(i).getNauthor());
			
			}
			
//			System.out.println(list.get(59).getNtitle()+"作者:"+list.get(59).getNauthor());
			
//			for (News news : list) {
//				System.out.println(list);
//			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
