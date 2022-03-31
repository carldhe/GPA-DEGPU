$(document).ready(function() {
	let $connection = $("#connection");
	let list;
	
	
	
   //on récupère les utilisateurs
$.ajax({
		    url: "http://localhost:8080/gpa_degpu/utilisateurs",
		    dataType: "json",
		    success: function(data)
			{
		        console.log("ça marche",data)
				parseJSON(data)
				//parcourir(data)
		    },
			error: function(err)
			{
				console.log("ça plante", err)
			}
		});
		
		//la data récupérer est transformé en json puis retourner en format html
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
		for (const property in element)
		{
			var info=$("<p>").html(element[property])
			$('#info').append(info);
			
		};
		
		
		
		console.log("test",typeof element);
		
		//parcours l'ensemble des éléments '
		/*
		$.each(element,function(i){
			var info=$("<p>").html(element.id +element.nom + element.mot_de_passe)
			$('#info').append(info);
		
		});
		*/
		
		
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