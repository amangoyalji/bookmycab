package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.nis.controller.AgencyController;
import com.nis.controller.ClientControllerSak;
import com.nis.model.Agency;
import com.nis.model.ClientModel;

/**
 * Servlet implementation class CheckClientLogin
 */
@WebServlet("/CheckClientLogin")
public class CheckClientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckClientLogin() {
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
            JSONObject obj=new JSONObject();
		    try {
				obj.put("res", "1");
			    out.println(obj);
		    } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{  JSONObject obj=new JSONObject();
	    try {
			obj.put("res", "0");
			out.println(obj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	}


