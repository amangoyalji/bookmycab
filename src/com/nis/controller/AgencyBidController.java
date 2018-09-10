package com.nis.controller;

import java.sql.Connection;

import com.nis.model.Agency;
import com.nis.model.AgencyBidModel;

public class AgencyBidController {
	public static boolean AddNewRecord(AgencyBidModel A)
	{try{
		Connection cn=DBHelper.openConnection();
		String query="insert into agencybid(currentdate,currenttime,agencyid,bookingid,bidamount) values('"+A.getCurrentdate()+"','"+A.getCurrenttime()+"',"+A.getAgencyid()+","+A.getBookingid()+","+A.getBidamount()+")";
		boolean st=DBHelper.executeUpdate(query, cn);
		return(st);
		
		
	}catch(Exception e){
		System.out.println("AddNewRecord "+e);
		return false;
	}
	}
	
}
