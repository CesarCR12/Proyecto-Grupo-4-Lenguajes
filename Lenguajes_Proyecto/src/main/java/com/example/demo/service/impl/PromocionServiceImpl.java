/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Promocion;
import com.example.demo.service.PromocionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromocionServiceImpl implements PromocionService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Promocion> getAllPromociones() {
        return entityManager.createQuery("SELECT p FROM Promocion p", Promocion.class).getResultList();
    }

    @Override
    public Promocion getPromocionById(String id) {
        return entityManager.find(Promocion.class, id);
    }

    @Override
    @Transactional
    public void save(Promocion promocion) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_PROMOCIONES_TB_REGISTRAR_SP");

        query.registerStoredProcedureParameter("P_ID_PROMOCION", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_FACTURA", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_NOMBRE_PROMOCION", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_FECHA_INICIO", java.sql.Date.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_FECHA_FIN", java.sql.Date.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_DESCRIPCION", String.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter("P_ID_PROMOCION", promocion.getPromocionId());
        query.setParameter("P_ID_FACTURA", promocion.getFacturaId());
        query.setParameter("P_NOMBRE_PROMOCION", promocion.getNombrePromocion());
        query.setParameter("P_FECHA_INICIO", new java.sql.Date(promocion.getFechaInicio().getTime()));
        query.setParameter("P_FECHA_FIN", new java.sql.Date(promocion.getFechaFin().getTime()));
        query.setParameter("P_DESCRIPCION", promocion.getDescripcion());

        query.execute();
    }

    @Override
    @Transactional
    public void update(Promocion promocion) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_PROMOCIONES_TB_MODIFICAR_SP");

        query.registerStoredProcedureParameter("P_ID_PROMOCION", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_NOMBRE_PROMOCION", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_FECHA_INICIO", java.sql.Date.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_FECHA_FIN", java.sql.Date.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_DESCRIPCION", String.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter("P_ID_PROMOCION", promocion.getPromocionId());
        query.setParameter("P_NOMBRE_PROMOCION", promocion.getNombrePromocion());
        query.setParameter("P_FECHA_INICIO", new java.sql.Date(promocion.getFechaInicio().getTime()));
        query.setParameter("P_FECHA_FIN", new java.sql.Date(promocion.getFechaFin().getTime()));
        query.setParameter("P_DESCRIPCION", promocion.getDescripcion());

        query.execute();
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_PROMOCIONES_TB_ELIMINAR_SP");

        query.registerStoredProcedureParameter("P_ID_PROMOCION", String.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter("P_ID_PROMOCION", id);

        query.execute();
    }
}
