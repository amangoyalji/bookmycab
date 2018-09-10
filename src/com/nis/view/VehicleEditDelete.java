package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.VehicleController;
import com.nis.model.AgencyVehicle;

/**
 * Servlet implementation class VehicleEditDelete
 */
@WebServlet("/VehicleEditDelete")
public class VehicleEditDelete extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleEditDelete() 
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
		AgencyVehicle V = VehicleController.DisplayByID(request.getParameter("vid"));
		PrintWriter out=response.getWriter();
        out.println("<html>");
		
		out.println("<form action='VehicleFinalEditDelete' method='post' enctype='multipart/form-data'>");
		out.println("<input type=hidden value='"+V.getTransactionid()+"' name=tid>");
		
		out.println("<table cellspacing=10><tr>");
	    out.println("<td>");
		
		out.println("<table>");
		out.println("<caption><b><i>Update Vehicle Registration</i></b></caption>");
		
		out.println("<tr><td><b><i>Vehicle ID:</i></b></td>");
		out.println("<td><input type=text name=vid value='"+V.getVehicleid()+"' size=30></td></tr>");

		out.println("<tr><td><b><i>Agency ID:</i></b></td>");
		out.println("<td><input type=text name=aid value='"+V.getAgencyid()+"' size=30></td></tr>");

		out.println("<tr><td><b><i>Vehicle Name:</i></b></td>");
		out.println("<td><input type=text  name=vname id=vname value='"+V.getVehiclename()+"' ></td></tr>");
		
		out.println("<tr><td><b><i>Model Year:</i></b></td>");
		out.println("<td><input type=date name=myear id=myear value='"+V.getModelyear()+"' ></td></tr>");

		out.println("<tr><td><b><i>Vehicle Color:</i></b></td>");
		out.println("<td><select name=vcolor value='"+V.getVehiclecolor()+"' >"
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
		out.println("<td><select name=vtype value='"+V.getVehicletype()+"' >"
				+ "<option>SELECT TYPE</option>"
				+ "<option>Auto</option>"	
				+ "<option>Mini</option>"
				+ "<option>Micro</option>"
				+ "<option>SUV</option>"
				+ "</select></td></tr>");

		out.println("<tr><td><b><i>Capacity:</i></b></td>");
		out.println("<td><select name=capa value='"+V.getCapacity()+"' >"
				+ "<option>SELECT</option>"
				+ "<option>2 Seater</option>"
				+ "<option>4 Seater</option>"
				+ "<option>6 Seater</option>"
				+ "</select></td></tr>");

		out.println("<tr><td><b><i>Insurance:</i></b></td>");
		out.println("<td>Yes:<input type=radio name=insurance Value='"+V.getInsurance()+"' >No:<input type=radio name=insurance value='"+V.getInsurance()+"' ></td></tr>");


		out.println("<tr><td><b><i>Air Conditionar:</i></b></td>");
		out.println("<td>Yes:<input type=radio name=ac value='"+V.getAirconditionar()+"' > No:<input type=radio name=ac value='"+V.getAirconditionar()+"' ></td></tr>");

		out.println("<tr><td><b><i>Fuel Type:</i></b></td>");
		out.println("<td><select name=ftype value='"+V.getFueltype()+"' >"
				+ "<option>TYPE</option>"
				+ "<option>Petrol</option>"
				+ "<option>Dieseal</option>"
				+ "</select></td></tr>");
		
		out.println("</table><br>");
		out.println("<input type=submit name=btn value=Update>&nbsp;&nbsp;<input name=btn type=submit value=Delete ></br>");
		
		out.println("</td><td>");
		out.println("Update Picture<br><br><br>");
		out.println("<img src='vehiclepicture/"+V.getVehiclepicture()+"' width=200 height=200><br><br>");
		out.println("<input type=file name=vpic><br><br>");
		out.println("<input type=submit name=btn value=Upload>");
		out.println("</td></table>");
			
		out.println("</form></html>");
		out.flush();
	}

}
