$(document).ready(function() {
	let $listProcesseur = $("#listProcesseur");
	let $listId ;
	let $dropdown = $("#dropdown");
	
	
    $.get("http://localhost:8080/gpa_degpu/processeur",function(resp){
	
		resp.forEach( p => appendToListProcesseur(p));
		
		
    });


	$.get("http://localhost:8080/gpa_degpu/processeur",function(resp){
		
		resp.forEach( p =>  $dropdown.append($("<option />").val(p.id).text("id:"+p.id+" fabricant:"+p.fabricant+" nom:"+p.nom))  );
		
		
    });

	
	

	$listProcesseur.on("click", "li button", function() {
    	let elemid = $(this).parent().attr('id');
    	
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/gpa_degpu/processeur/" + elemid.replace('processeur-',''),
		    dataType: "json",
		    success: function(data){
		    	$("#"+elemid).remove();
		    }
		});	
    });

    
    
    $('#addProcesseur').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		$.ajax({
		    type: "POST",
		    url: "http://localhost:8080/gpa_degpu/processeur",
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		        appendToListProcesseur(data);
		    }
		});
		
	});


$('#modifyProcesseur').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		let dropdown = $("#dropdown").val();
		console.log("dropdown "+dropdown)
		$.ajax({
		    type: "PUT",
		    url: "http://localhost:8080/gpa_degpu/processeur/"+dropdown,
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		       console.log("great")
		    }
		});
		
	});
	
	
	/* Ajoute un élément li dans la liste de personne*/
	function appendToListProcesseur(processeur) {
	    let liToAppend = `<li id="processeur-${processeur.id}" class="list-group-item" > ref:${processeur.ref} fabricant:${processeur.fabricant} nom:${processeur.nom} stock:${processeur.stock}`;
		liToAppend+= ` <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>`;

		$listProcesseur.append(liToAppend);
	}
	
	
});

