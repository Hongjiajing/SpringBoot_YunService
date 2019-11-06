<%@page contentType="text/html;charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
</head>
<body>
    <form action="${pageContext.request.contextPath}/User/regist" method="get">
        姓名:<input type="text" name="username"><br/>
        年龄:<input type="text" name="age"><br/>
        性别:<input type="text" name="sex">
        <input type="submit" value="提交">
    </form>
</body>
</html>