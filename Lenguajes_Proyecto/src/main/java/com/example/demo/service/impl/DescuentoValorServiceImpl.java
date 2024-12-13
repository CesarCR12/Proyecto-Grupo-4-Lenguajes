/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.service.DescuentoValorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DescuentoValorServiceImpl implements DescuentoValorService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public double obtenerValorDescuento(String idDescuento) {
        try {
            Number resultado = (Number) entityManager
                    .createNativeQuery("SELECT FIDE_GET_VALOR_DESCUENTO(:idDescuento) FROM DUAL")
                    .setParameter("idDescuento", idDescuento)
                    .getSingleResult();

            return resultado != null ? resultado.doubleValue() : -1; 
        } catch (Exception e) {
            e.printStackTrace();
            return -2; 
        }
    }
}
