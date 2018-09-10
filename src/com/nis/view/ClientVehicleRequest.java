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
 * Servlet implementation class ClientVehicleRequest
 */
@WebServlet("/ClientVehicleRequest")
public class ClientVehicleRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientVehicleRequest() {
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
		////***///
	    ses.putValue("SVID", request.getParameter("vid"));
	    ses.putValue("SPICTURE", request.getParameter("vpicture"));
	    ses.putValue("SVN", request.getParameter("vn"));
	    ses.putValue("SMODEL", request.getParameter("vmodel"));
	    ses.putValue("SCOLOR", request.getParameter("vcolor"));
	    ses.putValue("STYPE", request.getParameter("vtype"));
	    ses.putValue("SCAPACITY", request.getParameter("vcapacity"));
	    ses.putValue("SINS", request.getParameter("vins"));
	    ses.putValue("SVAC", request.getParameter("vac"));
	    ses.putValue("SFROM", request.getParameter("from"));
	    ses.putValue("STO", request.getParameter("to"));
	    ses.putValue("SCITY", request.getParameter("city"));
	    ses.putValue("SDCITY", request.getParameter("dcity"));
	    ses.putValue("SFTYPE", request.getParameter("vftype"));
	    
	    
	    /////////
	    out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/statecity.js'></script>");
		out.println("<script src='asset/clientreg.js'></script>");	
		out.println("<html>");
	    out.println("<table border=1 cellspacing=10>");
	    out.println("<tr>");
 	    out.println("<td><img src=picture/"+request.getParameter("vpicture")+" width=100 height=100></td>");
	    out.println("<td>");
	    out.println("<b><i>Vehicle Id:</i></b>"+request.getParameter("vid")+"<br>");
	    out.println("<b><i>Vehicle:</i></b>"+request.getParameter("vn")+"("+request.getParameter("vftype")+")<br>");
	    out.println("<b><i>Model:</i></b>"+request.getParameter("vmodel")+"<br>");
	    out.println("<b><i>Color:</i></b>"+request.getParameter("vcolor")+"<br>");
	    out.println("</td>");
	    
	    out.println("<td>");
	    out.println("<b><i>Type:</i></b>"+request.getParameter("vtype")+"<br>");
	    out.println("<b><i>Capacity:</i></b>"+request.getParameter("vcapacity")+"<br>");
	    out.println("<b><i>Inssurance</i></b>"+request.getParameter("vins")+"<br>");
	    out.println("<b><i>AC:</i></b>"+request.getParameter("vac")+"<br>");
	    out.println("</td>");
	    out.println("<td>");
	    
	    out.println("<b><i>From:</i></b>"+request.getParameter("from")+"<br>");
	    out.println("<b><i>To:</i></b>"+request.getParameter("to")+"<br>");
 
	    out.println("<b><i>Source:</i></b>"+request.getParameter("city")+"<br>");
	    out.println("<b><i>Destination:</i></b>"+request.getParameter("dcity")+"<br>");
	   
	    out.println("</td></table><br><br>");
	    
         
		
		out.println("<table><tr><td valign=top><table>");
		out.println("<caption><b><i>Client Login</i></b></caption>");
		out.println("<tr><td><b><i>EmailId/Mobile No:</i></b></td><td><input type=text id=cid name=cid></td></tr>");
		out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password id=ccpwd name=pwd></td></tr>");
		out.println("<tr><td><input type=button id='login' value='Login'></td><td>&nbsp;</td></tr>");
		out.println("</table><br><span id=lmsg></span></td>");
		out.println("<td valign=top>");
 
 
			out.println("<table>");
			out.println("<caption><b><i>Sign Up</i></b></caption>");
			out.println("<tr><td><b><i>Email Id:</i></b></td>");
			out.println("<td><input type=email id=email size=30></td></tr>");
			
			
			out.println("<tr><td><b><i>Mobile:</i></b></td>");
			out.println("<td><input type=text id=mobile size=30></td></tr>");
			
			
			out.println("<tr><td><b><i>Name:</i></b></td>");
			out.println("<td><input type=text id=cname size=30></td></tr>");
			
			out.println("<tr><td><b><i>Birth Date:</i></b></td>");
			out.println("<td><input type=date id=cdob size=30></td></tr>");
			
			out.println("<tr><td><b><i>Gender:</i></b></td>");
			out.println("<td><select id=cgender><option>Male</option><option>Female</option></select></td></tr>");
			
			
			out.println("<tr><td><b><i>Address:</i></b></td>");
			out.println("<td><textarea id=cadd rows=3 cols=20></textarea></td></tr>");
			 
			out.println("<tr><td><b><i>State:</i></b></td>");
			out.println("<td><select    id=state></select></td></tr>");
			
			out.println("<tr><td><b><i>City:</i></b></td>");
			out.println("<td><select   id=city></select></td></tr>");
		
			
			 
			
			out.println("<tr><td><b><i>Password:</i></b></td>");
			out.println("<td><input type=password id=pwd size=30></td></tr>");
			
			out.println("<tr><td><b><i>Confirm Password:</i></b></td>");
			out.println("<td><input type=password id=cpwd size=30></td></tr>");
			out.println("</table><br><input type=button value='Sign Up' id='su'>&nbsp;&nbsp;&nbsp;<span id='res'></span></td></tr></table><br>");
           
		
	    
	    
	    out.print("</html>");
	    
	    
	}

}
