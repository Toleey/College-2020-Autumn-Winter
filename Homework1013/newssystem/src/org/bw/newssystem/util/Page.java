package org.bw.newssystem.util;

import java.util.List;

/**
 * 分页类型
 * */
//自定义一个泛型
public class Page<T> {
	//当前页码 (currentPage)
	private int curPage;
	//每页显示的行数
	private int pageSize = 15;
	//总的记录数(数据库查出来的) 不赋值默认为0
	private int totalCount;
	//总的页数
	private int pageCount;
	//要显示的数据记录(数据库查出来) 数据类型不能确定，用泛型表达
	private List<T>  newsList;
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
//		if (totalCount%pageSize==0) {
//			pageCount = totalCount/pageSize;//都是整型就不能再取整了,不能再向上取整了
//		}else {//有余数的时候再加一页
//			pageCount = totalCount/pageSize+1;
//		} 与下面的一样，三目运算符
		pageCount = totalCount%pageSize==0 ? totalCount/pageSize : totalCount/pageSize+1;
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<T> newsList) {
		this.newsList = newsList;
	}
	
	@Override
	public String toString() {
		return "Page [curPage=" + curPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", pageCount="
				+ pageCount + ", newsList=" + newsList + "]";
	}
	
	
	
}
