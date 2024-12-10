/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Descuento;
import com.example.demo.service.DescuentoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DescuentoServiceImpl implements DescuentoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Descuento> getAllDescuentos() {
        return entityManager.createQuery("SELECT d FROM Descuento d", Descuento.class).getResultList();
    }

    @Override
    public Descuento getDescuentoById(String id) {
        return entityManager.find(Descuento.class, id);
    }

    @Override
    @Transactional
    public void saveDescuento(Descuento descuento) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_DESCUENTO_TB_REGISTRAR_SP");
        
        query.registerStoredProcedureParameter("P_ID_DESCUENTO", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_TIPO_DESCUENTO", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_VALOR", Double.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter("P_ID_DESCUENTO", descuento.getId());
        query.setParameter("P_ID_TIPO_DESCUENTO", descuento.getIdTipoDescuento());
        query.setParameter("P_VALOR", descuento.getValor());

        query.execute();
    }

    @Override
    @Transactional
    public void updateDescuento(Descuento descuento) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_DESCUENTO_TB_MODIFICAR_SP");

        query.registerStoredProcedureParameter("P_ID_DESCUENTO", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_TIPO_DESCUENTO", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_VALOR", Double.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter("P_ID_DESCUENTO", descuento.getId());
        query.setParameter("P_ID_TIPO_DESCUENTO", descuento.getIdTipoDescuento());
        query.setParameter("P_VALOR", descuento.getValor());

        query.execute();
    }

    @Override
    @Transactional
    public void deleteDescuento(String id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_DESCUENTO_TB_ELIMINAR_SP");

        query.registerStoredProcedureParameter("P_ID_DESCUENTO", String.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter("P_ID_DESCUENTO", id);

        query.execute();
    }
}
