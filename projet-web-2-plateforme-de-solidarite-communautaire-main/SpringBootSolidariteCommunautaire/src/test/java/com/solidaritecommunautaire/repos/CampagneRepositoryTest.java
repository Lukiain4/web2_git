package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.Campagne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CampagneRepositoryTest {
    @Autowired
    private CampagneRepository repos;

    @Test
    public void testListDesCampagnes() {
        Iterable<Campagne> listCampagnes = repos.findAll();
        System.out.println(((List<Campagne>) listCampagnes).get(0).afficherEnColonnes());
        listCampagnes.forEach(campagne -> System.out.println(campagne));
    }

    @Test
    public void testListDesCampagnesById() {
        Iterable<Campagne> listCampagnes = repos.getCampagnesByAssociationId(1L);
        System.out.println(((List<Campagne>) listCampagnes).get(0).afficherEnColonnes());
        listCampagnes.forEach(campagne -> System.out.println(campagne));
    }
}
