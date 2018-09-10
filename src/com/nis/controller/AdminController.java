package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.AdminModel;
import com.nis.model.Agency;

public class AdminController {
	public static AdminModel checkPassword(String aid,String pwd)
	{
	try{
		Connection cn=DBHelper.openConnection();
		String query="select * from admin where adminid='"+aid+"' and password='"+pwd+"'";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		if(rs.next())
		{AdminModel A=new AdminModel();
		A.setAdminId(rs.getString(1));
		A.setAdminName(rs.getString(2));
		A.setPicture(rs.getString(3));
		A.setPassword(rs.getString(4));
		return(A);
		}
		return null;
			
		
	
	}catch(Exception e)
	{
	return(null);	
	}
	}
	
}
