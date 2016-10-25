<%-- 
    Document   : _sous_menu
    Created on : 21 oct. 2016, 10:58:37
    Author     : tmpUsername
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<input id="banque" type="button" value="Banque" onclick="banque()"/>

<div id="banquier">
    <!-- Sert a afficher le contenu de _banque.jsp, ne rien mettre -->
</div>



<table id="ligneVie">
    <tr>    <!-- Barre de vie du joueur -->
        <td id="ligneVieJoueur" class="centre">le joueur doit se nourrir dans : 
            <br/>
            <progress id="barrePogressionJoueur" value="${prochainRepas}" max="4"></progress>
        </td> 
    </tr>
    <tr>
        <td>
            <c:if test="${affiche}">
                ${dispo}
            </c:if>
        </td>
    </tr>
</table>
