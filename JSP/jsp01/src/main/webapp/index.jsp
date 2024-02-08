<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<%
 System.out.println("hello jsp");
 //定义的是局部变量
     int i = 5;
     //获取虚拟目录
         String contextPath = request.getContextPath();
         //输出到页面上
             out.print(contextPath);
 %>

<%!
 //定义的是成员变量
     int i = 3;
 %>

<%=
 "helloo"
 %>
 <% response.getWriter().write("response....."); %>
</body>
</html>
