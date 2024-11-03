package com.solidaritecommunautaire.services;


import com.solidaritecommunautaire.entities.Campagne;
import com.solidaritecommunautaire.repos.CampagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampagneService {
    @Autowired
    CampagneRepository repos;


    public List<Campagne> afficherCampagne(){
        return ( List<Campagne> ) repos.findAll();
    }

    public Campagne enregistrerCampagne(Campagne campagne){

        return repos.save(campagne);
    }
}
