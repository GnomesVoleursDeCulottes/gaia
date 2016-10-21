    var planterBle = function(ble){
    var nbPlante;
    do {
        nbPlante = prompt("Combien de blé voulez vous planter? (max " + ble + ")");
    }while (nbPlante < 0 || nbPlante > ble);
    var tmp ="/gaia/planterBle/" + nbPlante ;
 //   console.log(tmp);
    $.post(tmp);
};

var planterCarotte = function(carotte){
    var nbPlante;
    do {
        nbPlante = prompt("Combien de carotte(s) voulez vous planter? (max " + carotte + ")");
    }while (nbPlante < 0 || nbPlante > carotte);
    var tmp ="/gaia/planterCarotte/" + nbPlante ;
//    console.log(tmp);
    $.post(tmp);
};

var refresh = function () {
    $("#stock").load("/gaia/ressource");
    $("#cycle").load("/gaia/cycle");
    $("#sousMenu").load("/gaia/sous_menu");
    $("#plantation").load("/gaia/plantation");
    $("#materniter").load("/gaia/materniter");
};

var seNourrir = function(dispo){
    var leRepas;
    do {
        leRepas = prompt("Choisissez un repas parmi " + dispo);
    }while (! dispo.includes(leRepas) );
    var toPost = "/gaia/seNourrir/" + leRepas;
    $.post(toPost);
};

$(document).ready(function (){
   
    setInterval(refresh, 1000);
});