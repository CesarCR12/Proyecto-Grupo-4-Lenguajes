/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.service.ProveedorNombreService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProveedorNombreServiceImpl implements ProveedorNombreService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public String obtenerNombreProveedor(String idProveedor) {
        try {
            return (String) entityManager
                    .createNativeQuery("SELECT FIDE_GET_NOMBRE_PROVEEDOR(:idProveedor) FROM DUAL")
                    .setParameter("idProveedor", idProveedor)
                    .getSingleResult();
        } catch (Exception e) {
            return "ERROR AL OBTENER EL PROVEEDOR";
        }
    }
}
