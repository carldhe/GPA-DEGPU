$(document).ready(function() {
	let $connection = $("#connection");
	let list;
	
	$.getJSON("http://localhost:8080/gpa_degpu/utilisateurs",function(resp){
		$.each(resp,function(index){
			
		
		});
		
    });
   
$.ajax({
		    url: "http://localhost:8080/gpa_degpu/utilisateurs",
		    dataType: "json",
		    success: function(data)
			{
		        console.log("ça marche",data)
				parseJSON(data)
		    },
			error: function(err)
			{
				console.log("ça plante", err)
			}
		});
		
var parseJSON = function(data)
	{
		$(data).each(function(i)
		{
			createHTML(this);
		});
	}
	
	//[i]
	var createHTML = function (element)
	{
		/*for (var i= 0; i < element.length;i++)
		{
			var info=$("<p>").html(element.nom)
			$('#info').append(info);
			
		};
		*/
		
		$.each(element,function(i){
			var info=$("<p>").html(element[i])
			$('#info').append(info);
		
		});
	}

		
	
	

	$('#connection').click(function(){
		let nom = $('#nom').val();
		let mot_de_passe = $('#mot_de_passe').val();
		
		
		alert("connection réussi, bienvenu "+list);
		$('#nom').val('');
		$('#mot_de_passe').val('');
		return false;
	});
    
    


	

	
});