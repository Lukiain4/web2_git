package com.solidaritecommunautaire.services;

import com.solidaritecommunautaire.entities.Projet;
import com.solidaritecommunautaire.entities.Ressources;
import com.solidaritecommunautaire.repos.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourceService {
    @Autowired
    RessourceRepository repos;

    public List<Ressources> afficherRessources(){
        return ( List<Ressources> ) repos.findAll();
    }

    public Ressources enregistrerRessources(Ressources ressources){
        return repos.save(ressources);
    }

}
