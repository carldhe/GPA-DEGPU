$(document).ready(function() {
	let $listOrdinateur = $("#listOrdinateur");
	let $listId ;
	let $dropdown = $("#dropdown");
	let $dropdownAli = $("#dropdownAli");
	let $dropdownCarM = $("#dropdownCarM");
	let $dropdownCarG = $("#dropdownCarG");
	let $dropdownDis = $("#dropdownDis");
	let $dropdownPro = $("#dropdownPro");
	let $dropdownRam = $("#dropdownRam");
	
    $.get("http://localhost:8080/gpa_degpu/Ordinateur",function(resp){
		resp.forEach( o => appendToListOrdinateur(o));
    });


	$.get("http://localhost:8080/gpa_degpu/ordinateur",function(resp){
		resp.forEach( o =>  $dropdown.append($("<option />").val(o.id).text("id:"+o.id+" nom:"+o.nom))  );
    });

	$.get("http://localhost:8080/gpa_degpu/alimentation",function(resp){
		resp.forEach( r =>  $dropdownAli.append($("<option />").val(r.idAlimentation).text("id:"+r.idAlimentation+" fabricant:"+r.fabricant+" nom:"+r.nom+" puissance:"+r.puissance))  );
		});
	$.get("http://localhost:8080/gpa_degpu/carte_graphique",function(resp){
			resp.forEach( c =>  $dropdownCarG.append($("<option />").val(c.idCarte_Graphique).text("id:"+c.idCarte_Graphique+" fabricant:"+c.fabricant+" nom:"+c.nom))  );
	    });
	$.get("http://localhost:8080/gpa_degpu/carte_mere",function(resp){
			resp.forEach( c =>  $dropdownCarM.append($("<option />").val(c.idCarte_Mere).text("id:"+c.idCarte_Mere+" fabricant:"+c.fabricant+" nom:"+c.nom))  );	
	    });
	$.get("http://localhost:8080/gpa_degpu/disque_dur",function(resp){
			resp.forEach( d =>  $dropdownDis.append($("<option />").val(d.idDisque_Dur).text("id:"+d.idDisque_Dur+" fabricant:"+d.fabricant+" nom:"+d.nom+" capacite:"+d.capacite))  );
		});
	$.get("http://localhost:8080/gpa_degpu/processeur",function(resp){
			resp.forEach( p =>  $dropdownPro.append($("<option />").val(p.idProcesseur).text("id:"+p.idProcesseur+" fabricant:"+p.fabricant+" nom:"+p.nom))  );
		});
	$.get("http://localhost:8080/gpa_degpu/ram",function(resp){
			resp.forEach( r =>  $dropdownRam.append($("<option />").val(r.idRam).text("id:"+r.idRam+" fabricant:"+r.fabricant+" nom:"+r.nom+" capacite:"+r.capacite))  );
		});
	

	$listOrdinateur.on("click", "li button", function() {
    	let elemid = $(this).parent().attr('id');
    	
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/gpa_degpu/ordinateur/" + elemid.replace('ordinateur-',''),
		    dataType: "json",
		    success: function(data){
		    	$("#"+elemid).remove();
		    }
		});	
    });

    
    
    $('#addOrdinateur').click(function(){
		let nom = $('#nom').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		let dropdownAli = $("#dropdownAli").val();
		let dropdownCarG = $("#dropdownCarG").val();
		let dropdownCarM = $("#dropdownCarM").val();
		let dropdownDis = $("#dropdownDis").val();
		let dropdownPro = $("#dropdownPro").val();
		let dropdownRam = $("#dropdownRam").val();
		

		$.ajax({
		    type: "POST",
		    url: "http://localhost:8080/gpa_degpu/ordinateur",
		    data: JSON.stringify({"nom":nom,"ref":ref,"stock":stock,"idAlimentation":dropdownAli,"idCarte_Graphique":dropdownCarG,"idCarte_Mere":dropdownCarM,"idDisque_Dur":dropdownDis,"idProcesseur":dropdownPro,"idRam":dropdownRam}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		        appendToListOrdinateur(data);
		    }
		});
		
	});


$('#modifyOrdinateur').click(function(){
		let nom = $('#nom').val();
		let ref = $('#ref').val();
		let stock = $('#stock').val();
		
		
		let dropdown = $("#dropdown").val();
		console.log("dropdown "+dropdown)
		$.ajax({
		    type: "PUT",
		    url: "http://localhost:8080/gpa_degpu/ordinateur/"+dropdown,
		    data: JSON.stringify({"nom":nom,"ref":ref,"stock":stock}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		       console.log("great")
		    }
		});
		
	});
	
	
	/* Ajoute un élément li dans la liste de personne*/
	function appendToListOrdinateur(ordinateur) {
	    let liToAppend = `<li id="ordinateur-${ordinateur.id}" class="list-group-item" > ref:${ordinateur.ref} nom:${ordinateur.nom} stock:${ordinateur.stock}`;
		liToAppend+= ` <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></li>`;

		$listOrdinateur.append(liToAppend);
	}
	
	
});

