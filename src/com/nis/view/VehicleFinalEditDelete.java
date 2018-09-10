package com.nis.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.controller.AgencyController;
import com.nis.controller.VehicleController;
import com.nis.model.Agency;
import com.nis.model.AgencyVehicle;

/**
 * Servlet implementation class VehicleFinalEditDelete
 */
@WebServlet("/VehicleFinalEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class VehicleFinalEditDelete extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleFinalEditDelete() 
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
		String btn=request.getParameter("btn");
		if(btn.equals("Update"))
		{
			AgencyVehicle V=new AgencyVehicle();
			V.setTransactionid(request.getParameter("tid"));
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
		
			boolean st=VehicleController.EditRecord(V);
		}
		else if(btn.equals("Delete"))
		{
			boolean st=VehicleController.DeleteRecord(request.getParameter("vid"));  

		}
		else if(btn.equals("Upload"))
		{ 
			String path="F:/Eclipse Mars/eclipse/BookMyCab/WebContent/picture";
			Part part=request.getPart("vpic");
			FileUpload F=new FileUpload(part,path);
			AgencyVehicle V=new AgencyVehicle();
			V.setVehicleid(request.getParameter("vid"));
			V.setVehiclepicture(F.filename);
			boolean st=VehicleController.Uploadpicture(V);	  

		}
		response.sendRedirect("VehicleDisplay");
	}

}
