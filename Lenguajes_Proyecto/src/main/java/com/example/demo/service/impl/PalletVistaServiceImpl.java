/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.PalletVista;
import com.example.demo.service.PalletVistaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PalletVistaServiceImpl implements PalletVistaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<PalletVista> obtenerPalletsPorEstado(String idEstados) {
        return entityManager.createQuery(
                "SELECT p FROM PalletVista p WHERE p.idEstados = :idEstados", PalletVista.class)
                .setParameter("idEstados", idEstados)
                .getResultList();
    }
}
