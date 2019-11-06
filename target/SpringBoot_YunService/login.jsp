<%@page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
</head>
<body>
    <strong style="font-size: 18px;color: red;">${message}</strong>
    <form action="${pageContext.request.contextPath}/User/login" method="get">
        用户名:<input type="text" name="username"><br/>
        年  龄:<input type="text" name="age">
        <input type="submit" value="提交">
    </form>
        <a href="${pageContext.request.contextPath}/regist.jsp"><input type="button" value="注册"></a>
</body>
</html>