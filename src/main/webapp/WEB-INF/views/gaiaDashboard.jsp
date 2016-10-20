<%-- 
    Document   : home
    Created on : 18 oct. 2016, 10:11:35
    Author     : admin
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>GAIA</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>

        <script src="JS/jquery-3.1.1.js" type="text/javascript"></script>
        <script src="../../JS/gaia.js" type="text/javascript"></script>

        <script type="text/javascript">

        </script>

    </head>

    <body>

        <c:import url="_menu.jsp"></c:import>

            <h1 id="titre">GAIA</h1>

            <br/>
            <div id="contenu">
                <br/>
                
                <c:import url="_cycle.jsp"></c:import>

                <h2>Joueur : ${joueur.login}</h2>
                
            <br/>

            <div id="sousMenu">
                <input id="seNourrir" type="button" value="Se nourrir" />
                <input id="banque" type="button" value="Banque" />
            </div>

            <table id="ligneVie">
                <tr>
                    <td id="ligneVieJoueur" class="centre"> ici l'homme vie</td>
                    <td id="ligneVieMouton" class="centre"> ici le mouton vie</td> 
                </tr>
            </table>


            <div id="tableaux">
                <table id="stock">
                    <tr>
                        <th class="centre" colspan="3">STOCK JOUEUR</th>
                    </tr>
                    <tr>
                        <td class="ressource traitRessource centre">Ressource</td>
                        <td class="traitRessource centre">Quantité</td>
                    </tr>
                    <c:import url="_ressource.jsp"></c:import>
                    </table>

                    <table id="plantation">
                        <tr>
                            <th class="centre" colspan="3">PLANTATION</th>
                        </tr>
                        <tr>
                            <td class="ressource traitPlantation centre">Ressource</td>
                            <td class="traitPlantation centre">Date de récolte</td>

                        </tr>
                    </table>
                </div>

            </div>

            <br/>
            <footer id="pied">
            <c:import url="_pied.jsp"></c:import>
        </footer>

    </body>

</html>
