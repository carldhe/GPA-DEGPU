$(document).ready(function() {
	let $listRam = $("#listRam");
	let $listId ;
	let $dropdown = $("#dropdown");
	
	
    $.get("http://localhost:8080/gpa_degpu/ram",function(resp){
	
		resp.forEach( r => appendToListRam(r));
		
		
    });


	$.get("http://localhost:8080/gpa_degpu/ram",function(resp){
		
		resp.forEach( r =>  $dropdown.append($("<option />").val(r.id).text("id:"+r.id+" fabricant:"+r.fabricant+" nom:"+r.nom+" capacite:"+r.capacite))  );
		
		
    });

	
	

	$listRam.on("click", "li button", function() {
    	let elemid = $(this).parent().attr('id');
    	
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/gpa_degpu/ram/" + elemid.replace('ram-',''),
		    dataType: "json",
		    success: function(data){
		    	$("#"+elemid).remove();
		    }
		});	
    });

    
    
    $('#addRam').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let capacite = $('#capacite').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		$.ajax({
		    type: "POST",
		    url: "http://localhost:8080/gpa_degpu/ram",
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"capacite":capacite,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		        appendToListRam(data);
		    }
		});
		
	});


$('#modifyRam').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let capacite = $('#capacite').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		let dropdown = $("#dropdown").val();
		console.log("dropdown "+dropdown)
		$.ajax({
		    type: "PUT",
		    url: "http://localhost:8080/gpa_degpu/ram/"+dropdown,
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"capacite":capacite,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		       console.log("great")
		    }
		});
		
	});
	
	'{"fabricant":fabricant,"nom":nom,"capacite":capacite,"ref":ref,"stock":stock}'
	
	/* Ajoute un élément li dans la liste de personne*/
	function appendToListRam(ram) {
	    let liToAppend = `<li id="ram-${ram.id}" class="list-group-item" > ref:${ram.ref} fabricant:${ram.fabricant} nom:${ram.nom} capacite:${ram.capacite} stock:${ram.stock}`;
		liToAppend+= ` <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>`;

		$listRam.append(liToAppend);
	}
	
	

	
});