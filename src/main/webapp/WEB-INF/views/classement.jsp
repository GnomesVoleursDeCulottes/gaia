<%-- 
    Document   : home
    Created on : 18 oct. 2016, 10:11:35
    Author     : admin
--%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
        <c:import url="_menu.jsp"/>
        
        <h1 id="titre">GAIA</h1>
        <br/>
        
        <nav id="menu"></nav>
        <br/>
        
        <div id="contenuClassement">
            <c:set value="1" var="classement"/>
            <table id="tabClassement">
                <tr>
                    <td class="tdClassement">Classement</td>
                    <td class="tdClassement">Pseudo</td>
                    <td class="tdClassement">Quantité blé</td>
                    <td class="tdClassement">Quantité Carotte</td>
                    <td class="tdClassement">Quantité Fromage</td>
                    <td class="tdClassement">Quantité Chèvre</td>
                </tr>
                <c:forEach items="${lesJoueurs}" var="joueur">
                    <tr>
                        <td class="tdClassement">${classement}</td>
                        <td class="tdClassement">${joueur.login}</td>
                        <td class="tdClassement">${joueur.quantiteBle}</td>
                        <td class="tdClassement">${joueur.quantiteCarotte}</td>
                        <td class="tdClassement">${joueur.quantiteFromage}</td>
                        <td class="tdClassement">${fn:length(joueur.chevres)}</td>
                    </tr>
                    <c:set value="${classement + 1}" var="classement"/>
                </c:forEach>
            </table>
        </div>
        <br/>
        
        <footer id="pied">
            <c:import url="_pied.jsp"/>
        </footer>

    </body>

</html>
