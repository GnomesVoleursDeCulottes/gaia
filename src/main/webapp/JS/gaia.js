var refresh = function () {
    $("#stock").load("/gaia/ressource");
    console.log("test");
};


setInterval(refresh, 2000);