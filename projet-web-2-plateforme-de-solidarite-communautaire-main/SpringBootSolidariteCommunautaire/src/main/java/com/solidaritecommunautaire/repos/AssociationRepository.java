package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.Association;
import com.solidaritecommunautaire.entities.IndividuSolidaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends CrudRepository<Association, Integer>, JpaRepository<Association, Integer> {

    @Query("SELECT a FROM Association a WHERE a.email = :email")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public Association getAssociationByEmail(@Param("email") String email);

    @Query("SELECT a FROM Association a WHERE a.email = :email and a.password=:password")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public Association getAssociationByEmailAndPassword(@Param("email") String email,@Param("password") String password);
}
