<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<tr>
    <td class="ressource traitRessource centre">Carotte :</td>
    <td class="traitRessource centre">${joueur.quantiteCarotte}</td>
</tr>
<tr>
    <td class="ressource traitRessource centre">Bl� :</td>
    <td class="traitRessource centre">${joueur.quantiteBle}</td>    
</tr>
<tr>
    <td class="ressource traitRessource centre">Fromage :</td>
    <td class="traitRessource centre">${joueur.quantiteFromage}</td>    
</tr>
<tr>
    <td class="ressource traitRessource centre">Ch�vre :</td>
    <td class="traitRessource centre">${fn:length(joueur.chevres)}</td>    
</tr>