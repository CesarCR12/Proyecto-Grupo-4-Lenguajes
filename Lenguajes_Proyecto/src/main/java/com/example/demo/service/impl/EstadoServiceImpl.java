/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Estado;
import com.example.demo.service.EstadoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Estado> getAllEstados() {
        return entityManager.createQuery("SELECT e FROM Estado e", Estado.class).getResultList();
    }

    @Override
    public Estado getEstadoById(String id) {
        return entityManager.find(Estado.class, id);
    }
}
