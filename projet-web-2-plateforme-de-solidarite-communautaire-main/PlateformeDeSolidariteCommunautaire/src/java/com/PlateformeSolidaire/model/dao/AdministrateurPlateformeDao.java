/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PlateformeSolidaire.model.dao;

import com.PlateformeSolidaire.model.entities.AdministrateurPlateforme;
import java.util.List;

/**
 *
 * @author i5 4460 gtx 1060
 */
public interface AdministrateurPlateformeDao {
    public boolean create(AdministrateurPlateforme administrateurPlateforme);
    
    public boolean update(AdministrateurPlateforme administrateurPlateforme);
    
    public boolean delete(AdministrateurPlateforme administrateurPlateforme);
    
    public List<AdministrateurPlateforme> findAll();
    
    public AdministrateurPlateforme findById(int id);
    
    public AdministrateurPlateforme findByEmail(String email);
}
