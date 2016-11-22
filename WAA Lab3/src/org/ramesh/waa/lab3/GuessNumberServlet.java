package org.ramesh.waa.lab3;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ramesh Shrestha
 */
@WebServlet("/GuessNumberServlet")
public class GuessNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuessNumberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd=request.getRequestDispatcher("guessNumber.jsp");
		rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!(request.getParameter("guessNumber") == null)) {
			System.out.println(request.getParameter("guessNumber"));
			int guessNumber = Integer.parseInt(request.getParameter("guessNumber"));
			Random random = new Random();
			int randomNumber = random.nextInt(10) + 1;
			System.out.println(randomNumber);
			if (guessNumber == randomNumber){
				request.setAttribute("information","Correct, congratulations!");
				RequestDispatcher rd=request.getRequestDispatcher("guessNumber.jsp");
				rd.forward(request, response);			}
			else if (guessNumber < randomNumber){
				request.setAttribute("information","Too low, try again");
				RequestDispatcher rd=request.getRequestDispatcher("guessNumber.jsp");
				rd.forward(request, response);
				
			}
			else{
				request.setAttribute("information","Too high, try again");
				RequestDispatcher rd=request.getRequestDispatcher("guessNumber.jsp");
				rd.forward(request, response);
		}
		}
		else if((request.getParameter("guessNumber")=="")){
			request.setAttribute("error","Enter a number in the textbox");
			RequestDispatcher rd=request.getRequestDispatcher("guessNumber.jsp");
			rd.forward(request, response);
		}
	}

}
