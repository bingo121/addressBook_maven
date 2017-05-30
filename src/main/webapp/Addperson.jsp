<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.myBean.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	ArrayList<AdbooksData> personList=(ArrayList<AdbooksData>)session.getAttribute("personLists");
	if(personList==null){
		AdbooksDataOpr dOper = new AdbooksDataOpr();
		personList =  dOper.getAdbooksList(DataFilePath.getFilePath());
		session.setAttribute("personLists", personList);
	}
%>
<form action="AbooksOper?do=add" method=post>
	<table border=1>
	<tr><td>姓名:</td><td width="80"><Input type="text" name="name" value=""></td></tr>
	<tr><td>性别:</td><td width="80"><Input type="text" name="sex" value=""></td></tr>
	<tr><td>电话:</td><td width="80"><Input type="text" name="phone" value=""></td></tr>
	<tr><td>邮箱:</td><td width="80"><Input type="text" name="email" value=""></td></tr>
	<tr><td>地址:</td><td width="80"><Input type="text" name="address" value=""></td></tr>
	</table>
	<br><input type="submit"  value="添加">
</form>
</body>

</html>