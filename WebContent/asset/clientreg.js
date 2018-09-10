$(document).ready(
 function(){
$('#su').click(function(){
	
$.getJSON('ClientRegSubmit',{ajax:true,cname:$('#cname').val(),cdob:$('#cdob').val(),cgender:$('#cgender').val(),cadd:$('#cadd').val(),city:$('#city').val(),state:$('#state').val(),mobile:$('#mobile').val(),email:$('#email').val(),pwd:$('#pwd').val(),cpwd:$('#cpwd').val()},function(data){
	 
$('#res').html(data.result);
if(data.result=='Record Submitted...')
	{
	$('#cid').val($('#email').val());
	}
}); });	 
	 

$('#login').click(function(){
	
	$.getJSON('CheckClientLogin',{ajax:true,cid:$('#cid').val(),pwd:$('#ccpwd').val()},function(data){
		 
	 
	if(data.res=='1')
		{
		window.location.href='ClientHome';
		}
	else
		{$('#lmsg').html('<font color=red><i>Invalid Emailid/Mobileno/Password...</i></font>');
		}
	}); });	 


	 

 });