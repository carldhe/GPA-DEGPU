$(document).ready(function() {
	let $listDisque_dur = $("#listDisque_dur");
	let $listId ;
	let $dropdown = $("#dropdown");
	
	
    $.get("http://localhost:8080/gpa_degpu/disque_dur",function(resp){
	
		resp.forEach( d => appendToListDisque_dur(d));
		
		
    });


	$.get("http://localhost:8080/gpa_degpu/disque_dur",function(resp){
		
		resp.forEach( d =>  $dropdown.append($("<option />").val(d.id).text("id:"+d.id+" fabricant:"+d.fabricant+" nom:"+d.nom+" capacite:"+d.capacite))  );
		
		
    });

	
	

	$listDisque_dur.on("click", "li button", function() {
    	let elemid = $(this).parent().attr('id');
    	
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/gpa_degpu/disque_dur/" + elemid.replace('disque_dur-',''),
		    dataType: "json",
		    success: function(data){
		    	$("#"+elemid).remove();
		    }
		});	
    });

    
    
    $('#addDisque_dur').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let capacite = $('#capacite').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		$.ajax({
		    type: "POST",
		    url: "http://localhost:8080/gpa_degpu/disque_dur",
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"capacite":capacite,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		        appendToListRam(data);
		    }
		});
		
	});


$('#modifyDisque_dur').click(function(){
		let fabricant = $('#fabricant').val();
		let nom = $('#nom').val();
		let capacite = $('#capacite').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		let dropdown = $("#dropdown").val();
		console.log("dropdown "+dropdown)
		$.ajax({
		    type: "PUT",
		    url: "http://localhost:8080/gpa_degpu/disque_dur/"+dropdown,
		    data: JSON.stringify({"fabricant":fabricant,"nom":nom,"capacite":capacite,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		       console.log("great")
		    }
		});
		
	});
	
	/* Ajoute un élément li dans la liste de personne*/
	function appendToListDisque_dur(disque_dur) {
	    let liToAppend = `<li id="disque_dur-${disque_dur.id}" class="list-group-item" > ref:${disque_dur.ref} fabricant:${disque_dur.fabricant} nom:${disque_dur.nom} capacite:${disque_dur.capacite} stock:${disque_dur.stock}`;
		liToAppend+= ` <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>`;

		$listDisque_dur.append(liToAppend);
	}
	
	

	
});