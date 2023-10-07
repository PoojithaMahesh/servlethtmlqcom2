package studenthtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studenthtml.dao.StudentDao;
import studenthtml.dto.Student;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		StudentDao dao=new StudentDao();
//		List<Student> list=dao.getAllStudents();
//		boolean value=false;
//		String studentPassword=null;
		
//		for(Student student:list) {
//			if(student.getEmail().equals(email)) {
//				value=true;
//				studentPassword=student.getPassword();
//				break;
//			}
//		}
//		PrintWriter printWriter=resp.getWriter();
//		if(value) {
////			when email is present
////			now im going to check with the password
//			if(studentPassword.equals(password)) {
////				logins successfully
//				printWriter.print("loginSuccess");
//			}else {
////				login failure
//				printWriter.print("invalid Password");
//			}
//		}else {
//			
//			printWriter.print("Email is not present");
//		}
//		
		List<Student> list=dao.getAllStudents(); 
		boolean value=false;
		boolean flag=false;
		for(Student student:list)
		{ if(student.getEmail().equals(email)) {
			value=true;
			if(student.getPassword().equals(password)) {
				flag=true;
				break; }
			break; }
		} PrintWriter printWriter=resp.getWriter(); 
		if(value)
		{
			if(flag) { printWriter.print("Login successfull"); }
		else { printWriter.print("Invalid ppassword"); } }
		
		else { printWriter.print("Email is not present"); 
		} 

		
	}
}
