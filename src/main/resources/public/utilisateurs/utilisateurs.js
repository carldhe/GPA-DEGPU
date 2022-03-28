$(document).ready(function() {
	let $listUtilisateurs = $("#listUtilisateurs");

    $.get("http://localhost:8080/gpa_degpu/utilisateurs",function(resp){
		resp.forEach( p => appendToListPersonne(p));
    });

	

	$listUtilisateurs.on("click", "li button", function() {
    	let elemid = $(this).parent().attr('id');
    	
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/gpa_degpu/utilisateurs/" + elemid.replace('personne-',''),
		    dataType: "json",
		    success: function(data){
		    	$("#"+elemid).remove();
		    }
		});	
    });

    
    
    $('#addUtilisateur').click(function(){
		let nom = $('#nom').val();
		let mot_de_passe = $('#mot_de_passe').val();
		
		$.ajax({
		    type: "POST",
		    url: "http://localhost:8080/gpa_degpu/utilisateurs",
		    data: JSON.stringify({ "nom": nom, "mot_de_passe" : mot_de_passe }),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		        appendToListPersonne(data);
		    }
		});
		
		$('#nom').val('');
		$('#mot_de_passe').val('');
		return false;
	});

	
	/* Ajoute un élément li dans la liste de personne*/
	function appendToListPersonne(personne) {
	    let liToAppend = `<li id="personne-${personne.id}" class="list-group-item" >${personne.nom} ${personne.mot_de_passe}`;
		liToAppend+= ` <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>`;

		$listUtilisateurs.append(liToAppend);
	}

	

	
});