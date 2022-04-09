$(document).ready(function() {
	let $listCarte_mere = $("#listCarte_mere");
	let $listId ;
	let $dropdown = $("#dropdown");
	
	
    $.get("http://localhost:8080/gpa_degpu/carte_mere",function(resp){
	
		resp.forEach( c => appendToListCarte_mere(c));
		
		
    });


	$.get("http://localhost:8080/gpa_degpu/carte_mere",function(resp){
		
		resp.forEach( c =>  $dropdown.append($("<option />").val(c.id).text("id:"+c.id+" fabricant:"+c.fabricant+" nom:"+c.nom))  );
		
		
    });

	
	

	$listCarte_mere.on("click", "li button", function() {
    	let elemid = $(this).parent().attr('id');
    	
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/gpa_degpu/carte_mere/" + elemid.replace('carte_mere-',''),
		    dataType: "json",
		    success: function(data){
		    	$("#"+elemid).remove();
		    }
		});	
    });

    
    
    $('#addCarte_mere').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		$.ajax({
		    type: "POST",
		    url: "http://localhost:8080/gpa_degpu/carte_mere",
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		        appendToListCarte_mere(data);
		    }
		});
		
	});


$('#modifyCarte_mere').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		let dropdown = $("#dropdown").val();
		console.log("dropdown "+dropdown)
		$.ajax({
		    type: "PUT",
		    url: "http://localhost:8080/gpa_degpu/carte_mere/"+dropdown,
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		       console.log("great")
		    }
		});
		
	});
	
	
	/* Ajoute un élément li dans la liste de personne*/
	function appendToListCarte_mere(carte_mere) {
	    let liToAppend = `<li id="carte_mere-${carte_mere.id}" class="list-group-item" > ref:${carte_mere.ref} fabricant:${carte_mere.fabricant} nom:${carte_mere.nom} stock:${carte_mere.stock}`;
		liToAppend+= ` <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>`;

		$listCarte_mere.append(liToAppend);
	}
	
	
});

