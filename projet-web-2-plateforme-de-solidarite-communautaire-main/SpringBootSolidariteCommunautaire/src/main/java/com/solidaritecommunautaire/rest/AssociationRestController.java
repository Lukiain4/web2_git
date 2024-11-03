package com.solidaritecommunautaire.rest;

import com.solidaritecommunautaire.services.AssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssociationRestController {
    @Autowired
    AssociationService service;

    @PostMapping("/association/check_email")
    public String verifierDoublonEmail(@Param("email") String email, @Param("id") Integer id) {

        return service.isEmailAssociationUnique(email,id) ? "OK" : "Doublon";
    }
}
