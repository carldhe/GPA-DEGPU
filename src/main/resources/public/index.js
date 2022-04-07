$(document).ready(function() {
	let $connection = $("#connection");
	let $listLien = $("#listLien");
	
	

	/*
		//la data récupérée est transformé en json puis retourner en format html
var parseJSON = function(data,n,p)
	{
		
		//à chaque fois qu'on parcours le json on lance notre tableau()
		var bool = $(data).each(function(i)
		{
			
			var bool = tableau(this,n,p);
			console.log("test 1",bool.toString())
			return bool
		});
		
		console.log("test 2",bool)
		return bool
		
	}
	
//[i] tableau va vérifier si l'utilisateur et le mot de passe sont dans la liste'
var tableau = function (element,n,p)
	{
		
		var name;
		var pass;
		for (const property in element)
		{
			
			
			if (property === "id") {
				name = "";
				pass = "";
			}
			if (property === "nom"){
				name = element.nom;
			}
			
			if (property === "mot_de_passe"){
				pass = element.mot_de_passe;
			}
			
			//console.log(name,pass)
			if (name == n && pass == p && n != "" && p != ""){
				//console.log("bingo",n,p)
				return true
			}
			
			
		};
		
		
		return false
	}
	*/
	
	
	
	function isPresent(utilisateurs,nom,pass){
		i=0;
		var tab = utilisateurs.map(user => {return user["nom"]== nom && user["mot_de_passe"]==pass } );
		
		for(var i in tab) {
			if (tab[i] == true){
				
				return true
			
		}
		}
		
		return false
	}
	
	

	$('#connection').click(function(){
		let nom = $('#nom').val();
		let mot_de_passe = $('#mot_de_passe').val();
		
		   //on récupère les utilisateurs
		$.ajax({
		    url: "http://localhost:8080/gpa_degpu/utilisateurs",
		    dataType: "json",
		    success: function(data)
			{
		        console.log("ça marche",data)
				console.log("type de data",typeof data)
				
				//converti un object array en json
				var json =JSON.stringify(data)
				json = JSON.parse(json)
				
				console.log(isPresent(json, nom,mot_de_passe))
				
				if (isPresent(json, nom,mot_de_passe) == true){
					lien();
				}
				
		    },
			error: function(err)
			{
				console.log("ça plante", err)
				console.log("type de data",typeof data);
			}
		});
		
		
		
		return false;
	});
    


	function lien() {
		console.log("lien")
	    let lien = `
<li><a href="utilisateurs/utilisateurs.html">utilisateurs</a></li>
<li><a href="ram/ram.html">ram</a></li>
<li><a href="processeur/processeur.html">processeur</a></li>
<li><a href="disque_dur/disque_dur.html"></a></li>
<li><a href="carte_mere/carte_mere.html"></a></li>
<li><a href="carte_graphique/carte_graphique.html"></a></li>
<li><a href="alimentation/alimentation.html"></a></li>
`;
		

		$listLien.append(lien);
	}
    

});





