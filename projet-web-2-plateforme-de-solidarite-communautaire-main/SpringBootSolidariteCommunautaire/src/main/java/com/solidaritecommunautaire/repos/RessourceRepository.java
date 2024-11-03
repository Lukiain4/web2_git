package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.Projet;
import com.solidaritecommunautaire.entities.Ressources;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RessourceRepository extends CrudRepository<Ressources,Integer> {
    @Query("SELECT u FROM Ressources u JOIN u.individu r WHERE r.id=?1")
    public List<Ressources> findAllByIdIndividu(Integer id);

    public Long countById(Integer id);
}
