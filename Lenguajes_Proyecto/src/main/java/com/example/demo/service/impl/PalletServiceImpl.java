/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Pallet;
import com.example.demo.service.PalletService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PalletServiceImpl implements PalletService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pallet> obtenerTodosLosPallets() {
        return entityManager.createQuery("SELECT p FROM Pallet p", Pallet.class).getResultList();
    }

    @Override
    public Pallet obtenerPalletPorId(Long id) {
        return entityManager.find(Pallet.class, id);
    }

    @Override
    @Transactional
    public void guardarPallet(Pallet pallet) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_PALLETS_TB_INSERTAR_SP");

        query.registerStoredProcedureParameter("P_ID_PROVEEDORES", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_ESTADOS", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_DESCRIPCION", String.class, jakarta.persistence.ParameterMode.IN);

    if (pallet.getIdProveedores() == null || pallet.getIdProveedores().isEmpty()) {
        throw new IllegalArgumentException("El campo 'ID_PROVEEDORES' no puede estar vacío.");
    }

        query.setParameter("P_ID_PROVEEDORES", pallet.getIdProveedores());
        query.setParameter("P_ID_ESTADOS", pallet.getIdEstados());
        query.setParameter("P_DESCRIPCION", pallet.getDescripcion());

        query.execute();
}


    @Override
    @Transactional
    public void actualizarPallet(Pallet pallet) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_PALLETS_TB_ACTUALIZAR_SP");
        query.registerStoredProcedureParameter("P_ID_PALLET", Long.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_PROVEEDORES", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_ESTADOS", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_DESCRIPCION", String.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter("P_ID_PALLET", pallet.getIdPallet());
        query.setParameter("P_ID_PROVEEDORES", pallet.getIdProveedores());
        query.setParameter("P_ID_ESTADOS", pallet.getIdEstados());
        query.setParameter("P_DESCRIPCION", pallet.getDescripcion());

        query.execute();
    }

    @Override
    @Transactional
    public void eliminarPallet(Long id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_PALLETS_TB_ELIMINAR_SP");
        query.registerStoredProcedureParameter("P_ID_PALLET", Long.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter("P_ID_PALLET", id);

        query.execute();
    }
}
