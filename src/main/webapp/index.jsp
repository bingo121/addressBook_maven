<%@ page language="java" contentType="text/html; charset=UTF-8 " import="java.util.*,com.myBean.*"
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
	ArrayList<AdbooksData> personList=(ArrayList<AdbooksData>)session.getAttribute("personLists");
	if(personList==null){
		AdbooksDataOpr dOper = new AdbooksDataOpr();
		personList =  dOper.getAdbooksList(DataFilePath.getFilePath());
		session.setAttribute("personLists", personList);
	}
	
	%>
	<table border="2" style="text-align:center">
		<tr>
			<td width="100">姓名</td>
			<td width="50">性别</td>
			<td width="120">电话</td>
			<td width="200">邮箱</td>
			<td width="260">地址</td>
			<td width="100">操作</td>
			
		</tr>
	
	<%
	
	for(AdbooksData linkPerson : personList){
	%>
		<tr>
			<td ><%=linkPerson.getName() %></td>
			<td ><%=linkPerson.getSex() %></td>
			<td ><%=linkPerson.getPhone() %></td>
			<td ><%=linkPerson.getEmail() %></td>
			<td ><%=linkPerson.getAddress() %></td>
			
			<td ><a href="UpdatePerson.jsp?id=<%=personList.indexOf(linkPerson) %>">修改</a>&nbsp;&nbsp;<a href="AbooksOper?do=delete&&id=<%=personList.indexOf(linkPerson) %>" >删除</a></td>
			
		</tr>	
	<%
	}
	%>
	
	</table>
	<%
%>
</body>
</html>