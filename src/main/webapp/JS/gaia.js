var refresh = function () {
    $("#stock").load("/gaia/ressource");
    $("#cycle").load("/gaia/cycle");
};


setInterval(refresh, 1500);