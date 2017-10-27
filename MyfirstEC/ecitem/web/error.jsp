<%-- 
    Document   : error
    Created on : 2017/10/24, 11:35:55
    Author     : geust1Day
--%>
<%@page import="page.jums"%>
<%@page import="jums.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>エラー</title>
    </head>
    <body>
        エラーが起きました。
        <%=request.getAttribute("error")%>
         <%=jums.getInstance().topLink()%>
    </body>
</html>
