package studenthtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import studenthtml.dao.StudentDao;
import studenthtml.dto.Student;

public class SignUpServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	String name=req.getParameter("name");
	String address=req.getParameter("address");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	long phone=Long.parseLong(req.getParameter("phone"));
	
	
	Student student=new Student();
	student.setAddress(address);
	student.setEmail(email);
	student.setName(name);
    student.setPassword(password);
    student.setPhone(phone);
	
	
	StudentDao dao=new StudentDao();
	List<Student> students=dao.getAllStudents();
	boolean value=false;
	
	for(Student st:students) {
		if(st.getEmail().equals(email)) {
			value=true;
			break;
		}
	}
	
	
	if(value) {
//		that email is already present now i should not take that email
//		and i should not save that data to the database
		PrintWriter printWriter=res.getWriter();
		printWriter.print("SORRY EMAIL ALREADY EXIST");
	}else {
//		EMail is not present in the database
//		i will save that data to the database
		dao.signupStudent(student);
		PrintWriter printWriter=res.getWriter();
		printWriter.print("signupsuccessfully");
	}
	
		
	}

}
