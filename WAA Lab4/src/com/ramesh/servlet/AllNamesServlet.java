package com.ramesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/servlet/AllNamesServlet")
public class AllNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllNamesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		HttpSession session = request.getSession(true);
		List<Person> showPerson=(List<Person>)session.getAttribute("showNames");
		
		if (session.getAttribute("personList") != null) {
			//List<Person> listOfPerson = new ArrayList<Person>();
			List<Person> allnames = (List<Person>) session.getAttribute("personList");
			
				showPerson = new ArrayList<Person>();
	
			for (Person p : allnames) {
				showPerson.add(p);
			}
			session.setAttribute("showNames", showPerson);
			//redirect to name.jsp
			RequestDispatcher rd=request.getRequestDispatcher("/name.jsp");
			rd.forward(request, response);
		}else{
			session.setAttribute("No Record to display..", "noRecord");
			RequestDispatcher rd=request.getRequestDispatcher("/name.jsp");
			rd.forward(request, response);
		}	
	}
}
