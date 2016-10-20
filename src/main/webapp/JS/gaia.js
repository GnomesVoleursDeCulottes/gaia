var refresh = function () {
    $("#stock").load("/gaia/ressource");
};


setInterval(refresh, 1500);