<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<tr>
    <td class="ressource traitRessource centre">Carotte :</td>
    <td class="traitRessource centre">${joueur.quantiteCarotte}</td>
    <td><input id="planterCarotte" type="button" value="Planter" /></td>
</tr>
<tr>
    <td class="ressource traitRessource centre">Blé :</td>
    <td class="traitRessource centre">${joueur.quantiteBle}</td>
    <td><input id="planterBle" type="button" value="Planter" /></td>
</tr>
<tr>
    <td class="ressource traitRessource centre">Fromage :</td>
    <td class="traitRessource centre">${joueur.quantiteFromage}</td>    
</tr>
<tr>
    <td class="ressource traitRessource centre">Chèvre :</td>
    <td class="traitRessource centre">${fn:length(joueur.chevres)}</td>
    <td><input id="reproduction" type="button" value="Reproduction" /></td>
    <td><input id="nourrirChevre" type="button" value="Nourrir" /></td>
</tr>