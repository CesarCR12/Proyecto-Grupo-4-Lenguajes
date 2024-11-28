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
    private EntityManager entityManager;  // Inyectamos el EntityManager

    @Override
    public List<Pais> getAllPaises() {
        // Usamos el EntityManager para hacer una consulta directa a la base de datos
        String jpql = "SELECT p FROM Pais p";  // Consulta JPQL para obtener todos los países
        return entityManager.createQuery(jpql, Pais.class).getResultList();  // Ejecutamos la consulta
    }

    // Método adicional para obtener un país específico por su ID
    public Pais getPaisById(String paisId) {
        // Usamos el EntityManager para hacer la consulta de un país específico
        String jpql = "SELECT p FROM Pais p WHERE p.paisId = :paisId";
        return entityManager.createQuery(jpql, Pais.class)
                            .setParameter("paisId", paisId)  // Establecemos el valor del parámetro paisId
                            .getSingleResult();  // Debería devolver un solo resultado
    }
}


