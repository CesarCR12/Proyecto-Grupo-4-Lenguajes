/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.ClientesDao;
import com.example.demo.domain.Clientes;
import com.example.demo.service.ClientesService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> getClientes(boolean activos) {
        return entityManager.createQuery("SELECT c FROM Clientes c", Clientes.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes getClientes(Clientes cliente) {
        return entityManager.find(Clientes.class, cliente.getClienteId());
    }

    @Override
    @Transactional
    public void save(Clientes cliente) {
        if (cliente.getClienteId() == null || cliente.getClienteId().isEmpty()) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_CLIENTES_TB_INSERTAR_CLIENTE_SP");
            query.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_CORREO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_CONTRASEÑA", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_TELEFONO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_DIRECCION", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_PAIS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_PROVINCIA", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_CANTON", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_DISTRITO", String.class, ParameterMode.IN);
            query.setParameter("P_NOMBRE", cliente.getNombre());
            query.setParameter("P_CORREO", cliente.getCorreo());
            query.setParameter("P_CONTRASEÑA", "12345");
            query.setParameter("P_TELEFONO", cliente.getTelefono());
            query.setParameter("P_DIRECCION", cliente.getDireccion());
            query.setParameter("P_ID_PAIS", cliente.getPais().getPaisId());
            query.setParameter("P_ID_PROVINCIA", cliente.getProvincia().getProvinciaId());
            query.setParameter("P_ID_CANTON", cliente.getCanton().getCantonId());
            query.setParameter("P_ID_DISTRITO", cliente.getDistrito().getDistritoId());
            query.execute();
        } else {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_CLIENTES_TB_ACTUALIZAR_SP");
            query.registerStoredProcedureParameter("P_ID_CLIENTE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_NOMBRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_CORREO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_TELEFONO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_DIRECCION", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_PAIS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_PROVINCIA", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_CANTON", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("P_ID_DISTRITO", String.class, ParameterMode.IN);
            query.setParameter("P_ID_CLIENTE", cliente.getClienteId());
            query.setParameter("P_NOMBRE", cliente.getNombre());
            query.setParameter("P_CORREO", cliente.getCorreo());
            query.setParameter("P_TELEFONO", cliente.getTelefono());
            query.setParameter("P_DIRECCION", cliente.getDireccion());
            query.setParameter("P_ID_PAIS", cliente.getPais().getPaisId());
            query.setParameter("P_ID_PROVINCIA", cliente.getProvincia().getProvinciaId());
            query.setParameter("P_ID_CANTON", cliente.getCanton().getCantonId());
            query.setParameter("P_ID_DISTRITO", cliente.getDistrito().getDistritoId());
            query.execute();
        }
    }

    @Override
    @Transactional
    public void delete(Clientes cliente) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_CLIENTES_TB_ELIMINAR_SP");
        query.registerStoredProcedureParameter("P_ID_CLIENTE", String.class, ParameterMode.IN);
        query.setParameter("P_ID_CLIENTE", cliente.getClienteId());
        query.execute();
    }

    @Override
    @Transactional
    public void deleteById(String clienteId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_CLIENTES_TB_ELIMINAR_SP");
        query.registerStoredProcedureParameter("P_ID_CLIENTE", String.class, ParameterMode.IN);
        query.setParameter("P_ID_CLIENTE", clienteId);
        query.execute();
    }
}
