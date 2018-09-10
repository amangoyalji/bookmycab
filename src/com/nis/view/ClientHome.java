package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.AdminModel;
import com.nis.model.ClientModel;

/**
 * Servlet implementation class ClientHome
 */
@WebServlet("/ClientHome")
public class ClientHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientHome() {
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
		ClientModel C;
		try{
		C=(ClientModel)ses.getValue("SCLIENT");	
		String ltime=(String)ses.getValue("LTIME");
		String navbar="<h4>"+C.getEmailid()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+C.getName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=ClientLogout>Logout</a></h4><hr color=Green>";
	    out.println(navbar);
		}catch(Exception e){
		//	out.println(e);
		response.sendRedirect("ClientLogin");	
		}
		out.println("<table>");
		out.println("<tr>");
		out.println("<td valign=top>");
		out.println("<a href=ClientProfile target=mw>Edit Profile</a><br>");
		out.println("<a href=ClientChangePassword target=mw>Change Password</a><br>");
		out.println("<a href=CurrentBookings  target=mw>Current Bookings</a><br>");
		out.println("<a href=PreviousBooking>Previous Bookings</a><br>");
		out.println("</td>");
		out.println("<td valign=top>");
		out.println("<iframe name=mw width=600 height=700 frameborder=0 src='ConfirmBooking'></iframe>");
		out.println("</td></tr></table></html>");
		out.flush();
		
	}

}
