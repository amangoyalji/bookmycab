$(document).ready(
function()
{       $('#vid').empty();
        $('#vid').append($('<option>').text("-select Vehicle Id-"));
		
    $.getJSON("VehicleIdJSON",{ajax:true,aid:$('#aid').val()},function(data)
    		{
    	  $.each(data,function(i,item)
    			  { 
                        /*  $('#vid').empty();
    			  $('#vid').append($('<option>').text("-select Vehicle Id-")); */
    		  $('#vid').append($('<option>').text(item.VEHICLEID).val(item.VEHICLEID));
    			  });
    	
    		});

}
);