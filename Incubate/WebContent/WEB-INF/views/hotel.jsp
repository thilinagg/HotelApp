<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Hotel</title>
</head>
<body>

<form action="/Incubate/home" method="POST">
	<input type="hidden" name="hotel_id" id="hotel_id"/>
	<label>
			Hotel Name
	</label>
	<input type="text" name="hote_name" id="hotel_name"/>
	
	<br/>
	
	<label>
			Address
	</label>
	<input type="text" name="address" id="address"/>
	
	<br/>
	
	<label>
			City
	</label>
	<input type="text" name="city" id="city"/>
	
	<br/>
	
	<input type="button" value="Save" name="Save" id="savebutton"/>
	<input type="button" value="Update" name="Update" id="updatebutton"/>
	
	<h3> ${error}</h3>
	

</form>

 <h4 id="msg"></h4>

 <table id="hotel_table" border="1">
 
 
 </table>

<script>

function edit(hotel_id, hotel_name, address, city){
	$("#hotel_id").val(hotel_id);
	$("#hotel_name").val(hotel_name);
	$("#address").val(address);
	$("#city").val(city);
	$("#savebutton").hide();
	$("#updatebutton").show();
}

function load_details_table(){
	console.log("something");
    $.ajax({
        type: 'GET',
        url: 'list_hotels',
        ContentType: 'application/json',
        dataType: 'json',
        data: {},
        success:function(data){
            var table_row = "<tr><th>Hotel Name</th><th>Address</th><th>City</th></tr>";
            $.each(data, function (x, values) {

                    table_row += "<tr><td>"+values.hotel_name+"</td><td>"+values.address+"</td><td>"+values.city+"</td><td><button type=\"button\" onclick='edit("+JSON.stringify(values.hotel_id)+","+JSON.stringify(values.hotel_name)+", "+JSON.stringify(values.address)+","+JSON.stringify(values.city)+")'> Edit  </button> </td><td><button type=\"button\" onclick='delete_entry_model("+JSON.stringify(values.hotel_id)+")'> Delete  </button> </td></tr>";
                
            });
                
               
            $('#hotel_table').remove("tr");
            $('#hotel_table').html(table_row);
        }
    });
}

$( document ).ready(function() {
	load_details_table();
	$('#updatebutton').hide();

	$( "#savebutton" ).click(function() {
		var hotel_name = $("#hotel_name").val();
		var address = $("#address").val();
		var city = $("#city").val();
		console.log(hotel_name);
		console.log(address);
		console.log(city);
		$.ajax({  
		    type : "POST",   
		  	 url : "addHotel",   
		    data : {'hotel_name': hotel_name, 'address': address, 'city': city },  
		    success : function(response) {  
		    	load_details_table();
		    	$("#msg").val("Hotel Added!");
		   	 
		    },  
		    error : function(e) {  
		     alert('Error: ' + e);   
		    }  
		   }); 
	
	});
	
	$( "#updatebutton" ).click(function() {
		var hotel_id = $("#hotel_id").val();
		var hotel_name = $("#hotel_name").val();
		var address = $("#address").val();
		var city = $("#city").val();
		console.log(hotel_name);
		console.log(address);
		console.log(city);
		$.ajax({  
		    type : "POST",   
		  	 url : "updateHotel",   
		    data : {'hotel_name': hotel_name, 'address': address, 'city': city, 'hotel_id': hotel_id},  
		    success : function(response) {  
		    	load_details_table();
		    	$("#msg").val("Hotel Updated!");
		    	$('#updatebutton').hide();
		    	$('#savebutton').show();
		   	 
		    },  
		    error : function(e) {  
		     alert('Error: ' + e);   
		    }  
		   }); 
	
	});
	
});


 


</script>

</body>
</html>