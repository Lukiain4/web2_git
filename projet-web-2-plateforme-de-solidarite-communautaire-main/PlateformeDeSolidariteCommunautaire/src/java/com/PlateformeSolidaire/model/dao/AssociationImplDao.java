/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.dao;

import com.PlateformeSolidaire.model.entities.Association;
import com.PlateformeSolidaire.model.singleton.ConnexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i5 4460 gtx 1060
 */
public class AssociationImplDao implements AssociationDao{

    private static final String SQL_INSERT_ASSOCIATION = "INSERT INTO association (`id`,`email`,`password`,`Campagnes_id`) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE_ASSOCIATION = "UPDATE association SET email = ?, password = ?, Campagnes_id = ? WHERE id = ?";
    private static final String SQL_DELETE_ASSOCIATION_PAR_ID = "DELETE FROM association WHERE id = ?";
    private static final String SQL_SELECT_ASSOCIATION = "SELECT * FROM association";
    private static final String SQL_SELECT_ASSOCIATION_PAR_ID = "SELECT * FROM association WHERE id = ?";
    private static final String SQL_SELECT_ASSOCIATION_PAR_NOM = "SELECT * FROM association WHERE nomAssocciation = ?";
    
    @Override
    public boolean create(Association association) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Association association) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Association association) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Association> findAll() {
        List<Association> listeAssociations = new ArrayList<>();

        PreparedStatement ps;
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_ASSOCIATION);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                Association association = new Association();
                association.setId(result.getInt("id"));
                association.setEmail(result.getString("email"));
                association.setPassword(result.getString("password"));

                listeAssociations.add(association);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AssociationImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionDB.closeConnection();
        return listeAssociations;
    }

    @Override
    public Association findById(int id) {
        Association association = null;
        try {
            // Initialise une requête préparée basée sur la connexion à la base de données
            // La requête SQL pour récupérer un utilisateur par son ID est utilisée pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_ASSOCIATION_PAR_ID);

            // Initialise la valeur de l'ID dans la requête SQL
            ps.setInt(1, id);

            // Exécution de la requête SQL et récupération des résultats dans un objet ResultSet
            ResultSet result = ps.executeQuery();

            // Parcours des résultats retournés par la requête SQL
            // Si des enregistrements sont trouvés, un nouvel objet Utilisateur est créé avec les données récupérées
            while (result.next()) {
                association = new Association();
                association.setId(result.getInt("id"));
                association.setEmail(result.getString("email"));
                association.setPassword(result.getString("password"));
            }
        } catch (SQLException ex) {
            // En cas d'erreur lors de l'exécution de la requête SQL, une exception est attrapée
            // Un message d'erreur est enregistré dans les logs avec une indication du problème
            Logger.getLogger(AssociationImplDao.class.getName()).log(Level.SEVERE, "Une erreur est survenue lors de la recherche de l'utilisateur par ID", ex);
        } finally {
            // Fermeture de toutes les ressources ouvertes, y compris la connexion à la base de données
            ConnexionDB.closeConnection();
        }

        // Retourne l'utilisateur trouvé ou null s'il n'existe pas
        return association;
    }

    @Override
    public Association findByName(String nomAssociation) {
        //ERREUR*** JE N'AI PAS MIS L'ATTRIBUT NOM DANS LA BASE DE DONNÉES. JE DOIS L'AJOUTER
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
