<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table id="echange" class="centre">
    <tr>
        <td  class="traitBanque longueurCaseBanque">Ressource à échanger</td>

    </tr>
    <tr>


        <td id="quantiteAEchange" class="longueurCaseBanque">
            <select id="transaction">
                <c:if test="${joueur.quantiteBle > 3}">
                    <option value="blevschevre">Echange 4 blés contre une chèvre</option>
                </c:if>
                <c:if test="${joueur.quantiteCarotte > 1}">    
                    <option value="carottevschevre">Echange 2 carottes contre une chèvre</option>
                </c:if>
            </select>
        </td>


        <td id="boutonEchange" colspan="3"><input type="button" value="Echanger" onclick="transaction($('#transaction').val())"/></td>
    </tr>
</table>
