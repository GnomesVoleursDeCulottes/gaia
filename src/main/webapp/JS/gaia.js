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

var seNourrir = function (leRepas) {
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
        deces();
    }
};

var transaction = function (transa) {
    console.log(transa);
    var tmp = "/gaia/banque/" + transa;
    $.post(tmp);
    setTimeout(function () {
        $("#stock").load("/gaia/ressource");
        $("#sousMenu").load("/gaia/sous_menu");
    }, 100);
};

var banque = function () {
    $("#banquier").load("/gaia/banque");
};

var deces = function () {
    $.getJSON('ajax_est_mort', function (data) {
        if (data.mort == true) {
            location.href = 'mort';
        }
    });
}

$(document).ready(function () {
    setInterval(refresh, 1000);
});


