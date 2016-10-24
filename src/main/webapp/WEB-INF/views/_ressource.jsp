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
            <input id="ressourceCarotte" type="number" min="1" max="${joueur.quantiteCarotte}"/>
            <input id="planterCarotte" type="button" value="Planter"  onclick="$(this).attr('disabled', true); planterCarotte($('#ressourceCarotte').val())" />
            <input id="planterCarotteMax" type="button" value="Planter max" onclick="$(this).attr('disabled', true); planterCarotte(${joueur.quantiteCarotte})" />
        </td>
    </c:if>
</tr>
<tr>
    <td class="ressource traitRessource centre">Blé :</td>
    <td class="traitRessource centre">${joueur.quantiteBle}</td>
    <c:if test="${joueur.quantiteBle > 0}">
        <td>
            <input id="ressourceBle" type="number" min="1" max="${joueur.quantiteBle}"/>
            <input id="planterBle" type="button" value="Planter"  onclick="$(this).attr('disabled', true); planterBle($('#ressourceBle').val())" />
            <input id="planterBleMax" type="button" value="Planter max" onclick="$(this).attr('disabled', true); planterBle(${joueur.quantiteBle})" />
        </td>
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
        <td>
            <input id="nourrirChevreChoix" type="number" min="1" max="${nbChevresPourManger }"/>
            <input id="nourrirChevre" type="button" value="Nourrir"  onclick="$(this).attr('disabled', true); nourrirChevre($('#nourrirChevreChoix').val())" />
            <input id="nourrirChevreMax" type="button" value="Nourrir max" onclick="$(this).attr('disabled', true); nourrirChevre(${nbChevresPourManger })" />
        </td>
    </c:if>
    <c:if test="${nbChevresReprod > 0}">
        <td>
            <input id="reprodChevreChoix" type="number" min="1" max="${nbChevresReprod}"/>
            <input id="reprodChevre" type="button" value="Reproduire"  onclick="$(this).attr('disabled', true); reproduction($('#reprodChevreChoix').val())" />
            <input id="reprodChevreMax" type="button" value="Reproduire max" onclick="$(this).attr('disabled', true); reproduction(${nbChevresReprod})" />
        </td>
    </c:if>

</tr>
