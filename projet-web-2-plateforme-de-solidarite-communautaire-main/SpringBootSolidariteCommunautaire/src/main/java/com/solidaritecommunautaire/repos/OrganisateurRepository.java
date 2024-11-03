package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.OrganisateurProjetSolidaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisateurRepository extends CrudRepository<OrganisateurProjetSolidaire,Integer> {
}
