package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.BookingController;
import com.nis.controller.ClientControllerSak;
import com.nis.model.ClientModel;

/**
 * Servlet implementation class DisplayAgencyBidForClient
 */
@WebServlet("/DisplayAgencyBidForClient")
public class DisplayAgencyBidForClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAgencyBidForClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses=request.getSession();
		PrintWriter out=response.getWriter();
	   out.println("<html>");
		//create navigation bar
		ClientModel C=null;
		try{
		C=(ClientModel)ses.getValue("SCLIENT");	
		String ltime=(String)ses.getValue("LTIME");
		String navbar="<h4>"+C.getEmailid()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+C.getName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=ClientLogout>Logout</a></h4><hr color=Green>";
	   // out.println(navbar);
		}catch(Exception e){
		//	out.println(e);
		response.sendRedirect("ClientLogin");	
		}
		try{
			ResultSet rs=ClientControllerSak.showAllBid(C.getEmailid());
			out.println("<html>");
			
			if(rs.next())
			{out.println("<table border=1>");
			out.println("<caption> List of Agency Bids</caption>");
			out.println("<tr><th>Sn</th><th>Booking Id</th><th>Source/<br>Destination</th><th>From/<br>To</th><th>Vehicle</th><th>Current<Br>Date/Time</th><th>BidAmount</th><th>Confirm</th></tr>");
			int sn=1;
			do
			{
				
		    out.println("<tr><td>"+sn+"</td><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"<br>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"<br>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>From "+rs.getString(7)+"<br> to "+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td><a href=ChangeBookingStatus?bookingid="+rs.getString(1)+">Confirm</a></td></tr>");		
			sn++;
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
