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
 * Servlet implementation class VehicleDisplayById
 */
@WebServlet("/VehicleDisplayById")
public class VehicleDisplayById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleDisplayById() {
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
		try{
			
			Agency A=(Agency)ses.getValue("SAGENCY");
            String navigationBar="<h3><font color=green>Admin Id:"+A.getAgencyid()+"&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAgencyname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><a href=AgencyLogout>Logout</a></h3><br><hr Color=red>";	
          //  out.println(navigationBar);
			
		}catch(Exception e)
		{response.sendRedirect("AgencyLogin");}
	    out.println("<html>");
		out.println("<form action='VehicleEditDelete' >");
		out.println("<table>");
		out.println("<caption><b><i>Search Vehicle</i></b>");
		out.println("<tr>");
		out.println("<td><b><i>Vehicle  Id </i></b></td>");
		out.println("<td><input type='text' name='vid' ></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<input type='submit'>");
		out.flush();
	}

}
