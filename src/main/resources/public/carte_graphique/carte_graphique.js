$(document).ready(function() {
	let $listCarte_graphique = $("#listCarte_graphique");
	let $listId ;
	let $dropdown = $("#dropdown");
	
	
    $.get("http://localhost:8080/gpa_degpu/carte_graphique",function(resp){
	
		resp.forEach( c => appendToListCarte_graphique(c));
		
		
    });

	

	$.get("http://localhost:8080/gpa_degpu/carte_graphique",function(resp){
		
		resp.forEach( c =>  $dropdown.append($("<option />").val(c.id).text("id:"+c.id+" fabricant:"+c.fabricant+" nom:"+c.nom))  );
		
		
    });

	
	

	$listCarte_graphique.on("click", "li button", function() {
    	let elemid = $(this).parent().attr('id');
    	
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/gpa_degpu/carte_graphique/" + elemid.replace('carte_graphique-',''),
		    dataType: "json",
		    success: function(data){
		    	$("#"+elemid).remove();
		    }
		});	
    });

    
    
    $('#addCarte_graphique').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		$.ajax({
		    type: "POST",
		    url: "http://localhost:8080/gpa_degpu/carte_graphique",
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		        appendToListCarte_graphique(data);
		    }
		});
		
	});


$('#modifyCarte_graphique').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		let dropdown = $("#dropdown").val();
		console.log("dropdown "+dropdown)
		$.ajax({
		    type: "PUT",
		    url: "http://localhost:8080/gpa_degpu/carte_graphique/"+dropdown,
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		       console.log("great")
		    }
		});
		
	});
	
	
	/* Ajoute un élément li dans la liste de personne*/
	function appendToListCarte_graphique(carte_graphique) {
	    let liToAppend = `<li id="carte_graphique-${carte_graphique.id}" class="list-group-item" > ref:${carte_graphique.ref} fabricant:${carte_graphique.fabricant} nom:${carte_graphique.nom} stock:${carte_graphique.stock}`;
		liToAppend+= ` <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>`;

		$listCarte_graphique.append(liToAppend);
	}
	
	
});

