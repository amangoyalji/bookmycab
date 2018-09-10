package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Agency;

/**
 * Servlet implementation class AgencyHome
 */
@WebServlet("/AgencyHome")
public class AgencyHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgencyHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		Agency A=null;
		HttpSession ses=request.getSession();
		try{
			
			A=(Agency)ses.getValue("SAGENCY");
            String navigationBar="<h3><font color=green>Agency Id:"+A.getAgencyid()+"&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAgencyname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><a href=AgencyLogout>Logout</a></h3><hr Color=red>";	
            out.println(navigationBar);
            
		}catch(Exception e)
		{response.sendRedirect("AgencyLogin");}
        
		out.println("<table>");
    	    out.println("<tr>");
    	    out.println("<td valign='top'>");
    	    out.println("<a href='VehicleView' target='mw' >Add Vehicles</a><br>");


    	    out.println("<a href='VehicleDisplay' target='mw' >Display Vehicles</a><br>");
    	    out.println("<a href='VehicleDisplayById' target='mw' >Edit/Delete</a><br>");
    	    out.println("<a href='PhotoUpload' target='mw' >Add Photographs</a><br>");
    	    out.println("<a href='DisplayBookingByClientForAgency' target='mw' >Current Booking</a><br>");

    	    out.println("<a href='AgencyLogout' >LogOut</a><br>");
    	    out.println("</td>");
    	    out.println("<td valign='top'>");
    	    out.println("<iframe name='mw' frameborder='0' height='700' width='800'></iframe>");
    	    out.println("</td></tr>");
    	    out.println("</table>");
    		out.println("</html>");
			
		
		
 
	}

}
