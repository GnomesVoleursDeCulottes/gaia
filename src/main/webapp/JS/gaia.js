var planterBle = function(ble){
    var nbPlante;
    do {
        nbPlante = prompt("Combien de blé voulez vous planter? (max " + ble + ")");
    }while (nbPlante < 0 || nbPlante > ble);
    var tmp ="/gaia/planterBle/" + nbPlante ;
    console.log(tmp);
    $.post(tmp);
};

var refresh = function () {
    $("#stock").load("/gaia/ressource");
    $("#cycle").load("/gaia/cycle");
};

setInterval(refresh, 1000);