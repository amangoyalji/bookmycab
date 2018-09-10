/**
 * 
 */
package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.Agency;
import com.nis.model.AgencyVehicle;

/**
 * @author Himanshu Mehra
 *
 */
public class VehicleController 
{
	public static boolean AddNewRecord(AgencyVehicle V)
	{
		try
		{
			Connection cn = DBHelper.openConnection();
			String query="insert into agencyvehicle(vehicleid,agencyid,vehiclename,modelyear,vehiclecolor,vehicletype,capacity,insurance,airconditionar,fueltype,vehiclepicture) values('"+V.getVehicleid()+"','"+V.getAgencyid()+"','"+V.getVehiclename()+"','"+V.getModelyear()+"','"+V.getVehiclecolor()+"','"+V.getVehicletype()+"','"+V.getCapacity()+"','"+V.getInsurance()+"','"+V.getAirconditionar()+"','"+V.getFueltype()+"','"+V.getVehiclepicture()+"')";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(query, cn);
			return(st);
		}
		catch(Exception e)
		{
			System.out.println("AddNewRecord "+e);
			return false;
		}
	}
	public static ResultSet DisplayAll(int aid)
	{
		try
		{
			Connection cn=DBHelper.openConnection();
			String query="select v.transactionid,v.vehicleid,v.agencyid,v.vehiclename,v.modelyear,v.vehiclecolor,v.vehicletype,v.capacity,v.insurance,v.airconditionar,v.fueltype,v.vehiclepicture  from agencyvehicle v where v.agencyid="+aid;			
			ResultSet rs=DBHelper.executeQuery(query, cn);
			return(rs);
		}
		catch(Exception e)
		{
			System.out.println("Display All "+e);
			return null;
		}
    }
	public static AgencyVehicle DisplayByID(String vid)
	{
		try
		{
			Connection cn=DBHelper.openConnection();
			String query="select * from agencyvehicle where vehicleid='"+vid+"'";
			ResultSet rs=DBHelper.executeQuery(query, cn);
			if(rs.next())
			{
				AgencyVehicle V=new AgencyVehicle();
				V.setTransactionid(rs.getString(1));
				V.setVehicleid(rs.getString(2));
				V.setAgencyid(rs.getString(3));
				V.setVehiclename(rs.getString(4));
				V.setModelyear(rs.getString(5));
				V.setVehiclecolor(rs.getString(6));
				V.setVehicletype(rs.getString(7));
				V.setCapacity(rs.getString(8));
				V.setInsurance(rs.getString(9));
				V.setAirconditionar(rs.getString(10));
				V.setFueltype(rs.getString(11));
				V.setVehiclepicture(rs.getString(12));
				return(V);
			}
			return(null);
		}
		catch(Exception e)
		{
			System.out.println("DisplayByID "+e);
			return null;
		}
    }
	public static boolean EditRecord(AgencyVehicle V)
	{
		try{
			Connection cn=DBHelper.openConnection();
			String query="update agencyvehicle set vehicleid='"+V.getVehicleid()+"',agencyid='"+V.getAgencyid()+"',vehiclename='"+V.getVehiclename()+"',modelyear='"+V.getModelyear()+"',vehiclecolor='"+V.getVehiclecolor()+"',vehicletype='"+V.getVehicletype()+"',capacity='"+V.getCapacity()+"',insurance='"+V.getInsurance()+"',airconditionar='"+V.getAirconditionar()+"',fueltype='"+V.getFueltype()+"' where vehicleid='"+V.getVehicleid()+"'"; 
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(query, cn);
			return(st);


		}
		catch(Exception e)
		{
			System.out.println("EditRecord "+e);
			return false;
		}
	}
	public static boolean DeleteRecord(String vid)
	{
		try
		{
			Connection cn = DBHelper.openConnection();
			String query = "delete from agencyvehicle where vehicleid='"+vid+"'";
			boolean st = DBHelper.executeUpdate(query, cn);
			return (st);
		}
		catch(Exception e)
		{
			System.out.println("DeleteRecord"+e);
			return false;
		}
	}
	public static boolean Uploadpicture(AgencyVehicle V)
	{
		try
		{
			Connection cn=DBHelper.openConnection();
			String query="update agencyvehicle set vehiclepicture='"+V.getVehiclepicture()+"' where vehicleid='"+V.getVehicleid()+"'";  
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(query, cn);
			return(st);
		}
		catch(Exception e)
		{
			System.out.println("AddNewRecord "+e);
			return false;
		}
	}
	
	public static ResultSet vehicleByCity(String city,String tp)
	{
		try
		{  int tpp=Integer.parseInt(tp);
			Connection cn=DBHelper.openConnection();
			String query="";
			if(tpp<=5)
			{
			query="select v.* from agencyvehicle v ,agency a where v.agencyid=a.agencyid and a.city='"+city+"' and v.capacity between 1 and 5";
			}
			else
			{
				query="select v.* from agencyvehicle v ,agency a where v.agencyid=a.agencyid and a.city='"+city+"' and v.capacity>5";	
			}
			ResultSet rs=DBHelper.executeQuery(query, cn);
			return(rs);
		}
		catch(Exception e)
		{
			System.out.println("Display All "+e);
			return null;
		}
    }
	
	
	
	
}
