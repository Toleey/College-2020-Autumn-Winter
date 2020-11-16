package com.toleey.bbsmsg.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class DirtyWords extends HttpServletRequestWrapper {

		
		 
		 private String strs[] = {"傻逼", "畜生", "我去年买了个包"};
         private HttpServletRequest request;

         public DirtyWords(HttpServletRequest request) {
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
