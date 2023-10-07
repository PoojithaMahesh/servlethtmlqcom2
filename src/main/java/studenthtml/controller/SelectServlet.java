package studenthtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studenthtml.dao.StudentDao;
import studenthtml.dto.Student;

public class SelectServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	StudentDao dao=new  StudentDao();
	Student  student=dao.selectStudentById(id);
	PrintWriter printWriter=resp.getWriter();
	if(student!=null) {
//		id is present
		printWriter.print(student);
	}else {
//		id is not present
		printWriter.print("Sorry id is not present");
	}
	
}
	
}
