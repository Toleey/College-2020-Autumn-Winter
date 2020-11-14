package com.toleey.bbsmsg.filter;

import com.toleey.bbsmsg.service.word.impl.WordServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WordsFilter implements Filter {
        WordServiceImpl wordServiceImpl = new WordServiceImpl();
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
            HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
            DirtyWordHttpServletRequest dwrequest = new DirtyWordHttpServletRequest(httpServletRequest);
            filterChain.doFilter(dwrequest, httpServletResponse);


        }

        @Override
        public void destroy() {

        }


        class DirtyWordHttpServletRequest extends HttpServletRequestWrapper {


            private String strs[] = {"傻逼", "畜生", "我去年买了个包"};
            private HttpServletRequest request;

            public DirtyWordHttpServletRequest(HttpServletRequest request) {
                super(request);
                this.request = request;
            }

            @Override
            public String getParameter(String name) {
                String value = request.getParameter(name);
                if (value == null)
                    return null;
                for (String s : strs) {
                    if (value.contains(s)) {
                        value = value.replace(s, "**");
                    }
                }
                return value;
            }
        }


    }
