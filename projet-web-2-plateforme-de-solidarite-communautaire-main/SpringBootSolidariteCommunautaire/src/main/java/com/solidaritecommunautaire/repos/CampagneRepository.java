package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.Campagne;
import com.solidaritecommunautaire.entities.Ressources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampagneRepository extends CrudRepository<Campagne,Integer>, JpaRepository<Campagne,Integer> {
    @Query("SELECT c FROM Campagne c WHERE c.association.id = :associationId")
    List<Campagne> getCampagnesByAssociationId(@Param("associationId") Long associationId);

    @Query("SELECT c FROM Campagne c JOIN c.association a WHERE a.id=?1")
    public List<Campagne> findAllByAssociation(Integer id);

    public Long countById(Integer id);
}
