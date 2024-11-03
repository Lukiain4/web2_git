<%-- 
    Document   : organisateurs
    Created on : 23 mars 2024, 12 h 45 min 20 s
    Author     : i5 4460 gtx 1060
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.PlateformeSolidaire.model.entities.OrganisateurProjetSolidaire"%>
<%@page import="com.PlateformeSolidaire.model.entities.Projet"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/gabarieStyle.css"/>
    </head>
    <body>
        <header>
            <div class="navBarre">
                <p class="logo">
                    <img src="images/solidaritercommunautairelogo-1-jZp.png" alt="Logo"/>
                    <span>SolidariterCommunautaire</span>
                </p>
                <div class="navigation">
                    <a href="index1.html"><h2>Accueil</h2></a>
                    <a href="associations.html"><h2>Associations</h2></a>
                    <a href="projets.html"><h2>Projets</h2></a>
                    <a href="propos.html"><h2>A propos</h2></a>
                    <a href="inscription.html"><h2>pas encore inscrit ?</h2></a>
                </div>
                <a class="connection" href="connexion.html">
                    <h2>Connexion</h2>
                    <img src="images/signinsqurefill-q9p.png" alt="Connexion"/>
                </a>
            </div>
        </header>


        <c:if test = "${not empty requestScope.message}">
            <h3 style="width: 60%; margin: auto; text-align:center; color:red; margin-bottom: 20px">${requestScope.message}</h3>
        </c:if>

        <c:if test = "${not empty requestScope.titre}">
            <h2 style="width: 60%; margin: auto; text-align:center; color:blue; margin-bottom: 20px">${requestScope.titre}</h2>
        </c:if>
        <div class="table-container">
            <table style="width:79%">
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Description</th>
                </tr> 







                <c:forEach var = "projet" items="${requestScope.listeProjets}">
                    <tr>
                        <td> ${projet.id} </td> 
                        <td> ${projet.nom} </td>
                        <td> ${projet.description} </td>

                    </tr>
                </c:forEach>





            </table>
        </div>
        <div>
            <h2 style="color: white;">Trombinoscope</h2>

            <div id="wrapTrombi">

                <c:forEach var = "projet" items="${requestScope.listeProjets}">
                    <article class = "trombi">
                        <ul style="color: white;">

                            <li> ${projet.nom}</li>
                            <li> ${projet.description}</li>
                        </ul>
                        <form action="organisateurController" method="get">
                            <div      id="dialog" title="Dialog box">
                                <input type="hidden" name="id" value="${projet.id}"/>
                            </div>
                            <input type="submit" name="operation" value="supprimer" style="width:70px"/>
                            <input type="submit" name="operation" id="myButton" value="modifier" /> 
                        </form>
                    </article>
                </c:forEach>  
            </div>
            <form action="inscription.html" method="post">
                <center>
                    <input type="submit"  value="Ajouter" /> 
                </center>

            </form>
        </div>

        <footer class="footer" >
            <div class="titre">
                <h2>
                    <span class="titreblanc">Solidariter</span>
                    <span class="titreVert">Communautaire</span>
                </h2>
            </div>
            <div class="coordonnees" >
                <div>
                    <h2>Ensemble pour un avenir solidaire</h2>
                </div>
                <div >
                    <img src="images/messagealtfill-B5p.png"/>
                    <h2>solidariter-communautaire@gmail.com</h2>
                </div>
                <div>
                    <img  src="images/phonefill-jVx.png"/>
                    <h2>+1 514-438-514</h2>
                </div>
                <div >
                    <img  src="images/pinfill-uMG.png"/>
                    <h2>16e Avenue, Montréal, QC</h2>
                </div>
            </div>

            <div class="droitsReserves"><h2>Tous droits réservés © 2024 Solidarité Communautaire - Contribuons ensemble à un monde plus solidaire.</h2></div>
        </footer>
    </body>
</html>
