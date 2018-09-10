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
 * Servlet implementation class AgencyView
 */
@WebServlet("/AgencyView")
public class AgencyView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgencyView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	HttpSession ses=request.getSession();
	
	//////////////session management////////////////
	AdminModel A;
	try{
	A=(AdminModel)ses.getValue("SADMIN");	
	String ltime=(String)ses.getValue("SLTIME");
	String navbar="<h4>Admin Id:"+A.getAdminId()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAdminName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=picture/"+A.getPicture()+" width=40 height=40>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></h4><hr color=Green>";
	}catch(Exception e){
	//	out.println(e);
	response.sendRedirect("AdminLogin");	
	}
	///////////////////////////////////
	
	
	out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
	out.println("<script src='asset/statecity.js'></script>");
		
	
	out.println("<html>");
out.println("<form action='AgencySubmit' method='post' enctype='multipart/form-data'>");
	out.println("<table>");
	out.println("<caption><b><i>Agency Registration</i></b></caption>");
	out.println("<tr><td><b><i>Agency Name:</i></b></td>");
	out.println("<td><input type=text name=aname size=30></td></tr>");
	
	out.println("<tr><td><b><i>Owner Name:</i></b></td>");
	out.println("<td><input type=text name=oname size=30></td></tr>");
	
	out.println("<tr><td><b><i>Address:</i></b></td>");
	out.println("<td><textarea name=add rows=3 cols=20></textarea></td></tr>");
	 
	out.println("<tr><td><b><i>State:</i></b></td>");
	out.println("<td><select  name=state id=state></select></td></tr>");
	
	out.println("<tr><td><b><i>City:</i></b></td>");
	out.println("<td><select name=city id=city></select></td></tr>");
	
	out.println("<tr><td><b><i>Contact Person:</i></b></td>");
	out.println("<td><input type=text name=cperson size=30></td></tr>");
	
	out.println("<tr><td><b><i>Mobile No:</i></b></td>");
	out.println("<td><input type=text name=mobileno size=30></td></tr>");
	
	out.println("<tr><td><b><i>Phone No:</i></b></td>");
	out.println("<td><input type=text name=phoneno size=30></td></tr>");
	
	out.println("<tr><td><b><i>Email Id:</i></b></td>");
	out.println("<td><input type=text name=emailid size=30></td></tr>");
	
	
	out.println("<tr><td><b><i>Registration Id:</i></b></td>");
	out.println("<td><input type=text name=regid size=30></td></tr>");
	
	out.println("<tr><td><b><i>Uplaod Registration Proof:</i></b></td>");
	out.println("<td><input type=file name=regproof></td></tr>");
	
	

	out.println("<tr><td><b><i>Identity:</i></b></td>");
	out.println("<td><input type=text name=identity size=30></td></tr>");
	
	out.println("<tr><td><b><i>Uplaod identity Proof:</i></b></td>");
	out.println("<td><input type=file name=idproof></td></tr>");
	
	out.println("<tr><td><b><i>Logo:</i></b></td>");
	out.println("<td><input type=file name=logo></td></tr>");
	
	out.println("<tr><td><b><i>Password:</i></b></td>");
	out.println("<td><input type=password name=pwd size=30></td></tr>");
	
	out.println("<tr><td><b><i>Confirm Password:</i></b></td>");
	out.println("<td><input type=password name=cpwd size=30></td></tr>");
	
	out.println("<tr><td><b><i>Status:</i></b></td>");
	out.println("<td><input type=text readonly=true name=status size=30 value='Not Verify'></td></tr>");
	
	out.println("</table><br>");
	out.println("<input type=submit>&nbsp;&nbsp;<input type=reset></br>");
	out.println("</form></html>");
	out.flush();
	}

}
