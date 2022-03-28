$(document).ready(function() {
	let $connection = $("#connection");
	let list;
	
	
	$.getJSON("http://localhost:8080/gpa_degpu/utilisateurs",function(resp){
		$.each(resp,function(i, field){
			list.append(field);
		});
		
    });
   

	
	

	$('#connection').click(function(){
		let nom = $('#nom').val();
		let mot_de_passe = $('#mot_de_passe').val();
		
		
		alert("connection réussi, bienvenu "+list);
		$('#nom').val('');
		$('#mot_de_passe').val('');
		return false;
	});
    
    


	

	
});