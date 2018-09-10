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

import com.nis.controller.VehiclePictureController;
import com.nis.model.VehiclePicture;

/**
 * Servlet implementation class UploadPhotoSubmit
 */
@WebServlet("/UploadPhotoSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class UploadPhotoSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPhotoSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		VehiclePicture VP=new VehiclePicture();
		VP.setAgencyId(request.getParameter("aid"));
		VP.setVehicleId(request.getParameter("vid"));
		
		VP.setPictureType(request.getParameter("pt"));
		Part P=request.getPart("pic");
		  String path="F:/Eclipse Mars/eclipse/BookMyCab/WebContent/picture";
		FileUpload F=new FileUpload(P,path);
		VP.setPhoto(F.filename);
		boolean st=VehiclePictureController.UpdatePicture(VP);
		if(st)
		{out.println("<b>Record Submitted....</b>");}
		else
		{out.println("<b>Failed to Submit record.....</b>");}
		out.println("</html>");
		
	}

}
