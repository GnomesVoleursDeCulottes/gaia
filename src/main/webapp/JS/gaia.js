var cycleAct = undefined;

var planterBle = function (ble) {
    var nbPlante;
    do {
        nbPlante = prompt("Combien de blé voulez vous planter? (max " + ble + ")");
    } while (nbPlante < 0 || nbPlante > ble);
    var tmp = "/gaia/planterBle/" + nbPlante;
    //   console.log(tmp);
    $.post(tmp);
    $("#stock").load("/gaia/ressource");
    $("#plantation").load("/gaia/plantation");
};

var nourrirChevre = function (chevre) {
    var nbANourrir;
    do {
        nbANourrir = prompt("Combien de chèvre(s) voulez vous nourrir? (max " + chevre + ")");


    } while (nbANourrir < 0 || nbANourrir > chevre);
    var tmp = "/gaia/nourrirChevre/" + nbANourrir;
    $.post(tmp);
    $("#stock").load("/gaia/ressource");
};

var reproduction = function (nbChevre) {
    var nbBebe;
    do {
        var nbBebe = prompt("Combien voulez-vous mettre de chevreaux au monde ?" + Math.floor(nbChevre / 2));
    } while (nbBebe < 0 || nbBebe > Math.floor(nbChevre / 2));
    var tmp = "/gaia/reproduction/" + nbBebe;
    $.post(tmp);
    $("#stock").load("/gaia/ressource");
    $("#materniter").load("/gaia/materniter");
};

var planterCarotte = function (carotte) {
    var nbPlante;
    do {
        nbPlante = prompt("Combien de carotte(s) voulez vous planter? (max " + carotte + ")");
    } while (nbPlante < 0 || nbPlante > carotte);
    var tmp = "/gaia/planterCarotte/" + nbPlante;
//    console.log(tmp);
    $.post(tmp);
    $("#stock").load("/gaia/ressource");
    $("#plantation").load("/gaia/plantation");
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

var seNourrir = function (dispo) {
    var leRepas;
    do {
        leRepas = prompt("Choisissez un repas parmi " + dispo);
    } while (!dispo.includes(leRepas));
    var toPost = "/gaia/seNourrir/" + leRepas;
    $.post(toPost);
    $("#stock").load("/gaia/ressource");
    $("#sousMenu").load("/gaia/sous_menu");
};

$(document).ready(function () {

    setInterval(refresh, 1000);
});
