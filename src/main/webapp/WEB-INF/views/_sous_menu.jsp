<%-- 
    Document   : _sous_menu
    Created on : 21 oct. 2016, 10:58:37
    Author     : tmpUsername
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${affiche}">
    ${dispo}
</c:if>
<input id="banque" type="button" value="Banque" onclick="banque()"/>

<table id="ligneVie">
    <tr>    <!-- Barre de vie du joueur -->
        <td id="ligneVieJoueur" class="centre">le joueur doit se nourrir dans : 
            <br/>
            <progress id="barrePogressionJoueur" value="${prochainRepas}" max="4"></progress>
        </td> 

        <!-- Barre de vie des moutons --> 
        <td id="ligneVieMouton" class="centre"></td>  
    </tr>
</table>
