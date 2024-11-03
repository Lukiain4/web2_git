package com.solidaritecommunautaire.services;

import com.solidaritecommunautaire.entities.IndividuSolidaire;
import com.solidaritecommunautaire.entities.InitiativeCaritative;
import com.solidaritecommunautaire.entities.Role;
import com.solidaritecommunautaire.repos.IndividuRepository;
import com.solidaritecommunautaire.repos.InitiativeRepository;
import com.solidaritecommunautaire.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitiativeService {
    @Autowired
    InitiativeRepository repos;

    @Autowired
    RoleRepository reposRole;
    public List<InitiativeCaritative> afficherInitiatives(){
        return ( List<InitiativeCaritative> ) repos.findAll();
    }

    public List<Role> afficherRoles() { return ( List<Role> ) reposRole.findAll(); }

    public InitiativeCaritative enregistrerInitiative(InitiativeCaritative initiative){
        return repos.save(initiative);
    }
}
