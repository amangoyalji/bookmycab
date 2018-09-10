package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.controller.VehicleController;
import com.nis.model.AgencyVehicle;

/**
 * Servlet implementation class VehicleSubmit
 */
@WebServlet("/VehicleSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)//Max Size 50 MB
public class VehicleSubmit extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleSubmit() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html>");
		AgencyVehicle V=new AgencyVehicle();
		V.setVehicleid(request.getParameter("vid"));
	    V.setAgencyid(request.getParameter("aid"));
	    V.setVehiclename(request.getParameter("vname"));
	    V.setModelyear(request.getParameter("myear"));
	    V.setVehiclecolor(request.getParameter("vcolor"));
	    V.setVehicletype(request.getParameter("vtype"));
	    V.setCapacity(request.getParameter("capa"));
	    V.setInsurance(request.getParameter("insurance"));
	    V.setAirconditionar(request.getParameter("ac"));
	    V.setFueltype(request.getParameter("ftype"));
	    
	    String path="F:/Eclipse Mars/eclipse/BookMyCab/WebContent/picture";
	    Part part=request.getPart("vpic");
	    FileUpload F=new FileUpload(part,path);
	    V.setVehiclepicture(F.filename);

	    boolean st=VehicleController.AddNewRecord(V);
		if(st)
		{
			out.println("<h1 align=centre><b>"
					+ "<br><br><br><br><br><br><br><br><br><br><br>"
					+ "*******Registration Successfull*******</b><h1>");
		}
		else
		{
			out.println("<h1 align=centre><b>"
					+ "<br><br><br><br><br><br><br><br><br><br><br>"
					+ "*******Failed*******</b><h1>");
		}
		out.println("</html>");
		out.flush();

	}

}
