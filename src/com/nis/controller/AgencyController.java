package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.Agency;

public class AgencyController {
public static boolean AddNewRecord(Agency A)
{try{
	Connection cn=DBHelper.openConnection();
	String query="insert into agency(agencyname,ownername,address,state,city,contactperson,mobileno,phoneno,emailid,registrationid,registrationid_proof,identity,identity_proof,logo,password,status) values('"+A.getAgencyname()+"','"+A.getOwnername()+"','"+A.getAddress()+"','"+A.getState()+"','"+A.getCity()+"','"+A.getContactperson()+"','"+A.getMobileno()+"','"+A.getPhoneno()+"','"+A.getEmailid()+"','"+A.getRegistrationid()+"','"+A.getRegistrationid_proof()+"','"+A.getIdentity()+"','"+A.getIdentity_proof()+"','"+A.getLogo()+"','"+A.getPassword()+"','"+A.getStatus()+"')";
	boolean st=DBHelper.executeUpdate(query, cn);
	return(st);
	
	
}catch(Exception e){
	System.out.println("AddNewRecord "+e);
	return false;
}
}

public static ResultSet DisplayAll()
{try{
	Connection cn=DBHelper.openConnection();
	String query="select a.agencyid,a.agencyname,a.ownername,a.address,(select s.statename from states s where s.stateid=a.state),(select c.cityname from cities c where c.cityid=a.city),a.contactperson,a.mobileno,a.phoneno,a.emailid,a.registrationid,a.registrationid_proof,a.identity,a.identity_proof,a.logo,a.password,a.status  from agency a";
	ResultSet rs=DBHelper.executeQuery(query, cn);
	return(rs);
	
	
}catch(Exception e){
	System.out.println("AddNewRecord "+e);
	return null;
}}
	
public static Agency DisplayByID(int aid)
{try{
	Connection cn=DBHelper.openConnection();
	String query="select a.agencyid,a.agencyname,a.ownername,a.address,a.state,(select s.statename from states s where s.stateid=a.state),a.city,(select c.cityname from cities c where c.cityid=a.city),a.contactperson,a.mobileno,a.phoneno,a.emailid,a.registrationid,a.registrationid_proof,a.identity,a.identity_proof,a.logo,a.password,a.status from agency a where a.agencyid="+aid;
	ResultSet rs=DBHelper.executeQuery(query, cn);
	if(rs.next())
	{Agency A=new Agency();
	 A.setAgencyid(rs.getString(1));
	 A.setAgencyname(rs.getString(2));
	 A.setOwnername(rs.getString(3));
	 A.setAddress(rs.getString(4));
	 A.setState(rs.getString(5)+","+rs.getString(6));
	 A.setCity(rs.getString(7)+","+rs.getString(8));
	 A.setContactperson(rs.getString(9));
	 A.setMobileno(rs.getString(10));
	 A.setPhoneno(rs.getString(11));
	 A.setEmailid(rs.getString(12));
	 A.setRegistrationid(rs.getString(13));
	 A.setRegistrationid_proof(rs.getString(14));
	 A.setIdentity(rs.getString(15));
	 A.setIdentity_proof(rs.getString(16));
	 A.setLogo(rs.getString(17));
	 A.setStatus(rs.getString(19));
	 return(A);
	}
	return(null);
}catch(Exception e){
	System.out.println("AddNewRecord "+e);
	return null;
}}

public static boolean EditRecord(Agency A)
{
try{
	Connection cn=DBHelper.openConnection();
	String query="update agency set agencyname='"+A.getAgencyname()+"',ownername='"+A.getOwnername()+"',address='"+A.getAddress()+"',state='"+A.getState()+"',city='"+A.getCity()+"',contactperson='"+A.getContactperson()+"',mobileno='"+A.getMobileno()+"',phoneno='"+A.getPhoneno()+"',emailid='"+A.getEmailid()+"',status='"+A.getStatus()+"' where agencyid="+A.getAgencyid(); 
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(query, cn);
	return(st);
	
	
}catch(Exception e){
	System.out.println("AddNewRecord "+e);
	return false;
}
}

public static boolean DeleteRecord(int aid)
{
try{
	Connection cn=DBHelper.openConnection();
	String query="delete from agency where agencyid="+aid; 
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(query, cn);
	return(st);
	
	
}catch(Exception e){
	System.out.println("AddNewRecord "+e);
	return false;
}
}

public static boolean EditRegistration(Agency A)
{
try{
	Connection cn=DBHelper.openConnection();
	String query="update agency set registrationid='"+A.getRegistrationid()+"',registrationid_proof='"+A.getRegistrationid_proof()+"' where agencyid="+A.getAgencyid(); 
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(query, cn);
	return(st);
	
	
}catch(Exception e){
	System.out.println("Edit Regid "+e);
	return false;
}
}
public static boolean EditIdProof(Agency A)
{
try{
	Connection cn=DBHelper.openConnection();
	String query="update agency set identity='"+A.getIdentity()+"',identity_proof='"+A.getIdentity_proof()+"' where agencyid="+A.getAgencyid(); 
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(query, cn);
	return(st);
	
	
}catch(Exception e){
	System.out.println("Edit Proof "+e);
	return false;
}
}
public static boolean EditLogo(Agency A)
{
try{
	Connection cn=DBHelper.openConnection();
	String query="update agency set Logo='"+A.getLogo()+"' where agencyid="+A.getAgencyid(); 
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(query, cn);
	return(st);
	
	
}catch(Exception e){
	System.out.println("Edit Logo "+e);
	return false;
}
}	
public static Agency CheckLogin(int aid,String password)
{ try
	{Connection cn=DBHelper.openConnection();
	ResultSet rs=DBHelper.executeQuery("select a.agencyid,a.agencyname,a.ownername,a.address,a.state,(select s.statename from states s where s.stateid=a.state),a.city,(select c.cityname from cities c where c.cityid=a.city),a.contactperson,a.mobileno,a.phoneno,a.emailid,a.registrationid,a.registrationid_proof,a.identity,a.identity_proof,a.logo,a.password,a.status from agency a where a.agencyid="+aid+" and +a.password='"+password+"'",cn);
	Agency A=new Agency();
	if(rs.next())
	{A.setAgencyid(rs.getString(1));
	 A.setAgencyname(rs.getString(2));
	 A.setOwnername(rs.getString(3));
	 A.setAddress(rs.getString(4));
	 A.setState(rs.getString(5)+","+rs.getString(6));
	 A.setCity(rs.getString(7)+","+rs.getString(8));
	 A.setContactperson(rs.getString(9));
	 A.setMobileno(rs.getString(10));
	 A.setPhoneno(rs.getString(11));
	 A.setEmailid(rs.getString(12));
	 A.setRegistrationid(rs.getString(13));
	 A.setRegistrationid_proof(rs.getString(14));
	 A.setIdentity(rs.getString(15));
	 A.setIdentity_proof(rs.getString(16));
	 A.setLogo(rs.getString(17));
	 A.setStatus(rs.getString(19));
	return A;}
	else {return null;}
	}catch(Exception e)
    {System.out.println("DisplayById"+e);
    return null;}
	
}

}
