<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<nav>
    <input id="dashboard" type="button" value="Dashboard"/>
    <a href='<spring:url value="/classement"/>'><input id="classement" type="button" value="Classement" /></a>
    <input id="deconnection" type="button" value="Déconnection" />
</nav>