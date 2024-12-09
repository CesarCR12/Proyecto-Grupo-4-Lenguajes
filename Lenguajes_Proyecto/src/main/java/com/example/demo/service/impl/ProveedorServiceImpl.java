/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.ProveedorDao;
import com.example.demo.domain.Proveedor;
import com.example.demo.service.ProveedorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @PersistenceContext
    private EntityManager entityManager;

    private final ProveedorDao proveedorDao;

    public ProveedorServiceImpl(ProveedorDao proveedorDao) {
        this.proveedorDao = proveedorDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> getProveedores() {
        return entityManager.createQuery("SELECT p FROM Proveedor p", Proveedor.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor getProveedorById(String id) {
        return entityManager.find(Proveedor.class, id);
    }

    @Override
    @Transactional
    public void save(Proveedor proveedor) {
        if (proveedor.getProveedorId() == null || proveedor.getProveedorId().isEmpty()) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_PROVEEDORES_TB_INSERTAR_PROVEEDOR_SP");
            query.registerStoredProcedureParameter("P_ID_ESTADOS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_PAIS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_PROVINCIA", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_CANTON", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_DISTRITO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_DIRECCION", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_NOMBRE_PROVEEDOR", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_TELEFONO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_CORREO", String.class, ParameterMode.IN);

            query.setParameter("P_ID_ESTADOS", proveedor.getEstado());
            query.setParameter("P_ID_PAIS", proveedor.getPais().getPaisId());
            query.setParameter("P_ID_PROVINCIA", proveedor.getProvincia().getProvinciaId());
            query.setParameter("P_ID_CANTON", proveedor.getCanton().getCantonId());
            query.setParameter("P_ID_DISTRITO", proveedor.getDistrito().getDistritoId());
            query.setParameter("P_DIRECCION", proveedor.getDireccion());
            query.setParameter("P_NOMBRE_PROVEEDOR", proveedor.getNombreProveedor());
            query.setParameter("P_TELEFONO", proveedor.getTelefono());
            query.setParameter("P_CORREO", proveedor.getCorreo());

            query.execute();
        } else {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_PROVEEDORES_TB_ACTUALIZAR_SP");
            query.registerStoredProcedureParameter("P_ID_PROVEEDOR", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_DIRECCION", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_NOMBRE_PROVEEDOR", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_TELEFONO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_CORREO", String.class, ParameterMode.IN);

            query.setParameter("P_ID_PROVEEDOR", proveedor.getProveedorId());
            query.setParameter("P_DIRECCION", proveedor.getDireccion());
            query.setParameter("P_NOMBRE_PROVEEDOR", proveedor.getNombreProveedor());
            query.setParameter("P_TELEFONO", proveedor.getTelefono());
            query.setParameter("P_CORREO", proveedor.getCorreo());

            query.execute();
        }
    }

    @Override
    @Transactional
    public void deleteProveedorById(String id) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_PROVEEDORES_TB_ELIMINAR_SP");
        query.registerStoredProcedureParameter("P_ID_PROVEEDOR", String.class, ParameterMode.IN);
        query.setParameter("P_ID_PROVEEDOR", id);
        query.execute();
    }
}
