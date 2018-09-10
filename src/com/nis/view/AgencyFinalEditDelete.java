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

import com.nis.controller.AgencyController;
import com.nis.model.Agency;

/**
 * Servlet implementation class AgencyFinalEditDelete
 */
@WebServlet("/AgencyFinalEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class AgencyFinalEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgencyFinalEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String btn=request.getParameter("btn");
		  if(btn.equals("Update"))
		  {
			  Agency A=new Agency();
		  A.setAgencyid(request.getParameter("aid"));
		  A.setAgencyname(request.getParameter("aname"));
	      A.setOwnername(request.getParameter("oname"));
	      A.setAddress(request.getParameter("add"));
	      A.setState(request.getParameter("state"));
	      A.setCity(request.getParameter("city"));
	      A.setContactperson(request.getParameter("cperson"));
	      A.setMobileno(request.getParameter("mobileno"));
	      A.setPhoneno(request.getParameter("phoneno"));
	      A.setEmailid(request.getParameter("emailid"));
	      
	      A.setStatus(request.getParameter("status"));      
	      boolean st=AgencyController.EditRecord(A);
		  }
		  else if(btn.equals("Delete"))
		  {
			boolean st=AgencyController.DeleteRecord(Integer.parseInt(request.getParameter("aid")));  
			  
		  }
		  else if(btn.equals("Update Registration"))
		  { String path="F:/Eclipse Mars/eclipse/BookMyCab/WebContent/picture";
	      Part part=request.getPart("regproof");
	      FileUpload F=new FileUpload(part,path);
	      Agency A=new Agency();
	      A.setAgencyid(request.getParameter("aid"));
	      A.setRegistrationid(request.getParameter("regid"));
	      A.setRegistrationid_proof(F.filename);
		  boolean st=AgencyController.EditRegistration(A);	  
			  
		  }
		  else if(btn.equals("Update IdProof"))
		  { String path="F:/Eclipse Mars/eclipse/BookMyCab/WebContent/picture";
	      Part part=request.getPart("idproof");
	      FileUpload F=new FileUpload(part,path);
	      Agency A=new Agency();
	      A.setAgencyid(request.getParameter("aid"));
	      A.setIdentity(request.getParameter("identity"));
	      A.setIdentity_proof(F.filename);
		  boolean st=AgencyController.EditIdProof(A);	  
			  
		  }
		  else if(btn.equals("Update Logo"))
		  { String path="F:/Eclipse Mars/eclipse/BookMyCab/WebContent/picture";
	      Part part=request.getPart("logo");
	      FileUpload F=new FileUpload(part,path);
	      Agency A=new Agency();
	      A.setAgencyid(request.getParameter("aid"));
	     
	      A.setLogo(F.filename);
		  boolean st=AgencyController.EditLogo(A);	  
			  
		  }
	      response.sendRedirect("AgencyDisplayAll");
	
	
	}

}
