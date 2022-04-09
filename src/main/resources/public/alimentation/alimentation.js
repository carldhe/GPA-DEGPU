$(document).ready(function() {
	let $listAlimentation = $("#listAlimentation");
	let $listId ;
	let $dropdown = $("#dropdown");
	
	
    $.get("http://localhost:8080/gpa_degpu/alimentation",function(resp){
	
		resp.forEach( r => appendToListAlimentation(r));
		
		
    });


	$.get("http://localhost:8080/gpa_degpu/alimentation",function(resp){
		
		resp.forEach( r =>  $dropdown.append($("<option />").val(r.id).text("id:"+r.id+" fabricant:"+r.fabricant+" nom:"+r.nom+" puissance:"+r.puissance))  );
		
		
    });

	
	

	$listAlimentation.on("click", "li button", function() {
    	let elemid = $(this).parent().attr('id');
    	
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/gpa_degpu/alimentation/" + elemid.replace('alimentation-',''),
		    dataType: "json",
		    success: function(data){
		    	$("#"+elemid).remove();
		    }
		});	
    });

    
    
    $('#addAlimentation').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let puissance = $('#puissance').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		$.ajax({
		    type: "POST",
		    url: "http://localhost:8080/gpa_degpu/alimentation",
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"puissance":puissance,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		        appendToListAlimentation(data);
		    }
		});
		
	});


$('#modifyAlimentation').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let puissance = $('#puissance').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		let dropdown = $("#dropdown").val();
		console.log("dropdown "+dropdown)
		$.ajax({
		    type: "PUT",
		    url: "http://localhost:8080/gpa_degpu/alimentation/"+dropdown,
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"puissance":puissance,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		       console.log("great")
		    }
		});
		
	});
	
	
	/* Ajoute un élément li dans la liste de personne*/
	function appendToListAlimentation(alimentation) {
	    let liToAppend = `<li id="alimentation-${alimentation.id}" class="list-group-item" > ref:${alimentation.ref} fabricant:${alimentation.fabricant} nom:${alimentation.nom} puissance:${alimentation.puissance} stock:${alimentation.stock}`;
		liToAppend+= ` <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>`;

		$listAlimentation.append(liToAppend);
	}
	
	

	
});