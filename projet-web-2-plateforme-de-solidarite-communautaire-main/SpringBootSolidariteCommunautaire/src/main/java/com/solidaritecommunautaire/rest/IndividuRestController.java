package com.solidaritecommunautaire.rest;

import com.solidaritecommunautaire.services.IndividuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndividuRestController {
    @Autowired
    IndividuService service;

    @PostMapping("/individu/check_email")
    public String verifierDoublonEmail(@Param("email") String email, @Param("id") Integer id) {

        return service.isEmailIndividuUnique(email,id) ? "OK" : "Doublon";
    }
}
