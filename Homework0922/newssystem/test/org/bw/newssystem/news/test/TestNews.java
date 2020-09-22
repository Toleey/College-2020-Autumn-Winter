package org.bw.newssystem.news.test;

import java.util.List;

import org.bw.newssystem.pojo.News;
import org.bw.newssystem.service.news.NewsService;
import org.bw.newssystem.service.news.impl.NewsServiceImpl;
import org.junit.jupiter.api.Test;

public class TestNews {

	NewsService ns = new NewsServiceImpl();
	
	@Test
	public void testGetAllNews() {
		List<News> newslList = ns.getAllNews();
		System.out.println(newslList);
	}
}
