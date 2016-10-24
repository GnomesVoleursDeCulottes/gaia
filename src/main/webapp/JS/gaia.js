var cycleAct = undefined;

var planterBle = function (ble) {
    var tmp = "/gaia/planterBle/" + ble;
    $.post(tmp);
    setTimeout(function () {
        $("#stock").load("/gaia/ressource");
        $("#plantation").load("/gaia/plantation");
    }, 100);
};

var planterCarotte = function (carotte) {
    var tmp = "/gaia/planterCarotte/" + carotte;
    $.post(tmp);
    setTimeout(function () {
        $("#plantation").load("/gaia/plantation");
        $("#stock").load("/gaia/ressource");
    }, 100);
};

var nourrirChevre = function (chevre) {
    var tmp = "/gaia/nourrirChevre/" + chevre;
    $.post(tmp);
    setTimeout(function () {
        $("#stock").load("/gaia/ressource");
    }, 100);
};

var reproduction = function (nbChevre) {
    var tmp = "/gaia/reproduction/" + nbChevre;
    $.post(tmp);
    setTimeout(function () {
        $("#stock").load("/gaia/ressource");
        $("#materniter").load("/gaia/materniter");
    }, 100);
};

var seNourrir = function (dispo) {
    var leRepas;
    do {
        leRepas = prompt("Choisissez un repas parmi " + dispo);
    } while (!dispo.includes(leRepas));
    var toPost = "/gaia/seNourrir/" + leRepas;
    $.post(toPost);
    setTimeout(function () {
        $("#stock").load("/gaia/ressource");
        $("#sousMenu").load("/gaia/sous_menu");
    }, 100);
};

var refresh = function () {
    $("#cycle").load("/gaia/cycle");
    if ($("#cycleAct").html() != cycleAct) {
        cycleAct = $("#cycleAct").html();
        $("#stock").load("/gaia/ressource");
        $("#sousMenu").load("/gaia/sous_menu");
        $("#plantation").load("/gaia/plantation");
        $("#materniter").load("/gaia/materniter");
    }
};



var maBanque = function(stock){
    
   $("#banquier").load("/gaia/banque");
    
    
};




$(document).ready(function () {

    setInterval(refresh, 1000);
});


