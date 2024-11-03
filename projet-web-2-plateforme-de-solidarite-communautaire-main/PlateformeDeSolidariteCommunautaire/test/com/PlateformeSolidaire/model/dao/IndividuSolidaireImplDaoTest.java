/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.PlateformeSolidaire.model.dao;

import com.PlateformeSolidaire.model.entities.IndividuSolidaire;
import com.PlateformeSolidaire.model.entities.Projet;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lesly
 */
public class IndividuSolidaireImplDaoTest {
    
    public IndividuSolidaireImplDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of create method, of class IndividuSolidaireImplDao.
     */
    @Test
    public void testCreate_IndividuSolidaire() {
        System.out.println("create");
        IndividuSolidaire individu = null;
        IndividuSolidaireImplDao instance = new IndividuSolidaireImplDao();
        boolean expResult = false;
        boolean result = instance.create(individu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class IndividuSolidaireImplDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        IndividuSolidaire individu = null;
        IndividuSolidaireImplDao instance = new IndividuSolidaireImplDao();
        boolean expResult = false;
        boolean result = instance.update(individu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class IndividuSolidaireImplDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        IndividuSolidaireImplDao instance = new IndividuSolidaireImplDao();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class IndividuSolidaireImplDao.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        IndividuSolidaireImplDao instance = new IndividuSolidaireImplDao();
        List<IndividuSolidaire> expResult = null;
        List<IndividuSolidaire> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class IndividuSolidaireImplDao.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        IndividuSolidaireImplDao instance = new IndividuSolidaireImplDao();
        IndividuSolidaire expResult = null;
        IndividuSolidaire result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmail method, of class IndividuSolidaireImplDao.
     */
    @Test
    public void testFindByEmail() {
        System.out.println("findByEmail");
        String email = "";
        IndividuSolidaireImplDao instance = new IndividuSolidaireImplDao();
        IndividuSolidaire expResult = null;
        IndividuSolidaire result = instance.findByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllProjet method, of class IndividuSolidaireImplDao.
     */
    @Test
    public void testFindAllProjet() {
        System.out.println("findAllProjet");
        IndividuSolidaireImplDao instance = new IndividuSolidaireImplDao();
        List<Projet> expResult = null;
        List<Projet> result = instance.findAllProjet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class IndividuSolidaireImplDao.
     */
    @Test
    public void testCreate_IndividuSolidaire_String() {
        System.out.println("create");
        IndividuSolidaire individu = null;
        String nomProjet = "";
        IndividuSolidaireImplDao instance = new IndividuSolidaireImplDao();
        boolean expResult = false;
        boolean result = instance.create(individu, nomProjet);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
