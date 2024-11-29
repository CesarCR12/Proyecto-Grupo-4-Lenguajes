/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Distrito;
import com.example.demo.service.DistritoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService {

    @PersistenceContext
    private EntityManager entityManager;  

    @Override
    public List<Distrito> getAllDistritos() {

        String jpql = "SELECT p FROM Distrito p";  
        return entityManager.createQuery(jpql, Distrito.class).getResultList();  
    }

    public Distrito getDistritoById(String distritoId) {
        String jpql = "SELECT p FROM Distrito p WHERE p.distritoId = :distritoId";
        return entityManager.createQuery(jpql, Distrito.class)
                            .setParameter("distritoId", distritoId)  
                            .getSingleResult(); 
    }
}