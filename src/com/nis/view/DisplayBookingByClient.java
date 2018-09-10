package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BookingController;

/**
 * Servlet implementation class DisplayBookingByClient
 */
@WebServlet("/DisplayBookingByClient")
public class DisplayBookingByClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBookingByClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	try{
		ResultSet rs=BookingController.DisplayBookingByClient();
		out.println("<html>");
		out.println("<table border=1>");
		out.println("<caption> List of Bookings</caption>");
		if(rs.next())
		{
		out.println("<tr><th>Sn</th><th>Booking Id</th><th>Client<br>Email</th><th>Client<br>Mobile no</th><th>Vehicle Id</th><th>Booking<Br>Date</th><th>Booking</th><th>Source/<br>Destination</th></tr>");
		int sn=1;
		do
		{
	    out.println("<tr><td>"+sn+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>From "+rs.getString(6)+"<br> to "+rs.getString(7)+"</td><td>"+rs.getString(8)+" <br> to "+rs.getString(9)+"</td></tr>");		
		}while(rs.next());
		out.print("</table></html>");
		}
		else
		{
		 out.println("No Bookings...");	
		}
		
		out.flush();
	}catch(Exception e)
	{
		out.println(e);
	}
	
	}

}
