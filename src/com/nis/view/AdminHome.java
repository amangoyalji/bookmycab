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

/**
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
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
		AdminModel A;
		try{
		A=(AdminModel)ses.getValue("SADMIN");	
		String ltime=(String)ses.getValue("SLTIME");
		String navbar="<h4>Admin Id:"+A.getAdminId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAdminName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=picture/"+A.getPicture()+" width=40 height=40>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></h4><hr color=Green>";
	    out.println(navbar);
		}catch(Exception e){
		//	out.println(e);
		response.sendRedirect("AdminLogin");	
		}
		out.println("<table>");
		out.println("<tr>");
		out.println("<td valign=top>");
		out.println("<a href=AgencyView target=mw>Add Agency</a><br>");
		out.println("<a href=AgencyDisplayAll target=mw>Display Agencies</a><br>");
		out.println("<a href=AgencyByID  target=mw>Edit/Delete</a><br>");
		out.println("<a href=DisplayBookingByClient  target=mw>Current Bookings</a><br>");
		out.println("<a href=AdminLogout target='_blank'>Logout</a><br>");
		out.println("</td>");
		out.println("<td valign=top>");
		out.println("<iframe name=mw width=600 height=700 frameborder=0></iframe>");
		out.println("</td></tr></table></html>");
		out.flush();
		
				
		 
		
		
		
		
		
		
	}

}
