/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.service.ClienteFiltrarService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteFiltrarServiceImpl implements ClienteFiltrarService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public String filtrarClientesPorNombre(String nombre) {
        try {
            String query = "SELECT FIDE_CLIENTES_TB_FILTRAR_CLIENTES_FN(:nombre) FROM DUAL";
            return (String) entityManager.createNativeQuery(query)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (Exception e) {
            return "Ocurrió un error al ejecutar la función: " + e.getMessage();
        }
    }
}
