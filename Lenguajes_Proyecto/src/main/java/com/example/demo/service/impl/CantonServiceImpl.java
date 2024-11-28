/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Canton;
import com.example.demo.service.CantonService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantonServiceImpl implements CantonService {

    @PersistenceContext
    private EntityManager entityManager; 

    @Override
    public List<Canton> getAllCantones() {
        String jpql = "SELECT p FROM Canton p";  
        return entityManager.createQuery(jpql, Canton.class).getResultList();  
    }

    public Canton getCantonById(String CantonId) {
        String jpql = "SELECT p FROM Canton p WHERE p.CantonId = :CantonId";
        return entityManager.createQuery(jpql, Canton.class)
                            .setParameter("CantonId", CantonId)  
                            .getSingleResult(); 
    }
}