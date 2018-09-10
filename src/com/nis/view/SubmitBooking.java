package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.controller.BookingController;
import com.nis.model.BookingModel;
import com.nis.model.ClientModel;

/**
 * Servlet implementation class SubmitBooking
 */
@WebServlet("/SubmitBooking")
public class SubmitBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitBooking() {
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
	ClientModel C=(ClientModel)ses.getValue("SCLIENT");
	BookingModel B=new BookingModel();
	B.setClientemail(C.getEmailid());
	B.setMobileno(C.getMobile());
	B.setVehicleid(ses.getValue("SVID").toString());
	B.setCurrentdate(new java.util.Date().toString());
	B.setBookingfrom(ses.getValue("SFROM").toString());
	B.setBookingto(ses.getValue("STO").toString());
	B.setSource(ses.getValue("SCITY").toString());
	B.setDestination(ses.getValue("SDCITY").toString());
	B.setStatus("UNBOOK");
	boolean st=BookingController.AddNewRecord(B);
	if(st)
	{
		out.println("Booking Confirmed..");
	}
	else
	{
		out.println("Fail to Submit Record..");		
		
	}
	
	
	}

}
