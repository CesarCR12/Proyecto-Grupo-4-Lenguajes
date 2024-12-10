/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Provincia;
import com.example.demo.service.ProvinciaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    @PersistenceContext
    private EntityManager entityManager; 

    @Override
    public List<Provincia> getAllProvincias() {
        String jpql = "SELECT p FROM Provincia p";  
        return entityManager.createQuery(jpql, Provincia.class).getResultList();  
    }

    public Provincia getProvinciaById(String ProvinciaId) {
        String jpql = "SELECT p FROM Provincia p WHERE p.ProvinciaId = :ProvinciaId";
        return entityManager.createQuery(jpql, Provincia.class)
                            .setParameter("ProvinciaId", ProvinciaId)  
                            .getSingleResult(); 
    }
}
