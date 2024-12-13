/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.PromocionVista;
import com.example.demo.service.PromocionVistaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromocionVistaServiceImpl implements PromocionVistaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<PromocionVista> obtenerPromocionesActivas() {
        return entityManager.createQuery("SELECT p FROM PromocionVista p", PromocionVista.class).getResultList();
    }
}
