package com.solidaritecommunautaire.repos;

import com.solidaritecommunautaire.entities.Association;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AssociationRepositoryTest {
    @Autowired
    private AssociationRepository repos;

    @Test
    public void testListDesAssociations() {
        Iterable<Association> listAssociations = repos.findAll();
        System.out.println(((List<Association>) listAssociations).get(0).afficherEnColonnes());
        listAssociations.forEach(association -> System.out.println(association));
    }
}
