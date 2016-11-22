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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);

		if (session.getAttribute("mySession") != null) {
			List<Person> allnames = (List<Person>) session.getAttribute("mySession");
			response.setContentType("text/html");
			out.println("<html><body>");
			out.println("List of  Names<br>");
			for (Person p : allnames) {
				out.println("Key=" + p.getKey() + " " + "First Name=" + p.getFirstName() + " " + "Last Name="
						+ p.getLastName());
				out.println("<br>");
			}
			namesUI(response);
		}else{
			out.println("No data to Display...");
			namesUI(response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	public void namesUI(HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<form method='GET' action='AllNamesServlet'>");
		out.println("<input type='submit' value='Show All Names'>");
		out.println("</form>");
		out.println("<form method='GET' action='AddNamesServlet'>");
		out.println(
				"Key=<input type='number' name='key'>&nbsp;First Name=<input type='text' name='firstName'>&nbsp;");
		out.println("Last Name=<input type='text' name='lastName'>&nbsp;");
		out.println("<input type='submit' value='Add'>");
		out.println("</form>");
		out.println("<form method='GET' action='RemoveNamesServlet'>");
		out.println("Key=<input type='number' name='keyToRemove' value='0'>&nbsp;");
		out.println("<input type='submit' value='Remove'>");
		out.print("</form>");
		out.close();
	}
}
