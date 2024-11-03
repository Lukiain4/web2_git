package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.IndividuSolidaire;
import com.solidaritecommunautaire.entities.Projet;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividuRepository extends CrudRepository<IndividuSolidaire,Integer> {

    @Query("SELECT u FROM IndividuSolidaire u WHERE u.email = :email")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public IndividuSolidaire getIndividuByEmail(@Param("email") String email);

    @Query("SELECT u FROM IndividuSolidaire u WHERE u.email = :email and u.password=:password")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public IndividuSolidaire getIndividuByEmailAndPassword(@Param("email") String email,@Param("password") String password);

}
