package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.Agency;

/**
 * Servlet implementation class ApplyBid
 */
@WebServlet("/ApplyBid")
public class ApplyBid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyBid() {
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
		out.println("<form action='ApplyBidSubmit'>");
		HttpSession ses=request.getSession();
		 
			
			Agency A=(Agency)ses.getValue("SAGENCY");
		out.println("<table>");
		out.println("<caption><b><i>Agency Bid Register</i></b></caption>");
		out.println("<tr><td><b><i>Agency Id:</i></b></td><td><input type=text name=aid value='"+A.getAgencyid()+"'></td></tr>");
		out.println("<tr><td><b><i>Booking Id:</i></b></td><td><input type=text name=bid value='"+request.getParameter("bid")+"'></td></tr>");
		Calendar C=Calendar.getInstance();
		String ampm[]={"AM","PM"};
		String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
		String ct=C.get(Calendar.HOUR)+":"+C.get(Calendar.MINUTE)+":"+C.get(Calendar.SECOND);
		//+" "+ampm[C.get(Calendar.AM_PM)];
		out.println("<tr><td><b><i>Current Date:</i></b></td><td><input type=text name=cd value='"+cd+"'></td></tr>");
	
		out.println("<tr><td><b><i>Current Time:</i></b></td><td><input type=text name=ct value='"+ct+"'></td></tr>");
		out.println("<tr><td><b><i>Booking Amount:</i></b></td><td><input type=text name=ba></td></tr>");		
		out.println("<tr><td><input type=submit ></td><td><input type=reset></td></tr>");
		out.println("</table></form></html>");
		out.flush();
	}

}
