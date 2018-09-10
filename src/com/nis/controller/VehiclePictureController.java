package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.VehiclePicture;



public class VehiclePictureController {
	public static boolean UpdatePicture(VehiclePicture VP)
	{
	try
	{
	Connection cn=DBHelper.openConnection();
	String query="insert into VehiclePicture(agencyId,photo,pictureType,vehicleId) values("+VP.getAgencyId()+",'"+VP.getPhoto()+"','"+VP.getPictureType()+"','"+VP.getVehicleId()+"')"; 
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(query,cn);
	if(st)
	{return true;}
	else
	{return false;}

	}catch(Exception e)
	{System.out.println("VehiclePictureController :"+e);
	  return false;}

	}
	
	public static ResultSet getVehiclePictures(String vid)
	{
	try
	{
	Connection cn=DBHelper.openConnection();
	String query="select * from vehiclepicture where vehicleid='"+vid+"'";
	ResultSet rs=DBHelper.executeQuery(query, cn); 
	return(rs);

	}catch(Exception e)
	{System.out.println("VehiclePictureController :"+e);
	  return null;}

	}
	
	
	
	
	
}
