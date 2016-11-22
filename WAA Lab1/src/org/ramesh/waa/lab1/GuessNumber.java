package org.ramesh.waa.lab1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by:Ramesh Shrestha
 */
@WebServlet("/servlet/GuessNumber")
public class GuessNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuessNumber() {
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
		out.println("<html>");
		out.println("<body>");
		if (!(request.getParameter("guessNumber") == null)) {
			int guessNumber = Integer.parseInt(request.getParameter("guessNumber"));
			Random random = new Random();
			int randomNumber = random.nextInt(10) + 1;
			System.out.println(randomNumber);
			if (guessNumber == randomNumber)
				out.println("Correct, congratulations!");
			else if (guessNumber < randomNumber)
				out.println("Too low, try again");
			else
				out.println("Too high, try again");
		}
	
		out.println("<form method='GET' action='GuessNumber'>");
		out.println("<input type='text' name='guessNumber'>");
		out.println("<input type='submit' value='Check Guess'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	
		out.close();
	}
}
