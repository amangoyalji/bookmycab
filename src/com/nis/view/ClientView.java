package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientView
 */
@WebServlet("/ClientView")
public class ClientView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	
	out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
	out.println("<script src='asset/clientview.js'></script>");
	out.println("<script src='asset/jquery-ui.js'></script>");
	out.println("<link href='asset/jquery-ui.css' rel='stylesheet'></link>");	
	out.println("<html>");
	out.println("<table cellspacing=5>");
	out.println("<tr><th>Booking From</th><th>Booking To</th><th>Total Person</th><th>Source</th><th>Destination</th></tr>");
    out.println("<tr><td><input type=date id=from name=fdate></td><td><input type=date id=to name=tdate></td><td><input type=number name=tp id=tp></td><td><select id=city name=city><option>-City-</option></select></td><td><select id=dcity name=dcity><option>-City-</option></select></td>");	
	out.println("</table><br>");
	out.println("<div id=result></div>");
	out.println("<div id=vpic></div>");
	out.print("</html>");
	}

}






