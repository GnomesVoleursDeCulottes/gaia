<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table id="echange" class="centre">
    <tr>
        <td  class="traitBanque longueurCaseBanque">Ressource � �changer</td>

    </tr>
    <tr>


        <td id="quantiteAEchange" class="longueurCaseBanque">
            <select id="transaction">
                <c:if test="${joueur.quantiteBle > 3}">
                    <option value="blevschevre">Donner 4 bl�s contre une ch�vre</option>
                </c:if>
                <c:if test="${joueur.quantiteCarotte > 1}">    
                    <option value="carottevschevre">Donner 2 carottes contre une ch�vre</option>
                </c:if>
                <c:if test="${nbChevres > 0}">    
                    <option value="chevrevsble">Donner 1 ch�vre contre 4 bl�s</option>
                </c:if>
                <c:if test="${nbChevres > 0}">    
                    <option value="chevrevscarotte">Donner 1 ch�vre contre 2 carottes</option>
                </c:if>    
            </select>
        </td>


        <td id="boutonEchange" colspan="3"><input type="button" value="Echanger" onclick="transaction($('#transaction').val())"/></td>
    </tr>
</table>
