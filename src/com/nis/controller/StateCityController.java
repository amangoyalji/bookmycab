package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class StateCityController {
public static ResultSet getAllStates()
{try{
	Connection cn=DBHelper.openConnection();
 ResultSet rs=DBHelper.executeQuery("select * from states", cn);	
	return(rs);

}catch(Exception e)
{System.out.println("getAllState:"+e);
return(null);
	}}
public static ResultSet getAllCitiesByState(String stateid)
{try{
	Connection cn=DBHelper.openConnection();
 ResultSet rs=DBHelper.executeQuery("select * from cities where stateid="+stateid, cn);	
	return(rs);

}catch(Exception e)
{System.out.println("getAllState:"+e);
return(null);
	}

}
public static ResultSet getAllCities()
{try{
	Connection cn=DBHelper.openConnection();
 ResultSet rs=DBHelper.executeQuery("select * from cities", cn);	
	return(rs);

}catch(Exception e)
{System.out.println("getAllState:"+e);
return(null);
	}

}	
	
}
