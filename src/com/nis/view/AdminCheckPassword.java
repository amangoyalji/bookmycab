package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.AdminController;
import com.nis.model.AdminModel;

/**
 * Servlet implementation class AdminCheckPassword
 */
@WebServlet("/AdminCheckPassword")
public class AdminCheckPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheckPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       AdminModel A=AdminController.checkPassword(request.getParameter("aid"), request.getParameter("pwd"));
       PrintWriter out=response.getWriter();
		 
       if(A!=null)
       { HttpSession ses=request.getSession();
         ses.putValue("SADMIN", A);
         ses.putValue("SLTIME", new java.util.Date().toString());
    	   
    	   response.sendRedirect("AdminHome");
        }
       else
       {out.println("<html>Invalid AdminId/Password</html>");
    	   
       }
	
	}

}



