/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.dao;

import com.PlateformeSolidaire.model.entities.AdministrateurPlateforme;
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
public class AdministrateurPlateformeImplDao implements AdministrateurPlateformeDao {

    private static final String SQL_INSERT_ADMINISTRATEURPLATEFORME = "INSERT INTO administrateurplateforme (`id`,`email`,`password`,`IndividuSolidaire_id`,`IndividuSolidaire_Role_id`,`OrganisateurProjetSolidaire_id`,`OrganisateurProjetSolidaire_Role_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_ADMINISTRATEURPLATEFORME = "UPDATE administrateurplateforme SET email = ?, password = ?, IndividuSolidaire_id = ?, IndividuSolidaire_Role_id= ? , OrganisateurProjetSolidaire_id = ?, OrganisateurProjetSolidaire_Role_id = ?   WHERE id = ?";
    private static final String SQL_DELETE_ADMINISTRATEURPLATEFORME_PAR_ID = "DELETE FROM administrateurplateforme WHERE id = ?";
    private static final String SQL_SELECT_ADMINISTRATEURSPLATEFORME = "SELECT * FROM administrateurplateforme";
    private static final String SQL_SELECT_ADMINISTRATEURSPLATEFORME_PAR_ID = "SELECT * FROM administrateurplateforme WHERE id = ?";
    private static final String SQL_SELECT_ADMINISTRATEURSPLATEFORME_PAR_EMAIL = "SELECT * FROM administrateurplateforme WHERE email = ?";

    @Override
    public boolean create(AdministrateurPlateforme administrateurPlateforme) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(AdministrateurPlateforme administrateurPlateforme) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(AdministrateurPlateforme administrateurPlateforme) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AdministrateurPlateforme> findAll() {
        List<AdministrateurPlateforme> listeAdministrateurs = new ArrayList<>();

        PreparedStatement ps;
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_ADMINISTRATEURSPLATEFORME);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                AdministrateurPlateforme administrateurPlateforme = new AdministrateurPlateforme();
                administrateurPlateforme.setId(result.getInt("id"));
                administrateurPlateforme.setEmail(result.getString("email"));
                administrateurPlateforme.setPassword(result.getString("password"));

                listeAdministrateurs.add(administrateurPlateforme);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurPlateformeImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionDB.closeConnection();
        return listeAdministrateurs;
    }

    @Override
    public AdministrateurPlateforme findById(int id) {
        AdministrateurPlateforme administrateurPlateforme = null;
        try {
            // Initialise une requête préparée basée sur la connexion à la base de données
            // La requête SQL pour récupérer un utilisateur par son ID est utilisée pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_ADMINISTRATEURSPLATEFORME_PAR_ID);

            // Initialise la valeur de l'ID dans la requête SQL
            ps.setInt(1, id);

            // Exécution de la requête SQL et récupération des résultats dans un objet ResultSet
            ResultSet result = ps.executeQuery();

            // Parcours des résultats retournés par la requête SQL
            // Si des enregistrements sont trouvés, un nouvel objet Utilisateur est créé avec les données récupérées
            while (result.next()) {
                administrateurPlateforme = new AdministrateurPlateforme();
                administrateurPlateforme.setId(result.getInt("id"));
                administrateurPlateforme.setEmail(result.getString("email"));
                administrateurPlateforme.setPassword(result.getString("password"));
            }
        } catch (SQLException ex) {
            // En cas d'erreur lors de l'exécution de la requête SQL, une exception est attrapée
            // Un message d'erreur est enregistré dans les logs avec une indication du problème
            Logger.getLogger(AdministrateurPlateformeImplDao.class.getName()).log(Level.SEVERE, "Une erreur est survenue lors de la recherche de l'utilisateur par ID", ex);
        } finally {
            // Fermeture de toutes les ressources ouvertes, y compris la connexion à la base de données
            ConnexionDB.closeConnection();
        }

        // Retourne l'utilisateur trouvé ou null s'il n'existe pas
        return administrateurPlateforme;
    }

    @Override
    public AdministrateurPlateforme findByEmail(String email) {
        AdministrateurPlateforme administrateurPlateforme = null;
        try {
            // Initialise une requête préparée basée sur la connexion à la base de données
            // La requête SQL pour récupérer un utilisateur par son adresse email est utilisée pour construire l'objet PreparedStatement
            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_ADMINISTRATEURSPLATEFORME_PAR_EMAIL);

            // Initialise la valeur de l'email dans la requête SQL
            ps.setString(1, email);

            // Exécution de la requête SQL et récupération des résultats dans un objet ResultSet
            ResultSet result = ps.executeQuery();

            // Parcours des résultats retournés par la requête SQL
            // Si des enregistrements sont trouvés, un nouvel objet Utilisateur est créé avec les données récupérées
            while (result.next()) {
                administrateurPlateforme = new AdministrateurPlateforme();
                administrateurPlateforme.setId(result.getInt("id"));
                administrateurPlateforme.setEmail(result.getString("email"));
                administrateurPlateforme.setPassword(result.getString("password"));
            }
        } catch (SQLException ex) {
            // En cas d'erreur lors de l'exécution de la requête SQL, une exception est attrapée
            // Un message d'erreur est enregistré dans les logs avec une indication du problème
            Logger.getLogger(AdministrateurPlateformeImplDao.class.getName()).log(Level.SEVERE, "Une erreur est survenue lors de la recherche de l'utilisateur par email", ex);
        } finally {
            // Fermeture de toutes les ressources ouvertes, y compris la connexion à la base de données
            ConnexionDB.closeConnection();
        }

        // Retourne l'utilisateur trouvé ou null s'il n'existe pas
        return administrateurPlateforme;
    }

}
