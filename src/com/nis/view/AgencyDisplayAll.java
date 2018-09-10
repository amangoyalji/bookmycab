package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.AgencyController;

/**
 * Servlet implementation class AgencyDisplayAll
 */
@WebServlet("/AgencyDisplayAll")
public class AgencyDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgencyDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	   try{
		   out.println("<html>");
		 ResultSet rs=AgencyController.DisplayAll();  
		   if(rs.next())
		   {   
		      out.println("<table border=1>");
		      out.println("<caption>List Of Agencies</caption>");
		      out.println("<tr><th>Sno</th><th>Agency</th><th>Address</th><th>Contact</th><th>Registration</th><th>Id Proof</th><th>Logo</th><th>Update</th></tr>");
		      int sn=1;
		      do
		      {
		     out.println("<tr><td>"+sn+"</td><td>"+rs.getString(1)+"<br>"+rs.getString(2)+"<br>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"<br>"+rs.getString(6)+","+rs.getString(5)+"</td><td>"+rs.getString(7)+"<br>Mobile:"+rs.getString(8)+"<br>Ph:"+rs.getString(9)+"<br>Email:"+rs.getString(10)+"</td><td>"+rs.getString(11)+"<br><img src=picture/"+rs.getString(12)+" width=50 height=50></td><td>"+rs.getString(13)+"<br><img src=picture/"+rs.getString(14)+" width=50 height=50></td><td><a href=picture/"+rs.getString(15)+"><img src=picture/"+rs.getString(15)+" width=50 height=50></a></td><td><a href=AgencyEditDelete?aid="+rs.getString(1)+">Edit/Delete</a></td></tr>"); 	  
		    	  
		      }while(rs.next());
			   out.print("</table>");
			   
		   }
		   else
		   {
			 out.println("Record Not Found");  
		   }
		   out.print("</html>");
			   out.flush();
		   
	   }catch(Exception e){out.println(e);}
	
	}}


