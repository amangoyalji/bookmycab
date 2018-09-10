package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.AgencyBidController;
import com.nis.model.AgencyBidModel;

/**
 * Servlet implementation class ApplyBidSubmit
 */
@WebServlet("/ApplyBidSubmit")
public class ApplyBidSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyBidSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
	   AgencyBidModel B=new AgencyBidModel();  
	    B.setAgencyid(Integer.parseInt(request.getParameter("aid")));
	    B.setBookingid(Integer.parseInt(request.getParameter("bid")));
	    B.setCurrentdate(request.getParameter("cd"));
	    B.setCurrenttime(request.getParameter("ct"));
	    B.setBidamount(Integer.parseInt(request.getParameter("ba")));
       boolean st=AgencyBidController.AddNewRecord(B);	    	    
	    if(st)
	    {
	    out.println("Bid Submitted....");	
	    }
	    else
	    {
	    	out.println("Fail to Submit Bid....");	
	    }
	    out.flush();
	
	}

}
