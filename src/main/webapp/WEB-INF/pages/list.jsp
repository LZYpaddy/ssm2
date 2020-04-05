<%--
  Created by IntelliJ IDEA.
  User: LZY
  Date: 2020/3/25
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>哈哈哈哈</h3>

<c:forEach items="${list}" var="account">
    ${account.name}
    ${account.money}

</c:forEach>
</body>
</html>
