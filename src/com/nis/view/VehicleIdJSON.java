package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.nis.controller.DBHelper;
import com.nis.controller.VehicleController;
import com.nis.model.Agency;

/**
 * Servlet implementation class VehicleIdJSON
 */
@WebServlet("/VehicleIdJSON")
public class VehicleIdJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleIdJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 
		ResultSet rs=VehicleController.DisplayAll(Integer.parseInt(request.getParameter("aid")));
				
		ArrayList<JSONObject> obj=DBHelper.JsonEngine(rs);
		out.println(obj);
	}

}
