/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.FacturaClienteVista;
import com.example.demo.service.FacturaClienteVistaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaClienteVistaServiceImpl implements FacturaClienteVistaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<FacturaClienteVista> obtenerFacturasOrdenadas(String sortOrder) {
        String query = "SELECT f FROM FacturaClienteVista f ORDER BY "
                     + ("desc".equalsIgnoreCase(sortOrder) ? "f.idFactura DESC" : "f.idFactura ASC");
        return entityManager.createQuery(query, FacturaClienteVista.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<FacturaClienteVista> obtenerFacturasPorCliente(String filtroCliente, String sortOrder) {
        String query = "SELECT f FROM FacturaClienteVista f WHERE f.idCliente LIKE :filtroCliente "
                     + "ORDER BY " + ("desc".equalsIgnoreCase(sortOrder) ? "f.idFactura DESC" : "f.idFactura ASC");
        return entityManager.createQuery(query, FacturaClienteVista.class)
                .setParameter("filtroCliente", "%" + filtroCliente + "%")
                .getResultList();
    }
}
