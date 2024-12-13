/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.ProveedorContactoVista;
import com.example.demo.service.ProveedorContactosVistaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorContactosVistaServiceImpl implements ProveedorContactosVistaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<ProveedorContactoVista> obtenerProveedoresConContactos() {
        return entityManager.createQuery("SELECT p FROM ProveedorContactoVista p", ProveedorContactoVista.class)
                            .getResultList();
    }
}
