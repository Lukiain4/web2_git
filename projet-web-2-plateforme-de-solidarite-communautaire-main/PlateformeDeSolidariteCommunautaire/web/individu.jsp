<%-- 
    Document   : individu
    Created on : Mar 23, 2024, 11:36:39 a.m.
    Author     : Lesly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.PlateformeSolidaire.model.entities.IndividuSolidaire"%>
<%@page import="com.PlateformeSolidaire.model.entities.Projet"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Page "Individu"</title>
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
                    <a href="index.html"><h2>Accueil</h2></a>
                    <a href="associations.html"><h2>Associations</h2></a>
                    <a href="projets.html"><h2>Projets</h2></a>
                    <a href="propos.html"><h2>A propos</h2></a>
                    <a href="inscription.html"><h2>pas encore inscrit ?</h2></a>
                    <a href="individuController"><h2>Individu</h2></a>
                </div>
                <a class="connection" href="connexion.html">
                    <h2>Connexion</h2>
                    <img src="images/signinsqurefill-q9p.png" alt="Connexion"/>
                </a>
            </div>
        </header>
        
        <main>
            <h2 class="titreblanc">Projets Disponibles</h2>
            <div class="table-container">
                <table style="width:79%">
                    <tr>
                        <th>Nom</th>
                        <th>Description</th>
                        <th>Rejoindre</th>
                    </tr> 
                        <c:forEach var = "projet" items="${requestScope.listeProjets}">
                            <tr>
                                <td> ${projet.nom} </td>
                                <td> ${projet.description} </td>
                                <td><button id="btn">Click me</button>
                                    <p id="check" style="display:none">&check;</p>
                                     <script>
                                        const btn = document.getElementById('btn');
                                        btn.onclick = function(){
                                        titre = ${requestScope.rejoint};
                                            if (unProjet === true){
                                            check.display.style = block;
                                            }
                                        };
                                    </script>
                                </td>                             
                            </tr>
                        </c:forEach>
                </table>  
            </div>
        </main>   
        
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
