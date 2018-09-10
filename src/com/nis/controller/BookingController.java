package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.Agency;
import com.nis.model.BookingModel;

public class BookingController {
	public static boolean AddNewRecord(BookingModel B)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="insert into booking(clientemail,mobileno,vehicleid,currentdate,bookingfrom,bookingto,source,destination,status)values('"+B.getClientemail()+"','"+B.getMobileno()+"','"+B.getVehicleid()+"','"+B.getCurrentdate()+"','"+B.getBookingfrom()+"','"+B.getBookingto()+"','"+B.getSource()+"','"+B.getDestination()+"','"+B.getStatus()+"')";
		
		boolean st=DBHelper.executeUpdate(query, cn);
		return(st);
		
		
	}catch(Exception e){
		System.out.println("AddNewRecord "+e);
		return false;
	}
  	}
	public static ResultSet DisplayBookingByClient()
	{try{
		Connection cn=DBHelper.openConnection();
		String query="select * from booking where status='UnBook'";
		
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return(rs);
		
		
	}catch(Exception e){
		System.out.println("DisplayBookingByClient "+e);
		return null;
	}
   	
	}
	public static boolean changeBookingStatus(int bookingid)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="update booking set status='Booked' where bookingid="+bookingid;
				
		
		boolean st=DBHelper.executeUpdate(query, cn);
		return(st);
		
		
	}catch(Exception e){
		System.out.println("AddNewRecord "+e);
		return false;
	}
  	}	
	
	
	}	
	

