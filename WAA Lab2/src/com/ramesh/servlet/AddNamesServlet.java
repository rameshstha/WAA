package com.ramesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ramesh.names.Person;

/**
 * Created by Ramesh Shrestha
 */
@WebServlet("/servlet/AddNamesServlet")
public class AddNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNamesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// Obtain the session object, create a new session if doesn't exist
		HttpSession session = request.getSession(true);
		int key = Integer.parseInt(request.getParameter("key"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		List<Person> person=(List<Person>)session.getAttribute("mySession");
		
		if(null == person) {
			person = new ArrayList<Person>();
		}
		
	    Person per = new Person();
		per.setFirstName(firstName);
		per.setLastName(lastName);
		per.setKey(key);
		person.add(per);
		//person.add(new Person(key,firstName,lastName));
		session.setAttribute("mySession", person);
		
		//names.html
		response.setContentType("text/html");
		out.println("<form method='GET' action='AllNamesServlet'>");
		out.println("<input type='submit' value='Show All Names'>");
		out.println("</form>");
		out.println("<form method='GET' action='AddNamesServlet'>");
		out.println("Key=<input type='number' name='key'>&nbsp;First Name=<input type='text' name='firstName'>&nbsp;");
		out.println("Last Name=<input type='text' name='lastName'>&nbsp;");
		out.println("<input type='submit' value='Add'>");
		out.println("</form>");
		out.println("<form method='GET' action='RemoveNamesServlet'>");
		out.println("Key=<input type='number' name='keyToRemove' value='0'>&nbsp;");
		out.println("<input type='submit' value='Remove'>");
		out.print("</form>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
