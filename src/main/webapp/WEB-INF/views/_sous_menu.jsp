<%-- 
    Document   : _sous_menu
    Created on : 21 oct. 2016, 10:58:37
    Author     : tmpUsername
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${affiche}">
    <input id="seNourrir" type="button" value="Se nourrir" onclick="seNourrir(${dispo})"/>
</c:if>
    <input id="banque" type="button" value="Banque" onclick="maBanque(${stock})"/>