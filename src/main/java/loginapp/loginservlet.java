package loginapp;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verifylogin")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public loginservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String aaaa =request.getParameter("xxxx");
	String bbbb =request.getParameter("yyyy");
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logindb","root","prateek");
	Statement stmnt=con.createStatement();
	ResultSet rest =stmnt.executeQuery("select * from login where email='"+aaaa+"'and password='"+bbbb+"'");
	if(rest.next()) {
		System.out.println("Welcome to login page");
	}else {
		System.out.println("invalid email/password");
	}
	
	}catch(Exception a) {
		a.printStackTrace();
	}

}

}








