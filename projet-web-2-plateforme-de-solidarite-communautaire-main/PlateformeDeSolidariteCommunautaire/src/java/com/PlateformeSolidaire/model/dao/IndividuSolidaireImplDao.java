/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.dao;

import com.PlateformeSolidaire.model.entities.IndividuSolidaire;
import com.PlateformeSolidaire.model.entities.Projet;
import com.PlateformeSolidaire.model.entities.Role;
import com.PlateformeSolidaire.model.singleton.ConnexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lesly
 */
public class IndividuSolidaireImplDao implements IndividuSolidaireDao{
    
    private static final String SQL_INSERT_INDIVIDUSOLIDAIRE = "INSERT INTO individusolidaire(id,nom,prenom,email,password,Role_id) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE_INDIVIDUSOLIDAIRE = "UPDATE individusolidaire SET nom = ?, prenom = ?, email = ?, password = ?, Role_id = ? WHERE id = ?";  
    private static final String SQL_DELETE_INDIVIDUSOLIDAIRE_PAR_ID = "DELETE FROM individusolidaire WHERE id = ?";    
    private static final String SQL_SELECT_INDIVIDUSOLIDAIRE = "SELECT * FROM individusolidaire";
    private static final String SQL_SELECT_INDIVIDUSOLIDAIRE_PAR_ID = "SELECT * FROM individusolidaire WHERE id = ?";
    private static final String SQL_SELECT_INDIVIDUSOLIDAIRE_PAR_EMAIL = "SELECT * FROM individusolidaire WHERE email = ?";  
    private static final String SQL_SELECT_PROJET = "SELECT * FROM projet";
    private static final String SQL_SELECT_PROJET_PAR_NOM_PROJET = "SELECT * FROM projet WHERE nom = ?";
    
    private static final String SQL_INSERT_INDIVIDUSOLIDAIRE_PROJET = "INSERT INTO individusolidaire_projet(individusolidaire_id, projet_id) VALUES (?, ?)";

    @Override
    public boolean create(IndividuSolidaire individu) {
       
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_INSERT_INDIVIDUSOLIDAIRE);
            ps.setInt(1, individu.getId());
            ps.setString(3, individu.getNom());
            ps.setString(2, individu.getEmail());
            ps.setString(4, individu.getPrenom());
            ps.setString(5, individu.getPassword());
            nbLigne = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        if (nbLigne > 0){
            retour = true;
        }
        
        ConnexionDB.closeConnection();
        return retour;
    }

    @Override
    public boolean update(IndividuSolidaire individu) {
        
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_UPDATE_INDIVIDUSOLIDAIRE);
            ps.setInt(1, individu.getId());
            ps.setString(3, individu.getNom());
            ps.setString(2, individu.getEmail());
            ps.setString(4, individu.getPrenom());
            ps.setString(5, individu.getPassword());

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE,null, e);          
        }
        
        if (nbLigne > 0) {
            retour = true;
        }
        
        ConnexionDB.closeConnection();
        return retour;         
    }

    @Override
    public boolean delete(int id) {
        
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_DELETE_INDIVIDUSOLIDAIRE_PAR_ID);        
            ps.setInt(1, id);
            nbLigne = ps.executeUpdate();
            
            if (nbLigne > 0) {
            retour = true;
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE,
        null, ex);
        }
        ConnexionDB.closeConnection();
        return retour;
    }

    @Override
    public List<IndividuSolidaire> findAll() {
        List<IndividuSolidaire> listeIndividus = new ArrayList<>();

        PreparedStatement ps;
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_INDIVIDUSOLIDAIRE);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                IndividuSolidaire individu = new IndividuSolidaire();
                individu.setId(result.getInt("id"));
                individu.setNom(result.getString("nom"));
                individu.setPrenom(result.getString("prenom"));
                individu.setEmail(result.getString("email"));
                individu.setPassword(result.getString("password"));

                listeIndividus.add(individu);

            }
        } catch (SQLException ex) {
            Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionDB.closeConnection();
        return listeIndividus;
    }

    @Override
    public IndividuSolidaire findById(int id) {
        IndividuSolidaire individu = null;
            
        try {
            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_INDIVIDUSOLIDAIRE_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                individu = new IndividuSolidaire();
                individu.setId(result.getInt("id"));
                individu.setNom(result.getString("nom"));
                individu.setPrenom(result.getString("prenom"));
                individu.setEmail(result.getString("email"));
                individu.setPassword(result.getString("password"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        ConnexionDB.closeConnection();
        return individu;
    }

    @Override
    public IndividuSolidaire findByEmail(String email) {
        IndividuSolidaire individu = null;
        
        try {
            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_INDIVIDUSOLIDAIRE_PAR_EMAIL);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                individu = new IndividuSolidaire();
                individu.setId(result.getInt("id"));
                individu.setNom(result.getString("nom"));
                individu.setPrenom(result.getString("prenom"));
                individu.setEmail(result.getString("email"));
                individu.setPassword(result.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE, "Une erreur est survenue lors de la recherche de l'utilisateur par email", ex);
        }
        
        ConnexionDB.closeConnection();
        return individu;
    }   
    
    
    // consulter les projets
    @Override
    public List<Projet> findAllProjet() {
        List<Projet> listeProjets = null;
        PreparedStatement ps = null;
        
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_PROJET);
            ResultSet result = ps.executeQuery();
            
            listeProjets = new ArrayList<>();
            
            while (result.next()) {
                Projet projet = new Projet();
                projet.setId(result.getInt("id"));
                projet.setNom(result.getString("nom"));
                projet.setDescription(result.getString("description"));

                listeProjets.add(projet);

            }
        } catch (SQLException ex) {
            Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE,"Une erreur est survenue lors de la récupération de tous les projets", ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE, "Erreur lors de la fermeture de la déclaration de requête", ex);
                }
            }
            ConnexionDB.closeConnection();
        }
        return listeProjets;
    }  
    
    
    @Override
    public boolean create(IndividuSolidaire individu, String nomProjet) {
        boolean retour = false;
        int nbLigne = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        Projet projet= null;
        int generatedId = 0;

        try {
            conn = ConnexionDB.getConnection();

            ps1 = conn.prepareStatement(SQL_SELECT_PROJET_PAR_NOM_PROJET);
            ps1.setString(1, nomProjet);
            ResultSet result = ps1.executeQuery();

            while (result.next()) {
                projet = new Projet();
                projet.setId(result.getInt("id"));
                projet.setNom(result.getString("nom"));
                projet.setDescription(result.getString("description"));
                individu.ajouter(projet);
            }

            ps = conn.prepareStatement(SQL_INSERT_INDIVIDUSOLIDAIRE);
            
            ps.setInt(1, individu.getId());
            ps.setString(3, individu.getNom());
            ps.setString(2, individu.getEmail());
            ps.setString(4, individu.getPrenom());
            ps.setString(5, individu.getPassword());

            nbLigne = ps.executeUpdate();

            ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            ps2 = conn.prepareStatement(SQL_INSERT_INDIVIDUSOLIDAIRE_PROJET);
            ps2.setInt(1, generatedId);
            ps2.setInt(2, projet.getId());

            nbLigne = ps2.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE, "Erreur dans la transaction", ex);
                }
            }
            Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE, "Une erreur est survenue lors de la création de l'utilisateur", e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE, "Erreur lors de la fermeture de la déclaration de requête", e);
                }
            }
            if (ps1 != null) {
                try {
                    ps1.close();
                } catch (SQLException e) {
                    Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE, "Erreur lors de la fermeture de la déclaration de requête", e);
                }
            }
            if (ps2 != null) {
                try {
                    ps2.close();
                } catch (SQLException e) {
                    Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE, "Erreur lors de la fermeture de la déclaration de requête", e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Logger.getLogger(IndividuSolidaireImplDao.class.getName()).log(Level.SEVERE, "Erreur lors de la fermeture de la connexion", e);
                }
            }
        }
        if (nbLigne > 0) {
            retour = true;
        }
        return retour;
    }
    
    
    /*
    // rejoindre un projet
    public void rejoindreProjet() {
        for (Projet projet : projets) {
            if (projet != null) {
                projet.ajouterIndividu(this);
            }

        }

    }
    */
    

           
    
    
    /*
    // proposer une initiative caritative
    public void proposerInitiativeCaritative(InitiativeCaritative initiative) {
        Scanner lectureClavier = new Scanner(System.in);

        System.out.println("Entrez le nom de l'initiative");
        String nomIni = lectureClavier.next();
        System.out.println("Entrez la description");
        String descriptionIni = lectureClavier.next();
        initiative.setNom(nomIni);
        initiative.setDescription(descriptionIni);

        initiatives.add(initiative);
        initiative.ajouterIndividu(this);
                   
        System.out.println(initiative.getNom() + " a été ajouté! ");
  
    }
    */
    /*
    // consulter les initiatives proposées
    public void consulterInitiativePropose() {
        int nbInitiatives = initiatives.size();

        if (nbInitiatives > 0) {
            for (InitiativeCaritative initiative : initiatives) {
                System.out.println(initiative);
            }

        } else {
            System.out.println(" Il n'y a pas d'initiative dans cette liste! ");
        }
    }
    */
    
    /*
    // faire un don financier
    public int faireDonFinancier(int donFinancier) {
        return donFinancier;
    }
    
    // faire un don materiel
    public String faireDonMateriel(String donMateriel) {
        return donMateriel;
    }
    
    // offrir du temps bénévole
    public double offrirTempsBenevolePourCausesSpecifiques(double temps) {
        return temps;
    }
    */
    
    /*
    // partager un histoire ou une ressource
    public void partagerHistoiresEtRessources(HistoireEtRessource histoire) {
        Scanner lectureClavier = new Scanner(System.in);

        System.out.println("Entrez le nom de l'histoire ou de la ressource");
        String nomPartage = lectureClavier.next();
        System.out.println("Entrez la description");
        String descriptionPartage = lectureClavier.next();
        histoire.setNom(nomPartage);
        histoire.setDescription(descriptionPartage);

        histoires.add(histoire);
        histoire.ajouterIndividu(this);
                   
        System.out.println(histoire.getNom() + " a été ajouté! ");
  
    }
    */
    
    /*
    // consulter les histoires et ressources
    public void consulterHistoireEtRessource() {
        int nbHistoires = histoires.size();

        if (nbHistoires > 0) {
            for (HistoireEtRessource histoire : histoires) {
                System.out.println(histoire);
            }

        } else {
            System.out.println(" Il n'y a pas d'histoires ou de ressources dans cette liste! ");
        }
    }

    */

}
