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
    private EntityManager entityManager;  // Inyectamos el EntityManager

    @Override
    public List<Distrito> getAllDistritos() {
        // Usamos el EntityManager para hacer una consulta directa a la base de datos
        String jpql = "SELECT p FROM Distrito p";  // Consulta JPQL para obtener todos los países
        return entityManager.createQuery(jpql, Distrito.class).getResultList();  // Ejecutamos la consulta
    }

    // Método adicional para obtener un país específico por su ID
    public Distrito getDistritoById(String distritoId) {
        // Usamos el EntityManager para hacer la consulta de un país específico
        String jpql = "SELECT p FROM Distrito p WHERE p.distritoId = :distritoId";
        return entityManager.createQuery(jpql, Distrito.class)
                            .setParameter("distritoId", distritoId)  // Establecemos el valor del parámetro paisId
                            .getSingleResult();  // Debería devolver un solo resultado
    }
}