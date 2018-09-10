package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BookingController;

/**
 * Servlet implementation class ChangeBookingStatus
 */
@WebServlet("/ChangeBookingStatus")
public class ChangeBookingStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeBookingStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  boolean st=BookingController.changeBookingStatus(Integer.parseInt(request.getParameter("bookingid")));
	  PrintWriter out=response.getWriter();
	 
	  out.println("<html>");
	  if(st)
	  
	  out.println("<h3>Booking Confirmed...</h3>");
	  else
		  out.println("<h3>Booking Failed...</h3>"); 
	   out.println("</html>");
		
		
	}

}
