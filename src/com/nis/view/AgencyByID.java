package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgencyByID
 */
@WebServlet("/AgencyByID")
public class AgencyByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgencyByID() {
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
	out.println("<form action='AgencyEditDelete'>");
		out.println("<table>");
		out.println("<caption><b><i>Search Agency</i></b></caption>");
		out.println("<tr><td><b><i>Agency Id:</i></b></td>");
		out.println("<td><input type=text name=aid size=30></td><td><input type=submit></tr>");
		out.println("</table></html>");
		out.flush();
		 
		
	}

}
