package com.ramesh.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
			
		//redirect to name.jsp
		RequestDispatcher rd=request.getRequestDispatcher("/name.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtain the session object, create a new session if doesn't exist
				HttpSession session = request.getSession(true);
				int key = Integer.parseInt(request.getParameter("key"));
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				List<Person> person=(List<Person>)session.getAttribute("personList");
				
				if(null == person) {
					person = new ArrayList<Person>();
				}
				
			    Person per = new Person();
				per.setFirstName(firstName);
				per.setLastName(lastName);
				per.setKey(key);
				person.add(per);
				//person.add(new Person(key,firstName,lastName));
				session.setAttribute("personList", person);
				
				//redirect to name.jsp
				RequestDispatcher rd=request.getRequestDispatcher("/name.jsp");
				rd.forward(request, response);
	}

}
