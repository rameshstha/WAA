package com.ramesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
@WebServlet("/servlet/RemoveNamesServlet")
public class RemoveNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveNamesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int key=0;
		String keyToRemove=request.getParameter("keyToRemove");
		if(keyToRemove!=null){
		   key = Integer.parseInt(keyToRemove);
		}
		HttpSession session = request.getSession(true);
				List<Person> ls = (List<Person>) session.getAttribute("personList");

				Iterator<Person> it = ls.iterator();
				while (it.hasNext()) {
					Person p = it.next();
					if (p.getKey() == key) {
						it.remove();
						session.setAttribute("remove", "Remove Successfully");
						// names.jsp
						RequestDispatcher rd=request.getRequestDispatcher("/name.jsp");
						rd.forward(request, response);
					}
					else{
						session.setAttribute("remove", "Key doesnot exists...");
						// names.jsp
						RequestDispatcher rd=request.getRequestDispatcher("/name.jsp");
						rd.forward(request, response);
					}
				}

			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}	
}
