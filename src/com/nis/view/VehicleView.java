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
 * Servlet implementation class VehicleView
 */
@WebServlet("/VehicleView")
public class VehicleView extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleView() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Agency A=null;
		HttpSession ses=request.getSession();
		try{
			
			A=(Agency)ses.getValue("SAGENCY");
            String navigationBar="<h3><font color=green>Agency Id:"+A.getAgencyid()+"&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAgencyname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><a href=AgencyLogout>Logout</a></h3><hr Color=red>";	
           // out.println(navigationBar);
            
		}catch(Exception e)
		{response.sendRedirect("AgencyLogin");}
		
		
		
		
		out.println("<html>");
		
		out.println("<form action='VehicleSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table>");
		
		out.println("<caption><b><i>Vehicle Registration</i></b></caption>");
		out.println("<tr><td><b><i>Vehicle ID:</i></b></td>");
		out.println("<td><input type=text name=vid size=30></td></tr>");

		out.println("<tr><td><b><i>Agency ID:</i></b></td>");
		out.println("<td><input type=text value='"+A.getAgencyid()+"' name=aid size=30></td></tr>");

		out.println("<tr><td><b><i>Vehicle Name:</i></b></td>");
		out.println("<td><input type=text  name=vname id=vname></td></tr>");
		
		out.println("<tr><td><b><i>Model Year:</i></b></td>");
		out.println("<td><input type=date name=myear id=myear></td></tr>");

		out.println("<tr><td><b><i>Vehicle Color:</i></b></td>");
		out.println("<td><select name=vcolor>"
				+ "<option>SELECT COLOR</option>"
				+ "<option>Red</option>"
				+ "<option>White</option>"
				+ "<option>Black</option>"
				+ "<option>Blue</option>"
				+ "<option>Orange</option>"
				+ "<option>Greay</option>"
				+ "<option>Violet</option>"
				+ "<option>Green</option>"
				+ "</select></td></tr>");

		out.println("<tr><td><b><i>Vehicel Type:</i></b></td>");
		out.println("<td><select name=vtype>"
				+ "<option>SELECT TYPE</option>"
				+ "<option>Auto</option>"	
				+ "<option>Mini</option>"
				+ "<option>Micro</option>"
				+ "<option>SUV</option>"
				+ "</select></td></tr>");

		out.println("<tr><td><b><i>Capacity:</i></b></td>");
		out.println("<td><select name=capa>"
				+ "<option>SELECT</option>"
				+ "<option value=2>2 Seater</option>"
				+ "<option value=4>4 Seater</option>"
				+ "<option value=6>6 Seater</option>"
				+ "</select></td></tr>");

		out.println("<tr><td><b><i>Insurance:</i></b></td>");
		out.println("<td>Yes:<input type=radio name=insurance value=Yes>No:<input type=radio name=insurance Value=No></td></tr>");


		out.println("<tr><td><b><i>Air Conditionar:</i></b></td>");
		out.println("<td>Yes:<input type=radio name=ac value=Yes> No:<input type=radio name=ac value=No></td></tr>");

		out.println("<tr><td><b><i>Fuel Type:</i></b></td>");
		out.println("<td><select name=ftype>"
				+ "<option>TYPE</option>"
				+ "<option>Petrol</option>"
				+ "<option>Dieseal</option>"
				+ "</select></td></tr>");
		
		out.println("<tr><td><b><i>Vehicle Picture:</i></b></td>");
		out.println("<td><input type=file name=vpic></td></tr>");

		out.println("</table><br>");
		out.println("<input type=submit>&nbsp;&nbsp;<input type=reset></br>");
		out.println("</form></html>");
		out.flush();
	}

}
