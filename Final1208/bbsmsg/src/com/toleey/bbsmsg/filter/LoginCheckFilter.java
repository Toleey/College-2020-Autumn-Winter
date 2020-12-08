package com.toleey.bbsmsg.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpSession session = httpServletRequest.getSession();

        if (session.getAttribute("loginuser")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else if ((session.getAttribute("loginuser")==null)){
            httpServletRequest.setAttribute("error","您还没有登陆！");
            httpServletRequest.getRequestDispatcher("index.jsp").forward(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
