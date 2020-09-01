<%@ page language="java" import="java.util.*,java.text.*"
         contentType= "text/html; charset=utf-8" %>
<html>
    <head>
        <title>计算素数</title>
    </head>
<body>


    <%
        int a;
        int b=0;

        for (a=2000 ;a<=2013;a++){

            if (a%4==0 && a%100!=0 || a%400==0){
                b++;
            }

        }

    %>

    <h1>2000年-2013年期间，共有</h1>
    <h2><%=b %></h2>
    <h1>个闰年</h1>

</body>
</html>
