package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmBooking
 */
@WebServlet("/ConfirmBooking")
public class ConfirmBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	    HttpSession ses=request.getSession();
		out.println("<html>");
		out.println("<form action=SubmitBooking>");
	    out.println("<table border=1 cellspacing=10>");
	    out.println("<tr>");
 	    out.println("<td><img src=picture/"+ses.getValue("SPICTURE")+" width=100 height=100></td>");
	    out.println("<td>");
	    out.println("<b><i>Vehicle Id:</i></b>"+ses.getValue("SVID")+"<br>");
	    out.println("<b><i>Vehicle:</i></b>"+ses.getValue("SVN")+"("+ses.getValue("SFTYPE")+")<br>");
	    out.println("<b><i>Model:</i></b>"+ses.getValue("SMODEL")+"<br>");
	    out.println("<b><i>Color:</i></b>"+ses.getValue("SCOLOR")+"<br>");
	    out.println("</td>");
	    
	    out.println("<td>");
	    out.println("<b><i>Type:</i></b>"+ses.getValue("STYPE")+"<br>");
	    out.println("<b><i>Capacity:</i></b>"+ses.getValue("SCAPACITY")+"<br>");
	    out.println("<b><i>Inssurance</i></b>"+ses.getValue("SINS")+"<br>");
	    out.println("<b><i>AC:</i></b>"+ses.getValue("SVAC")+"<br>");
	    out.println("</td>");
	    out.println("<td>");
	    
	    out.println("<b><i>From:</i></b>"+ses.getValue("SFROM")+"<br>");
	    out.println("<b><i>To:</i></b>"+ses.getValue("STO")+"<br>");
 
	    out.println("<b><i>Source:</i></b>"+ses.getValue("SCITY")+"<br>");
	    out.println("<b><i>Destination:</i></b>"+ses.getValue("SDCITY")+"<br>");
	   
	    out.println("</td></table><br><br>");
	    out.println("<input type=submit value='Confirm Booking'></form></html>");
	}

}
