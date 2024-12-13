/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.InventarioCantidadMinimaVista;
import com.example.demo.service.InventarioCantidadMinimaVistaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventarioCantidadMinimaVistaServiceImpl implements InventarioCantidadMinimaVistaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<InventarioCantidadMinimaVista> obtenerInventarioCantidadMinimaVista() {
        return entityManager.createQuery("SELECT i FROM InventarioCantidadMinimaVista i", InventarioCantidadMinimaVista.class)
                            .getResultList();
    }
}
