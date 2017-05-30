<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.myBean.*"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	request.setCharacterEncoding("utf-8");
	int id = Integer.parseInt(request.getParameter("id"));
	ArrayList<AdbooksData> personList=(ArrayList<AdbooksData>)session.getAttribute("personLists");
	AdbooksData person = personList.get(id);
	
	if(person!=null){
%>
	<form action="AbooksOper?do=update" method=post>
	<table border=1>
	<tr><td>姓名:</td><td><Input type="text" name="name" value="<%=person.getName()%>"></td></tr>
	<tr><td>性别:</td><td><Input type="text" name="sex" value="<%=person.getSex()%>"></td></tr>
	<tr><td>电话:</td><td><Input type="text" name="phone" value="<%=person.getPhone()%>"></td></tr>
	<tr><td>邮箱:</td><td><Input type="text" name="email" value="<%=person.getEmail()%>"></td></tr>
	<tr><td>地址:</td><td><Input type="text" name="address" value="<%=person.getAddress()%>"></td></tr>
	</table>
	<br><input type="submit" name="b" value="修改">
	
	<input type="hidden" name="id" value="<%=id %>">

<%} %>

</body>
</html>