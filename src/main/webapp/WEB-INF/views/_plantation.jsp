<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<tr>
    <th class="centre" colspan="3">PLANTATION</th>
</tr>
<tr>
    <td class="ressource traitPlantation centre">El�ment plant�</td>
    <td class="traitPlantation centre">Quantit� plant�e</td>
    <td class="traitPlantation centre">Date de r�colte</td>
</tr>
<c:forEach var="blePlante" items="${ble}">
    <tr>
        <td class="ressource traitPlantation centre">bl�(s)</td>
        <td class="traitPlantation centre"> ${blePlante.value}</td>
        <td class="traitPlantation centre">au ${blePlante.key} cycle(s)</td>
    </tr>
</c:forEach>
<c:forEach var="carottePlante" items="${carotte}">
    <tr>
        <td class="ressource traitPlantation centre"> Carotte(s)</td>
        <td class="traitPlantation centre"> ${carottePlante.value}</td>
        <td class="traitPlantation centre">au ${carottePlante.key} cycle(s)</td>
        </tr>
</c:forEach>













