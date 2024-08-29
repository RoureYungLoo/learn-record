<%--
  Created by IntelliJ IDEA.
  User: RuoYang
  Date: 2024/8/25
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示</title>
</head>
<body>
/show.jsp, 显示request作用域中的数据
<h2>msg数据: <%=request.getAttribute("msg")%></h2>
<h2>func数据: <%=request.getAttribute("func")%></h2>
<h2>func数据: ${func}</h2>

</body>
</html>
