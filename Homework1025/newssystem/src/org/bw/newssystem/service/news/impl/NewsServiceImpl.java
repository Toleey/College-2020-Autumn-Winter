package org.bw.newssystem.service.news.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bw.newssystem.dao.news.impl.NewsDaoImpl;
import org.bw.newssystem.dao.topic.TopicDao;
import org.bw.newssystem.dao.topic.impl.TopicDaoImpl;
import org.bw.newssystem.pojo.Comments;
import org.bw.newssystem.pojo.News;
import org.bw.newssystem.pojo.Topic;
import org.bw.newssystem.service.comments.impl.CommentsServiceImpl;
import org.bw.newssystem.service.news.NewsService;



public class NewsServiceImpl implements NewsService {
	NewsDaoImpl newsdao = new NewsDaoImpl();
	
	@Override
	public List<News> getAllNews() {
		Connection conn = newsdao.getConnection();
		List<News> newsList = null;
		try {
			
			newsList =  newsdao.findAllNews(conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		return newsList;
	}

	@Override
	public Map<String, List<News>> getNewsMap() {
		Connection conn = newsdao.getConnection();
		Map<String, List<News>> sideNewsListMap = new HashMap<String, List<News>>();
		try {
			//获得国内新闻
			List<News> internalNewsList = newsdao.findNewsListByNtid(conn, 1, 0, 5);	
			//获得国际新闻
			List<News> internationalNewsList = newsdao.findNewsListByNtid(conn, 2, 0, 5);
			//获得娱乐新闻
			List<News> entertainmentNewsList = newsdao.findNewsListByNtid(conn, 5, 0, 5);
			
			//把三组新闻放到Map中
			sideNewsListMap.put("internalNewsList",internalNewsList);
			sideNewsListMap.put("internationalNewsList",internationalNewsList);
			sideNewsListMap.put("entertainmentNewsList",entertainmentNewsList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}

		return sideNewsListMap;
	}

	@Override
	public List<News> getNewsListByTid(int ntid, int start, int count) {
		Connection conn = newsdao.getConnection();
		List<News> newsList = null;
		try {
			
			newsList = newsdao.findNewsListByNtid(conn, ntid, start, count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		
		return newsList;
	}

	@Override
	public News getNewsListById(int nid) {
		Connection conn = newsdao.getConnection();
		News news = null;
		try {
			news = newsdao.findNewsListByNid(conn, nid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		return news;
	}

	
//	public int deleteNews(int nid) {
//		Connection conn = newsdao.getConnection();
//		int line = 0;
//		try {
//			line = newsdao.deleteNews(conn, nid);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			newsdao.close(null, null, conn);
//		}
//		return line;
//	}
	@Override
	public int deleteNews(int nid) {
		Connection conn = newsdao.getConnection();
		CommentsServiceImpl commentsServiceImpl = new CommentsServiceImpl();
		int line = 0;
		List<Comments> commentsList = null;
		try {
			conn.setAutoCommit(false);//循环遍历 查有没有评论 有就删除 没有就直接删除新闻
			
			commentsList = commentsServiceImpl.getCommentsByNid(nid);
			if (commentsList.size()==0) {    //没有评论
				
				try {
					
					line = newsdao.deleteNews(conn, nid);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if (commentsList.size()!=0) { //有评论
				
				line = commentsServiceImpl.delComments(nid);//依据新闻编号删除评论
				if (line != 0) {
					
					try {
						
						line = newsdao.deleteNews(conn, nid);//删除新闻
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
			}
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally {
			newsdao.close(null, null, conn);
		}
		
		
		return line;
	}

	@Override
	public int addNews(News news) {
		Connection conn = newsdao.getConnection();
		int line = 0;
		
		try {
			line = newsdao.insertNews(conn, news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		
		return line;
	}

	@Override
	public int updateNews(News news) {
		Connection conn = newsdao.getConnection();
		int line = 0;
		
		try {
			line = newsdao.UpdateNews(conn, news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		
		return line;
	}

	@Override
	public List<News> getNewsListByTidAll(int ntid) {
		Connection conn = newsdao.getConnection();
		List<News> newsList = null;
		try {
			
			newsList = newsdao.findNewsListByNtidAll(conn, ntid);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		
		return newsList;
	}

	@Override
	public List<News> getPageNewsList(int start, int count) {
		Connection conn = newsdao.getConnection();
		List<News> newslList = null;
		
			try {
				
				newslList = newsdao.findPageAllNews(conn, start, count);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				newsdao.close(null, null, conn);
			}
		
		return newslList;
	}

	@Override
	public int getPageNewsCount() {
		Connection conn = newsdao.getConnection();
		int line = 0;
		try {
			
			line = newsdao.findAllNewsCount(conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		
		return line;
	}

	@Override
	public List<News> getPageNewsListByTid(int ntid, int start, int count) {
		Connection conn = newsdao.getConnection();
		List<News> newslList = null;
		
			try {
				
				newslList = newsdao.findPageNewsByTid(conn,ntid, start, count);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				newsdao.close(null, null, conn);
			}
		
		return newslList;
	}

	@Override
	public int getPageNewsCountByTid(int ntid) {
		Connection conn = newsdao.getConnection();
		int line = 0;
		try {
			
			line = newsdao.findNewsCountByTid(conn, ntid);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		
		return line;
	}

}
