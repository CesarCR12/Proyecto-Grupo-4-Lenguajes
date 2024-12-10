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
        try {
            if (inventario.getIdInventario() == null || inventario.getIdInventario().isEmpty()) {
                System.out.println("Guardando nuevo producto");
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_INVENTARIO_TB_REGISTRAR_SP");
                query.registerStoredProcedureParameter("P_ID_INVENTARIO", String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("P_ID_PALLET", String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("P_CANTIDAD", Integer.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("P_PRECIO", Double.class, ParameterMode.IN);
                query.setParameter("P_ID_INVENTARIO", inventario.getIdInventario());
                query.setParameter("P_ID_PALLET", inventario.getIdPallet());
                query.setParameter("P_NOMBRE", inventario.getNombre());
                query.setParameter("P_CANTIDAD", inventario.getCantidad());
                query.setParameter("P_PRECIO", inventario.getPrecio());
                query.execute();
                System.out.println("Producto guardado exitosamente");
            } else {
                System.out.println("Actualizando producto existente");
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_INVENTARIO_TB_ACTUALIZAR_SP");
                query.registerStoredProcedureParameter("P_ID_INVENTARIO", String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("P_ID_PALLET", String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("P_CANTIDAD", Integer.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("P_PRECIO", Double.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("P_ID_ESTADOS", String.class, ParameterMode.IN);
                query.setParameter("P_ID_INVENTARIO", inventario.getIdInventario());
                query.setParameter("P_ID_PALLET", inventario.getIdPallet());
                query.setParameter("P_NOMBRE", inventario.getNombre());
                query.setParameter("P_CANTIDAD", inventario.getCantidad());
                query.setParameter("P_PRECIO", inventario.getPrecio());
                query.setParameter("P_ID_ESTADOS", inventario.getIdEstados());

                query.execute();
                System.out.println("Producto actualizado exitosamente");
            }
        } catch (Exception e) {
            System.err.println("Error al guardar producto: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(Inventario inventario) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_INVENTARIO_TB_ELIMINAR_SP");
            query.registerStoredProcedureParameter("P_ID_INVENTARIO", String.class, ParameterMode.IN);
            query.setParameter("P_ID_INVENTARIO", inventario.getIdInventario());
            query.execute();
            System.out.println("Producto eliminado exitosamente");
        } catch (Exception e) {
            System.err.println("Error al eliminar producto: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void deleteById(String idInventario) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_INVENTARIO_TB_ELIMINAR_SP");
            query.registerStoredProcedureParameter("P_ID_INVENTARIO", String.class, ParameterMode.IN);
            query.setParameter("P_ID_INVENTARIO", idInventario);
            query.execute();
            System.out.println("Producto eliminado exitosamente por ID");
        } catch (Exception e) {
            System.err.println("Error al eliminar producto por ID: " + e.getMessage());
            throw e;
        }
    }
}