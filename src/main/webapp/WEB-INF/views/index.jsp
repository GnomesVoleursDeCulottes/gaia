<%-- 
    Document   : home
    Created on : 18 oct. 2016, 10:11:35
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>

        <title>GAIA</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>

        <script src="JS/jquery-3.1.1.js" type="text/javascript"></script>

    </head>

    <body>

        <h1 id="titre">GAIA</h1>
        <br/>
        
        <nav id="menu"></nav>
        <br/>

        <div id="connection">

            <form:form class="centre" name="formulaire" modelAttribute="JoueurAttr" action="dashboard">

                <div>
                    <label for="pseudo" >Pseudo :</label>
                    <form:input id="pseudo" path="login"/>
                </div>
                <br/>
                <div>
                    <label for="mdp">Mot de passe :</label>
                    <form:input id="mdp" path="mdp"/>
                </div>
                <br/>

                <input type="submit" value="Valider" />

            </form:form>

        </div>

        <br/>
        <footer id="pied">
            <c:import url="_pied.jsp"></c:import>
        </footer>

    </body>

</html>
