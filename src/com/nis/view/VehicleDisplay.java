package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.VehicleController;
import com.nis.model.Agency;

/**
 * Servlet implementation class VehicleDisplay
 */
@WebServlet("/VehicleDisplay")
public class VehicleDisplay extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleDisplay() 
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
		
		try
		{
			out.println("<html>");
			ResultSet rs=VehicleController.DisplayAll(Integer.parseInt(A.getAgencyid()));  
			if(rs.next())
			{   
				out.println("<table border=1>");
				out.println("<caption><i>List Of Vehicles</i></caption>");
				out.println("<tr><th>Sno</th><th>Vehicle ID</th><th>Agency</th><th>Brand</th><th>Specification</th><th>Security</th><th>Picture</th><th>Update</th></tr>");
				int sn=1;
				do
				{
					 out.println("<tr><td>"+sn+"</td>"
					 		+ "<td>"+rs.getString(2)+"</td>"
					 	    + "<td>"+rs.getString(3)+"</td>"
					 	    + "<td>Brand:"+rs.getString(4)+"<br>Year:"+rs.getString(5)+"</td>"
					 	    + "<td>Color:"+rs.getString(6)+"<br>Type:"+rs.getString(7)+"<br>Capacity:"+rs.getString(8)+"</td>"
					 	    + "<td>Insurance:"+rs.getString(9)+"<br>AC:"+rs.getString(10)+"<br>fuel:"+rs.getString(11)+"</td>"
					 	    + "<td>Picture<br><img src='vehiclepicture/"+rs.getString(12)+"'"+" width=100 height=80></td>"
					 	    + "<td><a href='VehicleEditDelete?vid="+rs.getString(2)+"'><i><b>Edit/Delete</b></i></a></td></tr>");
					 sn++;
				}
				while(rs.next());
				out.print("</table>");
			}
			else
			{
				out.println("Record Not Found");  
			}
			out.print("</html>");
			out.flush();
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}
