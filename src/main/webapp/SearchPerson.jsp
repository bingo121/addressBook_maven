<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
请选择查询类型:
<select name="type" >
	<option value="name">姓名
	<option value="phone">电话
	<option value="email">邮箱
</select>
<input type="text" name="content">
<input type="submit" value="查询">
</form>
<jsp:include page="dosearch.jsp"></jsp:include>
</body>
</html>