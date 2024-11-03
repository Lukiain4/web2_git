/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PlateformeSolidaire.model.dao;

import com.PlateformeSolidaire.model.entities.OrganisateurProjetSolidaire;
import com.PlateformeSolidaire.model.entities.Role;
import com.PlateformeSolidaire.model.entities.Projet;
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
public class OrganisateurProjetSolidaireImplDao implements OrganisateurProjetSolidaireDao{
    
    private static final String SQL_INSERT_ORGANISATEURPROJETSOLIDAIRE = "INSERT INTO OrganisateurProjetSolidaire(id,nom,prenom,email,password,Role_id,Projet_id) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_ORGANISATEURPROJETSOLIDAIRE = "UPDATE OrganisateurProjetSolidaire SET nom = ?, prenom = ?, email = ?, password = ?, Role_id = ?, Projet_id = ? WHERE id = ?";  
    private static final String SQL_DELETE_ORGANISATEURPROJETSOLIDAIRE_PAR_ID = "DELETE FROM OrganisateurProjetSolidaire WHERE id = ?";    
    private static final String SQL_SELECT_ORGANISATEURPROJETSOLIDAIRE = "SELECT * FROM OrganisateurProjetSolidaire";
    private static final String SQL_SELECT_ORGANISATEURPROJETSOLIDAIRE_PAR_ID = "SELECT * FROM OrganisateurProjetSolidaire WHERE id = ?";
    private static final String SQL_SELECT_ORGANISATEURPROJETSOLIDAIRE_PAR_EMAIL = "SELECT * FROM OrganisateurProjetSolidaire WHERE email = ?";    
    private static final String SQL_INSERT_PROJETSOLIDAIRE = "INSERT INTO projet(id,nom,description,email,Roles) VALUES(?,?,?,?)";
    private static final String SQL_DELETE_PROJETSOLIDAIRE_PAR_ID = "DELETE FROM projet WHERE id = ?";
    private static final String SQL_UPDATE_PROJETSOLIDAIRE = "UPDATE projet SET nom = ?, description = ?, Roles = ? WHERE id = ?";
    private static final String SQL_SELECT_ROLES = "SELECT * FROM role";
    private static final String SQL_SELECT_PROJETS = "SELECT * FROM projet";
    private static final String SQL_SELECT_PROJET_PAR_ID = "SELECT * FROM projet WHERE id = ?";
 
    @Override
    public boolean create(OrganisateurProjetSolidaire organisateur) {
       
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_INSERT_ORGANISATEURPROJETSOLIDAIRE);
            ps.setInt(1, organisateur.getId());
            ps.setString(3, organisateur.getNom());
            ps.setString(2, organisateur.getEmail());
            ps.setString(4, organisateur.getPrenom());
            ps.setString(5, organisateur.getPassword());
            ps.setString(6, organisateur.getRole().toString());
            ps.setString(7, organisateur.getProjets().toString());
            nbLigne = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        if (nbLigne > 0){
            retour = true;
        }
        
        ConnexionDB.closeConnection();
        return retour;
    }

    @Override
    public boolean update(OrganisateurProjetSolidaire organisateur) {
        
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_UPDATE_ORGANISATEURPROJETSOLIDAIRE);
            ps.setInt(1, organisateur.getId());
            ps.setString(3, organisateur.getNom());
            ps.setString(2, organisateur.getEmail());
            ps.setString(4, organisateur.getPrenom());
            ps.setString(5, organisateur.getPassword());
            ps.setString(6, organisateur.getRole().toString());
            ps.setString(7, organisateur.getProjets().toString());

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE,null, e);          
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
            ps = ConnexionDB.getConnection().prepareStatement(SQL_DELETE_ORGANISATEURPROJETSOLIDAIRE_PAR_ID);        
            ps.setInt(1, id);
            nbLigne = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE,
        null, ex);
        }
        
        if (nbLigne > 0) {
            retour = true;
        }
        
        ConnexionDB.closeConnection();
        return retour;
    }

    @Override
    public List<OrganisateurProjetSolidaire> findAll() {
        List<OrganisateurProjetSolidaire> listeOrganisateurs = new ArrayList<>();

        PreparedStatement ps;
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_ORGANISATEURPROJETSOLIDAIRE);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                OrganisateurProjetSolidaire organisateur = new OrganisateurProjetSolidaire();
                organisateur.setId(result.getInt("id"));
                organisateur.setNom(result.getString("nom"));
                organisateur.setPrenom(result.getString("prenom"));
                organisateur.setEmail(result.getString("email"));
                organisateur.setPassword(result.getString("password"));
                organisateur.setRole((Role) result);
                organisateur.setProjets((List<Projet>) result);

                listeOrganisateurs.add(organisateur);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionDB.closeConnection();
        return listeOrganisateurs;
    }

    @Override
    public OrganisateurProjetSolidaire findById(int id) {
        OrganisateurProjetSolidaire organisateur = null;
            
        try {
            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_ORGANISATEURPROJETSOLIDAIRE_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                organisateur = new OrganisateurProjetSolidaire();
                organisateur.setId(result.getInt("id"));
                organisateur.setNom(result.getString("nom"));
                organisateur.setPrenom(result.getString("prenom"));
                organisateur.setEmail(result.getString("email"));
                organisateur.setPassword(result.getString("password"));
                organisateur.setRole((Role) result);     
                organisateur.setProjets((List<Projet>) result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        ConnexionDB.closeConnection();
        return organisateur;
    }

    @Override
    public OrganisateurProjetSolidaire findByEmail(String email) {
        OrganisateurProjetSolidaire organisateur = null;
        
        try {
            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_ORGANISATEURPROJETSOLIDAIRE_PAR_EMAIL);
            ps.setString(1, email);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                organisateur = new OrganisateurProjetSolidaire();
                organisateur.setId(result.getInt("id"));
                organisateur.setEmail(result.getString("email"));
                organisateur.setPassword(result.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE, "Une erreur est survenue lors de la recherche de l'utilisateur par email", ex);
        }
        
        ConnexionDB.closeConnection();
        return organisateur;
    } 
    
   // consulter les projets
   /* public void consulterProjets() {
        int nbProjets = projets.size();

        if (nbProjets > 0) {
            for (Projet projet : projets) {
                System.out.println(projet);
            }

        } else {
            System.out.println(" Il n'y a pas de projets dans cette liste! ");
        }
    }*/

    // rejoindre un projet
    /*public void rejoindreProjet() {
        for (Projet projet : projets) {
            if (projet != null) {
                projet.ajouterOrganisateur(this);
            }

        }

    }*/
    
    // proposer une initiative caritative
    /*public InitiativeCaritative proposerInitiativeCaritative(InitiativeCaritative initiative) {
        Scanner lectureClavier = new Scanner(System.in);

        System.out.println("Entrez le nom de l'initiative");
        String nomIni = lectureClavier.next();
        System.out.println("Entrez la description");
        String descriptionIni = lectureClavier.next();
        initiative.setNom(nomIni);
        initiative.setDescription(descriptionIni);

        initiatives.add(initiative);
        initiative.ajouterOrganisateur(this);
                   
        System.out.println(initiative.getNom() + " a été ajouté! ");
  
    }
    */
    
    // consulter les initiatives proposées
    /*public void consulterInitiativePropose() {
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
    
    // faire un don financier
    /*public int faireDonFinancier(int donFinancier) {
        return donFinancier;
    }
    */
    
    // faire un don materiel
    /*public String faireDonMateriel(String donMateriel) {
        return donMateriel;
    }
    */
    
    // offrir du temps bénévole
   /* public double offrirTempsBenevolePourCausesSpecifiques(double temps) {
        return temps;
    }
    */
    
    // partager un histoire ou une ressource
    /*public HistoireEtRessource partagerHistoiresEtRessources(HistoireEtRessource histoire) {
        Scanner lectureClavier = new Scanner(System.in);

        System.out.println("Entrez le nom de l'histoire ou de la ressource");
        String nomPartage = lectureClavier.next();
        System.out.println("Entrez la description");
        String descriptionPartage = lectureClavier.next();
        histoire.setNom(nomPartage);
        histoire.setDescription(descriptionPartage);

        histoires.add(histoire);
        histoire.ajouterOrganisateur(this);
                   
        System.out.println(histoire.getNom() + " a été ajouté! ");
  
    }
    */
    
    // consulter les histoires et ressources
    /*public void consulterHistoireEtRessource() {
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
       
     //creer un projet
    public boolean creerProjetSolidaire(Projet projet) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_INSERT_PROJETSOLIDAIRE);
            ps.setInt(1, projet.getId());
            ps.setString(3, projet.getNom());
            ps.setString(2, projet.getDescription());
            ps.setString(7, projet.getRoles().toString());
            nbLigne = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        if (nbLigne > 0){
            retour = true;
        }
        
        ConnexionDB.closeConnection();
        return retour;
    }
    
    // gerer un projet
    public boolean deleteProjetSolidaire(int id) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_DELETE_PROJETSOLIDAIRE_PAR_ID);        
            ps.setInt(1, id);
            nbLigne = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE,
        null, ex);
        }
        
        if (nbLigne > 0) {
            retour = true;
        }
        
        ConnexionDB.closeConnection();
        return retour;
    }
    
    public boolean updateProjetSolidaire(Projet projet) {
        
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        
        try {
            ps = ConnexionDB.getConnection().prepareStatement(SQL_UPDATE_PROJETSOLIDAIRE);
            ps.setInt(1, projet.getId());
            ps.setString(3, projet.getNom());
            ps.setString(2, projet.getDescription());
            ps.setString(7, projet.getRoles().toString());

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE,null, e);          
        }
        
        if (nbLigne > 0) {
            retour = true;
        }
        
        ConnexionDB.closeConnection();
        return retour;         
    }
    
    /*
    // inviter un membre
    public void inviterMembre(IndividuSolidaire membre) {
        
    }
    
    // suivre la progression des initiatives 
    public void suivreProgression(){
    
    }
    
    // informer les participants des résultats des initiatives
    public void informerResultats(){
    
    }
    
    // gerer les ressources d'un projet
    public void gererRessources(){
    
    }
    */

    @Override
    public List<Role> findAllRoles() {
        List<Role> listeRoles = null; // Initialise la liste des rôles à null
        PreparedStatement ps = null; // Initialise la déclaration de requête à null

        try {
            // Prépare la requête pour sélectionner tous les rôles de la base de données
            ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_ROLES);

            // Exécute la requête et récupère les résultats dans le ResultSet
            ResultSet result = ps.executeQuery();

            listeRoles = new ArrayList<>(); // Initialise la liste des rôles

            // Parcours les résultats retournés par la requête
            while (result.next()) {
                // Pour chaque enregistrement, crée un nouvel objet Role
                Role role = new Role();

                // Affecte les valeurs des colonnes "id", "nom" et "description" de la table à l'objet Role
                role.setId(result.getInt("id"));
                role.setNom(result.getString("nom"));
                role.setDescription(result.getString("description"));

                // Ajoute le rôle à la liste des rôles
                listeRoles.add(role);
            }
        } catch (SQLException ex) {
            // En cas d'erreur lors de l'exécution de la requête SQL, une exception est attrapée
            // Un message d'erreur est enregistré dans les logs avec une indication du problème
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE, "Une erreur est survenue lors de la récupération de tous les rôles", ex);
        } finally {
            // Ferme la déclaration de requête pour libérer les ressources
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    // En cas d'erreur lors de la fermeture de la déclaration de requête, une exception est attrapée
                    // Un message d'erreur est enregistré dans les logs avec une indication du problème
                    Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE, "Erreur lors de la fermeture de la déclaration de requête", ex);
                }
            }
            // Ferme la connexion après l'exécution de la requête
            ConnexionDB.closeConnection();
        }

        return listeRoles; // Retourne la liste des rôles récupérés (ou null s'il n'y en a aucun)
    }

    @Override
    public List<Projet> findAllProjets() {
        List<Projet> listeRoles = null; // Initialise la liste des rôles à null
        PreparedStatement ps = null; // Initialise la déclaration de requête à null

        try {
            // Prépare la requête pour sélectionner tous les rôles de la base de données
            ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_PROJETS);

            // Exécute la requête et récupère les résultats dans le ResultSet
            ResultSet result = ps.executeQuery();

            listeRoles = new ArrayList<>(); // Initialise la liste des rôles

            // Parcours les résultats retournés par la requête
            while (result.next()) {
                // Pour chaque enregistrement, crée un nouvel objet Role
                Projet projet = new Projet();

                // Affecte les valeurs des colonnes "id", "nom" et "description" de la table à l'objet Role
                projet.setId(result.getInt("id"));
                projet.setNom(result.getString("nom"));
                projet.setDescription(result.getString("description"));
                

                // Ajoute le rôle à la liste des rôles
                listeRoles.add(projet);
            }
        } catch (SQLException ex) {
            // En cas d'erreur lors de l'exécution de la requête SQL, une exception est attrapée
            // Un message d'erreur est enregistré dans les logs avec une indication du problème
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE, "Une erreur est survenue lors de la récupération de tous les projets", ex);
        } finally {
            // Ferme la déclaration de requête pour libérer les ressources
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    // En cas d'erreur lors de la fermeture de la déclaration de requête, une exception est attrapée
                    // Un message d'erreur est enregistré dans les logs avec une indication du problème
                    Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE, "Erreur lors de la fermeture de la déclaration de requête", ex);
                }
            }
            // Ferme la connexion après l'exécution de la requête
            ConnexionDB.closeConnection();
        }

        return listeRoles; // Retourne la liste des projets récupérés (ou null s'il n'y en a aucun)
    }

    @Override
    public boolean deleteProjet(int id) {
        boolean retour = false; // Initialise le statut de retour à false
        int nbLigne=0 ; // Initialise le nombre de lignes affectées à zéro

        try (Connection connection = ConnexionDB.getConnection(); // Obtient une connexion à la base de données
                 PreparedStatement ps = connection.prepareStatement(SQL_DELETE_PROJETSOLIDAIRE_PAR_ID)) { // Prépare la requête de suppression des rôles par ID

            // Définit la valeur du paramètre de la requête de suppression
            ps.setInt(1, id);

            // Exécute la requête de suppression et récupère le nombre de lignes affectées
            nbLigne = ps.executeUpdate();

            // Vérifie si au moins une ligne a été supprimée avec succès
            if (nbLigne > 0) {
                retour = true; // Met à jour le statut de retour à true
            }
        } catch (SQLException e) {
            // Attrape toute exception de type SQLException
            // Affiche la trace de l'exception (pour le débogage)
                    } finally {
            ConnexionDB.closeConnection(); // Ferme la connexion à la base de données dans tous les cas
        }

        return retour; // Retourne le statut de la suppression du rôle (true si réussie, false sinon)
    }

    @Override
    public Projet findProjetById(int id) {
        Projet projet = null;
            
        try {
            PreparedStatement ps = ConnexionDB.getConnection().prepareStatement(SQL_SELECT_PROJET_PAR_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                projet = new Projet();
                projet.setId(result.getInt("id"));
                projet.setNom(result.getString("nom"));
                projet.setDescription(result.getString("description"));
                projet.setRoles((List<Role>) result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrganisateurProjetSolidaireImplDao.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        ConnexionDB.closeConnection();
        return projet;
    }
}
