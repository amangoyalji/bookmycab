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
 * Servlet implementation class PhotoUpload
 */
@WebServlet("/PhotoUpload")
public class PhotoUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoUpload() {
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
         Agency A=null;
 		try{

 			        A=(Agency)ses.getValue("SAGENCY");
 			        out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
			        out.println("<script src='asset/autovehicle.js'></script>");
		    		out.println("<html>");
                    String navigationBar="<h3><font color=green>Admin Id:"+A.getAgencyid()+"&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAgencyname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><a href=AgencyLogout>Logout</a></h3><br><hr Color=red>";
                    //  out.println(navigationBar);

 		}catch(Exception e)
 		{response.sendRedirect("AgencyLogin");}
       out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
 		out.println("<script src='asset/autovehicle.js'></script>");
 		out.println("<html>");
 		out.println("<form action='UploadPhotoSubmit' method='post' enctype='multipart/form-data'>");
 		out.println("<table cellspacing='28'>");
 		out.println("<caption><b><i>Upload Photos</i></b>");
        out.println("<tr>");
 		out.println("<td><b><i>Agency Id</i></b></td>");
 		  A=(Agency)ses.getValue("SAGENCY");
 		out.println("<td><input type='text' id='aid' name='aid' value="+A.getAgencyid()+" readonly='true' ></td>");
 		out.println("</tr>");
 		out.println("<tr>");
 		out.println("<td><b><i>Vehicle Id</i></b></td>");
 		out.println("<td><select name='vid' id='vid' ></select></td>");
 		out.println("</tr>");
 		out.println("<tr>");
 		out.println("<td><b><i>Picture Type</i></b></td>");
 		out.println("<td>Interior<input type='radio' value='interior' name='pt' >Exterior<input type='radio' value='exterior' name='pt' ></td>");
 		out.println("</tr>");
 		out.println("<tr>");
 		out.println("<td><b><i>Upload Photo</i></b></td>");
 		out.println("<td><input type='file' name='pic' ></td>");
 		out.println("</tr>");
 		out.println("<tr>");
 		out.println("<td><input type='Submit' value='Add Picture'></td>");
 		out.println("</tr>");
 		out.println("</table>");
 		out.println("</form>");
	}

}
