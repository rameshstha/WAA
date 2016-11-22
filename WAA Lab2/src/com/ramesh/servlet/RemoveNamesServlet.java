package com.ramesh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int key=0;
		String keyToRemove=request.getParameter("keyToRemove");
		if(keyToRemove!=null){
		   key = Integer.parseInt(keyToRemove);
		}
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		if(request.getParameter("keyToRemove").equals(null)) {
			out.println("Please enter key to remove..<br>");
			namesUI(response);
		} else {
			if (session.getAttribute("mySession") == null) {
				out.println("No Record to Delete..");

				// names.html
				namesUI(response);
			} else {
				List<Person> ls = (List<Person>) session.getAttribute("mySession");

				Iterator<Person> it = ls.iterator();
				while (it.hasNext()) {
					Person p = it.next();
					if (p.getKey() == key) {
						it.remove();
						out.println("Remove Sucessfully....<br>");
					}
					else{
						out.println("Key doesnot exist...<br>");
					}
				}

				// names.html
				namesUI(response);
			}
		}
	}

	public void namesUI(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
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
