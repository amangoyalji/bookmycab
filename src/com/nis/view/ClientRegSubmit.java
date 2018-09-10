package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.nis.controller.ClientControllerSak;
import com.nis.model.ClientModel;

/**
 * Servlet implementation class ClientRegSubmit
 */
@WebServlet("/ClientRegSubmit")
public class ClientRegSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientRegSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	 
ClientModel C=new ClientModel();	
C.setEmailid(request.getParameter("email"));
C.setMobile(request.getParameter("mobile"));	
C.setName(request.getParameter("cname"));	
C.setBirthdate(request.getParameter("cdob"));	
C.setGender(request.getParameter("cgender"));	
C.setAddress(request.getParameter("cadd"))	;
C.setState(request.getParameter("state"));	
C.setCity(request.getParameter("city"));	
C.setPassword(request.getParameter("pwd"));	
 
boolean st=ClientControllerSak.AddRecord(C);
JSONObject obj=new JSONObject();
try{
if(st)
 {obj.put("result", "Record Submitted...");}
 else
 {obj.put("result", "Fail to Submit Record...");}
 out.println(obj);
}catch(Exception e)
{try {
	obj.put("result", e.getMessage());
} catch (JSONException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
	out.println(e);
	}










	
	
	
	
	}

}
