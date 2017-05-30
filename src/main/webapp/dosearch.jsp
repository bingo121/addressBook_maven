<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,com.myBean.*"
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
    String type = request.getParameter("type");
    String content = request.getParameter("content");
    
    if(type!=null&&!type.equals("")&&content!=null&&!content.equals("")){
	    ArrayList<AdbooksData> personList=(ArrayList<AdbooksData>)session.getAttribute("personLists");
		if(personList==null){
			AdbooksDataOpr dOper = new AdbooksDataOpr();
			personList =  dOper.getAdbooksList(DataFilePath.getFilePath());
			session.setAttribute("personLists", personList);
		}
	
		ArrayList<AdbooksData> persons = AdbooksDataOpr.searchPerson(type, content, personList);
   
  
          out.print("<br><br>");
          out.print("<table border=2 style=\"text-align:center\">");
          out.print("<tr>");
            out.print("<th width=100>"+"姓名");
            out.print("<th width=80>"+"性别");
            out.print("<th width=120>"+"电话");
            out.print("<th width=200>"+"邮箱");
            out.print("<th width=250>"+"地址");
          out.print("</tr>");
          for(AdbooksData person:persons){
            out.print("<tr>");
              out.print("<td >"+person.getName()+"</td>"); 
              out.print("<td >"+person.getSex()+"</td>");
              out.print("<td >"+person.getPhone()+"</td>"); 
              out.print("<td >"+person.getEmail()+"</td>");
              out.print("<td >"+person.getAddress()+"</td>"); 
            out.print("</tr>") ; 
          }
          out.print("</table>");
   }
 %>
</body>
</html>