package com.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myBean.AdbooksData;
import com.myBean.AdbooksDataOpr;
import com.myBean.CheckPhone;
import com.myBean.DataFilePath;

public class AbooksOper extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AbooksOper() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("do");
		String pid = request.getParameter("id");
		HttpSession session = request.getSession(true);
		ArrayList<AdbooksData> personList=(ArrayList<AdbooksData>)session.getAttribute("personLists");
		AdbooksData person;
		
		
		
		if(pid!=null){
			int id = Integer.parseInt(pid);
			person = personList.get(id);
			
			 if(action.equals("delete")){
					
					personList = AdbooksDataOpr.deletePerson(id, personList);
					session.setAttribute("personLists",personList);
					AdbooksDataOpr.saveAdbooks(personList, DataFilePath.getFilePath());
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
					
			}else if(action.equals("update")){
						String name = request.getParameter("name");
						String sex = request.getParameter("sex");
						String phone = request.getParameter("phone");
						String email = request.getParameter("email");
						String address = request.getParameter("address");
						response.setContentType("text/html;charset=GB2312");
						PrintWriter out = response.getWriter();
						out.print("<html><body>");
						boolean isRight = true;
						
						if(!checkSex(sex)){
							isRight = false;
							out.print("性别输入错误!<br>");
						}
						if(!checkEmail(email)){
							isRight = false;
							out.print("请输入正确的邮箱!<br>");
							
						}
						
						if(!CheckPhone.isPhone(phone)){
							isRight = false;
							out.print("请输入正确的电话号码!<br>");
						}
						
						
						if(isRight){
							
							for(AdbooksData Lperson:personList){
								if(personList.indexOf(Lperson)!=id){
									if(phone.equals(Lperson.getPhone())){
										isRight=false;
										out.print("该联系号码已添加!<br>");
										break;
									}
								}
							}
							
							if(isRight){
								personList = AdbooksDataOpr.UpdataPerson(name, sex, phone, email, address, personList, id);
								session.setAttribute("personLists",personList);
								AdbooksDataOpr.saveAdbooks(personList, DataFilePath.getFilePath());
								response.sendRedirect("index.jsp");
							}else{
								out.print("</body></html>");
							}
							
						}else{
							out.print("</body></html>");
						}
					}
			 
		}else{ 
			
			if(action.equals("add")){
				String name = request.getParameter("name");
				String sex = request.getParameter("sex");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				
				boolean isRight = true;
				response.setContentType("text/html;charset=GB2312");
				PrintWriter out = response.getWriter();
				out.print("<html><body>");
				
				for(AdbooksData Lperson:personList){
					if(phone.equals(Lperson.getPhone())){
						isRight = false;
						out.print("该联系号码已添加!<br>");
						break;
					}
				}
				
				if(!checkSex(sex)){
					isRight = false;
					
					out.print("性别输入错误!<br>");
				}
				if(!checkEmail(email)){
					isRight = false;
					out.print("请输入正确的邮箱!<br>");
					
				}
				
				if(!CheckPhone.isPhone(phone)){
					isRight = false;
					out.print("请输入正确的电话号码!<br>");
				}
				
				
				if(isRight){
					person = new AdbooksData(name,sex,phone,email,address);
					personList.add(person);
					session.setAttribute("personLists",personList);
					AdbooksDataOpr.saveAdbooks(personList, DataFilePath.getFilePath());
					response.sendRedirect("index.jsp");
				}else{
					out.print("</body></html>");
				}
				
			}
		}
		
	}
	
	
		public  static boolean checkSex(String sex){
			
			if(sex.equals("男")||sex.equals("女")){
				return true;
			}
			
			return false;
		}
	
	public static boolean checkEmail(String email){
		
		  boolean is_true=false;
		  int first=email.indexOf("@");
		  int first1=email.indexOf(".");
		  int last=email.lastIndexOf(".");
		  String[] strs= email.split("\\.");
		  
		  if(!(first==-1||first1==-1||last==-1)){
			  if(strs[strs.length-1].equals("com")){
				  if(first<1||first1<1||first>first1||(last==email.length()-1)){
					  is_true=false;
				  }else if(first1-first>1){
					  is_true= true;
				  }else{
					  is_true= false;
				  }
			 }
		  }
		  
		  return is_true;
	} 


	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
