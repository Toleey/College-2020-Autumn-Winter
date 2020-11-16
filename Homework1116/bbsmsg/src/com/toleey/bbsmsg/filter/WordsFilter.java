package com.toleey.bbsmsg.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WordsFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
            HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
            //DirtyWordHttpServletRequest dwrequest = new DirtyWordHttpServletRequest(httpServletRequest);
            DirtyWords dirtyWords = new DirtyWords(httpServletRequest);//构造方法需要传request
            filterChain.doFilter(dirtyWords, httpServletResponse);


        }

        @Override
        public void destroy() {

        }


       


    }
