package org.bw.newssystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter  {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest)request).getSession();
		String contextPath = ((HttpServletRequest)request).getContextPath();
		String uri=((HttpServletRequest) request).getRequestURI();
		
		//"/newssystem/util/../newspages/news_read.jsp".equals(uri)
		//>=0
		if (uri.indexOf("/news_read.jsp")>-1) {
			chain.doFilter(request, response);
		}else {
			if (session.getAttribute("uname")!=null) {			
			    chain.doFilter(request, response);			
			}else {//括号优先级大于点优先级
				((HttpServletResponse)response).sendRedirect(contextPath+"/util/news_control?opr=list");
			}
		}
//		if (uri.indexOf("/news_read.jsp")>-1) {
//			chain.doFilter(request, response);
//			return;
//		}
//		if (session.getAttribute("uname")!=null) {			
//		    chain.doFilter(request, response);			
//		}else {//括号优先级大于点优先级
//			((HttpServletResponse)response).sendRedirect(contextPath+"/util/news_control?opr=list");
//		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
