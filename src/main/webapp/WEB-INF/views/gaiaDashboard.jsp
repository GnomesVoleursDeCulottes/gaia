<%-- 
    Document   : home
    Created on : 18 oct. 2016, 10:11:35
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>GAIA</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>

        <script src="JS/jquery-3.1.1.js" type="text/javascript"></script>

    </head>

    <body>
        
        <c:import url="_menu.jsp"></c:import>

       <h1 id="titre">GAIA</h1>

        <br/>
        <div id="contenu">
            <br/>
            
            <h1>Cycle de Lune :</h1>
            <br/>
            
            <div id="sousmenu">
                <input id="seNourrir" type="button" value="Se nourrir" />
                <input id="nourrirChevre" type="button" value="Nourrir chèvre" />
                <input id="planter" type="button" value="Planter" />
                <input id="reproduction" type="button" value="Reproduction" />
                <input id="banque" type="button" value="Banque" />
            </div>
            
        </div>
        
        <br/>
        <footer id="pied">
            <c:import url="_pied.jsp"></c:import>
        </footer>

    </body>

</html>