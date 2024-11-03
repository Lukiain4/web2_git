/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PlateformeSolidaire.model.dao;

import com.PlateformeSolidaire.model.entities.Association;
import java.util.List;

/**
 *
 * @author i5 4460 gtx 1060
 */
public interface AssociationDao {
    public boolean create(Association association);
    
    public boolean update(Association association);
    
    public boolean delete(Association association);
    
    public List<Association> findAll();
    
    public Association findById(int id);
    
    public Association findByName(String nomAssociation);
}
