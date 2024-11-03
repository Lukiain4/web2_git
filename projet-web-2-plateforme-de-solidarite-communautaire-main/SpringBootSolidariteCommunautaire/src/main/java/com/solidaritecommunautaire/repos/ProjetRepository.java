package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.IndividuSolidaire;
import com.solidaritecommunautaire.entities.Projet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends CrudRepository<Projet,Integer> {
    @Query("SELECT u FROM Projet u JOIN u.individus r WHERE r.id=?1")
    public List<Projet> findAllByIdIndividu(Integer id);

    public  Projet findProjetsById(Integer id);
}
