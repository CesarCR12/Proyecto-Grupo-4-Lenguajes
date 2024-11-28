/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Inventario;
import com.example.demo.service.InventarioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Inventario> getInventarios(boolean activos) {
        return entityManager.createQuery("SELECT i FROM Inventario i", Inventario.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Inventario getInventario(Inventario inventario) {
        return entityManager.find(Inventario.class, inventario.getIdInventario());
    }

    @Override
    @Transactional
    public void save(Inventario inventario) {
        if (inventario.getIdInventario() == null || inventario.getIdInventario().isEmpty()) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_INVENTARIO_TB_REGISTRAR_SP");
            query.registerStoredProcedureParameter("V_ID_INVENTARIO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_PALLET", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_NOMBRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_CANTIDAD", Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_PRECIO", Double.class, ParameterMode.IN);

            query.setParameter("V_ID_INVENTARIO", inventario.getIdInventario());
            query.setParameter("V_ID_PALLET", inventario.getIdPallet());
            query.setParameter("V_NOMBRE", inventario.getNombre());
            query.setParameter("V_CANTIDAD", inventario.getCantidad());
            query.setParameter("V_PRECIO", inventario.getPrecio());

            query.execute();
        } else {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_INVENTARIO_TB_ACTUALIZAR_SP");
            query.registerStoredProcedureParameter("V_ID_INVENTARIO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_PALLET", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_NOMBRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_CANTIDAD", Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_PRECIO", Double.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_ESTADOS", String.class, ParameterMode.IN);
            query.setParameter("V_ID_INVENTARIO", inventario.getIdInventario());
            query.setParameter("V_ID_PALLET", inventario.getIdPallet());
            query.setParameter("V_NOMBRE", inventario.getNombre());
            query.setParameter("V_CANTIDAD", inventario.getCantidad());
            query.setParameter("V_PRECIO", inventario.getPrecio());
            query.setParameter("V_ID_ESTADOS", inventario.getIdEstados());

            query.execute();
        }
    }

    @Override
    @Transactional
    public void delete(Inventario inventario) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_INVENTARIO_TB_ELIMINAR_SP");
        query.registerStoredProcedureParameter("V_ID_INVENTARIO", String.class, ParameterMode.IN);
        query.setParameter("V_ID_INVENTARIO", inventario.getIdInventario());
        query.execute();
    }

    @Override
    @Transactional
    public void deleteById(String idInventario) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_INVENTARIO_TB_ELIMINAR_SP");
        query.registerStoredProcedureParameter("V_ID_INVENTARIO", String.class, ParameterMode.IN);
        query.setParameter("V_ID_INVENTARIO", idInventario);
        query.execute();
    }
}
