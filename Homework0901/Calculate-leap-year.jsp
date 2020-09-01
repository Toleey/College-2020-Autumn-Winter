<%@ page language="java" import="java.util.*,java.text.*"
         contentType= "text/html; charset=utf-8" %>
<html>
    <head>
        <title>计算闰年</title>
    </head>
<body>

        1-100素数之和:
         
    <%
        int i,j,sum=0;
            for(i=1;i<100;i++){
                for (j=2;j<i;j++){
                    if (i % j == 0){
                        break;
                    }
                }
                if (j == i){
                    sum+=i;
                }
        }

    %>

    <%=sum%>

</body>
</html>
