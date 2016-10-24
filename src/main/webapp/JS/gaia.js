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

$(document).ready(function () {

    setInterval(refresh, 1000);
});
