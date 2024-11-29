/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Pais;
import com.example.demo.service.PaisService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @PersistenceContext
    private EntityManager entityManager;  

    @Override
    public List<Pais> getAllPaises() {
        String jpql = "SELECT p FROM Pais p";  
        return entityManager.createQuery(jpql, Pais.class).getResultList();  
    }

    public Pais getPaisById(String paisId) {
        String jpql = "SELECT p FROM Pais p WHERE p.paisId = :paisId";
        return entityManager.createQuery(jpql, Pais.class)
                            .setParameter("paisId", paisId)  
                            .getSingleResult();  
    }
}


