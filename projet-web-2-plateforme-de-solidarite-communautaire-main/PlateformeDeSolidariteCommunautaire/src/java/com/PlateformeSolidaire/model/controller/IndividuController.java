/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.PlateformeSolidaire.model.controller;

import java.io.IOException;
import com.PlateformeSolidaire.model.dao.IndividuSolidaireImplDao;
import com.PlateformeSolidaire.model.entities.IndividuSolidaire;
import com.PlateformeSolidaire.model.entities.Projet;
import com.PlateformeSolidaire.model.service.IndividuService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Lesly
 */
public class IndividuController extends HttpServlet {
    private IndividuService individuService;
    private List<Projet> listeProjets;
    private IndividuSolidaire individu;
    private String titre;
    private boolean rejoint;
  
    @Override
    public void init() throws ServletException {
        super.init();
        this.individuService = new IndividuService(new IndividuSolidaireImplDao());
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nomProjet = request.getParameter("unProjet");
        
        listeProjets = individuService.afficherLesProjets();     
        request.setAttribute("listeProjets", listeProjets);  
        
        if (nomProjet != null && !nomProjet.equals("")) {
            System.out.println(" nomProjet : " + nomProjet);
            titre = nomProjet;
            request.setAttribute("titre", titre);
            rejoint = individuService.rejoindreProjet(individu, nomProjet);
            request.setAttribute("individu", individu);
            request.getRequestDispatcher("individu.jsp").forward(request, response);
        }
        request.getRequestDispatcher("individu.jsp").forward(request, response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
