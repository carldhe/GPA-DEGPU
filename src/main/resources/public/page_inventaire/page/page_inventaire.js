$(document).ready(function() {
    let $listInventaire = $("#listInventaire");
    let $text_dynamique = $("#text_dynamique");





    $.get("http://localhost:8080/gpa_degpu/disque_dur",function(resp){

        resp.forEach( d => appendToListInventaire(d));

    });

    function appendToListInventaire(disque_dur) {

        let str = document.getElementById("text_dynamique").innerHTML;
        let res = str.replace(/blue/g, `fabricant:${disque_dur.fabricant} nom:${disque_dur.nom} capacite:${disque_dur.capacite} stock:${disque_dur.stock}`);
        document.getElementById("text_dynamique").innerHTML = res;

    }

});