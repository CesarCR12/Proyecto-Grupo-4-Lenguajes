/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.service.PromocionNombreService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PromocionNombreServiceImpl implements PromocionNombreService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public String obtenerNombrePromocion(String idPromocion) {
        try {
            String resultado = (String) entityManager
                    .createNativeQuery("SELECT FIDE_GET_NOMBRE_PROMOCION(:idPromocion) FROM DUAL")
                    .setParameter("idPromocion", idPromocion)
                    .getSingleResult();
            System.out.println("Resultado obtenido: " + resultado);
            return resultado;
        } catch (Exception e) {
            e.printStackTrace(); 
            return "ERROR AL OBTENER LA PROMOCIÓN";
        }
    }
}
