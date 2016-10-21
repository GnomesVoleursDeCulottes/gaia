<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<tr>
    <th class="centre" colspan="3">MATERNITER</th>
</tr>
<tr>
    <td class="ressource traitMaterniter centre">Animaux en �levage</td>
    <td class="traitMaterniter centre">Quantit� �lev�e</td>
    <td class="traitMaterniter centre">Date de maturit�</td>
</tr>
<c:forEach var="chevreaux" items="${chevreauxJoueur}">
    <tr>
        <td class="ressource traitMaterniter centre">Chevreaux</td>
        <td class="traitMaterniter centre"> ${chevreaux.value}</td>
        <td class="traitMaterniter centre">au ${chevreaux.key} cycle(s)</td>
    </tr>
</c:forEach>



