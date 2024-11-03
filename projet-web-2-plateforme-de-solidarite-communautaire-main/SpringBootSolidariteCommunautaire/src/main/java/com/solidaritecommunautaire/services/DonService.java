package com.solidaritecommunautaire.services;

import com.solidaritecommunautaire.entities.Dons;
import com.solidaritecommunautaire.entities.IndividuSolidaire;
import com.solidaritecommunautaire.entities.Projet;
import com.solidaritecommunautaire.repos.DonRepository;
import com.solidaritecommunautaire.repos.IndividuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DonService {
    @Autowired
    DonRepository repos;

    @Autowired
    IndividuRepository reposInd;

    public List<Dons> afficherDons(){
        return ( List<Dons> ) repos.findAll();
    }

    public Dons enregistrerDons(Dons don){
        return repos.save(don);
    }

    public IndividuSolidaire trouverIndividu(Integer id) throws IndividuNotFoundException {

        try {
            return reposInd.findById(id).get();

        }catch (NoSuchElementException ex){
            throw new IndividuNotFoundException("On ne peut pas trouver un individu avec l'id " +id);
        }

    }

}
