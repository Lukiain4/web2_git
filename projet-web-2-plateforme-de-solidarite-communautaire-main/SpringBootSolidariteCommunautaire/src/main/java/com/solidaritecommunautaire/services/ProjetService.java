package com.solidaritecommunautaire.services;

import com.solidaritecommunautaire.entities.InitiativeCaritative;
import com.solidaritecommunautaire.entities.Projet;
import com.solidaritecommunautaire.repos.InitiativeRepository;
import com.solidaritecommunautaire.repos.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {
    @Autowired
    ProjetRepository repos;

    @Autowired
    InitiativeRepository reposInit;

    public List<Projet> afficherProjets(){
        return ( List<Projet> ) repos.findAll();
    }

    public List<InitiativeCaritative> afficherInitiatives(){
        return ( List<InitiativeCaritative> ) reposInit.findAll();
    }
}
