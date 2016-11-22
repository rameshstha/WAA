package org.ramesh.waa.lab1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogonServlet
 */
@WebServlet("/servlet/LogonServlet")
public class LogonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Created by:Ramesh Shrestha
     */
    public LogonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if (!(username == null && password == null)){
		if(username.equals("user") && password.equals("pass")){
			out.println("Welcome User");
			out.println("</body>");
            out.println("</html>");
            out.close();
        } else {
            out.println("Wrong userid or password! Please try again\n");
        }
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<form method='GET' action='LogonServlet'>");
        out.println("Username=<input type='text' name='username'> <br>");
        out.println("Password=<input type='text' name='password'>");
        out.println("<input type='submit' value='Logon'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();		
	}
}
