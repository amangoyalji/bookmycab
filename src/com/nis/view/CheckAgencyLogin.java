package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.AgencyController;
import com.nis.model.Agency;

/**
 * Servlet implementation class CheckAgencyLogin
 */
@WebServlet("/CheckAgencyLogin")
public class CheckAgencyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAgencyLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Agency A=AgencyController.CheckLogin(Integer.parseInt(request.getParameter("aid")), request.getParameter("pwd"));
		if(A!=null)
		{
			HttpSession ses=request.getSession();
			ses.putValue("SAGENCY", A);
			ses.putValue("LTIME", new java.util.Date());
			response.sendRedirect("AgencyHome");
		}
		else
		{out.println("<b><i><font color=red>Invalid UID/PWD</font><br><a href='AgencyLogin'>Sign in Again</a></i></b>");}
	}

}
