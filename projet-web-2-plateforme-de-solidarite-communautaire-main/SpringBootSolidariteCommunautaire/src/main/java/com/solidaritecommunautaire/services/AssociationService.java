package com.solidaritecommunautaire.services;

import com.solidaritecommunautaire.entities.Association;
import com.solidaritecommunautaire.repos.AssociationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AssociationService {
    @Autowired
    AssociationRepository repos;


    public List<Association> afficherAssociations(){return (List<Association>) repos.findAll();}
    public Association enregistrerAssociation(Association association){ return repos.save(association); }

    public boolean isEmailAssociationUnique(String email,Integer id) {
        Association associationByEmail = repos.getAssociationByEmail(email);

        if (associationByEmail == null) return true;
        boolean isCreatingNewAssociation = false;
        if (id == null){
            isCreatingNewAssociation=true;
        }
        if(isCreatingNewAssociation){
            if (associationByEmail != null) return false;
        }else{
            if (associationByEmail.getId() != id) {
                return false;
            }
        }
        return true;
    }

    public Association rechercherAssociationParEmailMotDePasse(String email,String password) {
        Association associationByEmailAndPassword = repos.getAssociationByEmailAndPassword(email,password);
        if(associationByEmailAndPassword==null){
            return null;
        }
        return associationByEmailAndPassword;
    }


}
