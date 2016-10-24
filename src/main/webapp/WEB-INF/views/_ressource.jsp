<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<tr>
    <th class="centre" colspan="3">STOCK JOUEUR</th>
</tr>
<tr>
    <td class="ressource traitRessource centre">Ressource</td>
    <td class="traitRessource centre">Quantité</td>
</tr>
<tr>
    <td class="ressource traitRessource centre">Carotte :</td>
    <td class="traitRessource centre">${joueur.quantiteCarotte}</td>
    <c:if test="${joueur.quantiteCarotte > 0}">
        <td>
            <input id="ressourceCarotte" type="number" min="0" max="${joueur.quantiteCarotte}" value="0"/>
            <input id="planterCarotte" type="button" value="Planter"  onclick="$(this).attr('disabled', true); planterCarotte($('#ressourceCarotte').val())" />
            <input id="planterCarotteMax" type="button" value="Planter max" onclick="$(this).attr('disabled', true); planterCarotte(${joueur.quantiteCarotte})" />
        </td>
    </c:if>
</tr>
<tr>
    <td class="ressource traitRessource centre">Blé :</td>
    <td class="traitRessource centre">${joueur.quantiteBle}</td>
    <c:if test="${joueur.quantiteBle > 0}">
        <td><input id="planterBle"  type="button" value="Planter" onclick="planterBle(${joueur.quantiteBle})"/></td>
        </c:if>
</tr>
<tr>
    <td class="ressource traitRessource centre">Fromage :</td>
    <td class="traitRessource centre">${joueur.quantiteFromage}</td>    
</tr>
<tr>
    <td class="ressource traitRessource centre">Chèvre :</td>
    <c:set var="nbChevres" value="${fn:length(joueur.chevres)}"/>
    <td class="traitRessource centre">${nbChevres}</td>
    <c:set var="nbChevresPourManger" value="${fn:length(chevrePourManger)}"/>
    <c:if test="${joueur.quantiteBle < nbChevresPourManger}">
        <c:set var="nbChevresPourManger" value="${joueur.quantiteBle}"/>
    </c:if>
    <c:if test="${nbChevresPourManger > 0}">
        <td><input id="nourrirChevre" type="button" value="Nourrir" onclick="nourrirChevre(${nbChevresPourManger})" /></td>
    </c:if>
    <c:if test="${nbChevresReprod > 1}">
        <td><input id="reproduction" type="button" value="Reproduction" onclick="reproduction(${nbChevresReprod})"/></td>
    </c:if>

</tr>