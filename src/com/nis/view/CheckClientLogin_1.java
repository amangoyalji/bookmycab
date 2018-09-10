package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.ClientControllerSak;
import com.nis.model.ClientModel;

/**
 * Servlet implementation class CheckClientLogin_1
 */
@WebServlet("/CheckClientLogin_1")
public class CheckClientLogin_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckClientLogin_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ClientModel C=ClientControllerSak.checkPassword(request.getParameter("cid"),request.getParameter("pwd"));
		
		if(C!=null)
		{
			HttpSession ses=request.getSession();
			ses.putValue("SCLIENT", C);
			ses.putValue("LTIME", new java.util.Date().toString());
	        response.sendRedirect("ClientHome_1");
		  
		}
		else
		{
		out.println("Invalid Emailid/Mobile No./Password");	
		}
      out.flush();
	}
 
}
