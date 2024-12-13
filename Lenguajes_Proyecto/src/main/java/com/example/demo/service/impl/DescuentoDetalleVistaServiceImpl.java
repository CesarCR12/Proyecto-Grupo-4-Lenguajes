/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.DescuentoDetalleVista;
import com.example.demo.service.DescuentoDetalleVistaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DescuentoDetalleVistaServiceImpl implements DescuentoDetalleVistaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<DescuentoDetalleVista> obtenerDescuentosOrdenados(String sortOrder) {
        String query = "SELECT d FROM DescuentoDetalleVista d ORDER BY d.valorDescuento " 
            + ("desc".equalsIgnoreCase(sortOrder) ? "DESC" : "ASC");
        return entityManager.createQuery(query, DescuentoDetalleVista.class).getResultList();
    }
}

