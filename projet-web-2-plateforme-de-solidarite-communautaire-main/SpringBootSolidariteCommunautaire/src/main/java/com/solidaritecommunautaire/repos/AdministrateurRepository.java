package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.AdministrateurPlateforme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepository extends CrudRepository<AdministrateurPlateforme, Integer> {
}
