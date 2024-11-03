/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.PlateformeSolidaire.model.controller;

import com.PlateformeSolidaire.model.dao.OrganisateurProjetSolidaireImplDao;
import com.PlateformeSolidaire.model.entities.OrganisateurProjetSolidaire;
import com.PlateformeSolidaire.model.entities.Projet;
import com.PlateformeSolidaire.model.service.OrganisateurService;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author i5 4460 gtx 1060
 */
public class OrganisateurController extends HttpServlet {

    
    private OrganisateurService organisateurService;
    private String titre;
    private OrganisateurProjetSolidaire organisateur;
    private Projet projet;
    private List<Projet> listeProjets;
    boolean retour = false;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() throws ServletException {
        super.init();
        this.organisateurService = new OrganisateurService(new OrganisateurProjetSolidaireImplDao());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String operation = request.getParameter("operation");
        String id = request.getParameter("id");

        listeProjets = organisateurService.afficherLesLesProjets();

        titre = "Liste des projets ";
        request.setAttribute("titre", titre);
        request.setAttribute("listeProjets", listeProjets);
        request.getRequestDispatcher("organisateurs.jsp").forward(request, response);

        if (operation != null) {
            if (operation.equals("supprimer")) {
                String message = "Le projet dont l'id est " + id + " a été supprimé";
                int projetId = Integer.parseInt(id);
                System.out.println("operation: " + operation);
                System.out.println("userId: " + projetId);
                retour = organisateurService.supprimerUnProjet(projetId);
                System.out.println("retour : " + retour);
                if (retour) {
                    System.out.println("suppression: ");
                    request.setAttribute("message", message);
                    listeProjets = organisateurService.afficherLesLesProjets();
                    request.setAttribute("listeProjets", listeProjets);
                    request.getRequestDispatcher("organisateurs.jsp").forward(request, response);
                }

            }else {
                System.out.println("modification: ");
                int userId = Integer.parseInt(id);
                projet = organisateurService.chercherProjetParID(userId);
                request.setAttribute("projet", projet);
                request.getRequestDispatcher("modification.jsp").forward(request, response);
            }

        }
    }

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }

