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
            query.registerStoredProcedureParameter("V_NOMBRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_CORREO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_CONTRASEÑA", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_TELEFONO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_DIRECCION", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_PAIS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_PROVINCIA", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_CANTON", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_DISTRITO", String.class, ParameterMode.IN);
            query.setParameter("V_NOMBRE", cliente.getNombre());
            query.setParameter("V_CORREO", cliente.getCorreo());
            query.setParameter("V_CONTRASEÑA", "12345");
            query.setParameter("V_TELEFONO", cliente.getTelefono());
            query.setParameter("V_DIRECCION", cliente.getDireccion());
            query.setParameter("V_ID_PAIS", cliente.getPais().getPaisId());
            query.setParameter("V_ID_PROVINCIA", cliente.getProvincia().getProvinciaId());
            query.setParameter("V_ID_CANTON", cliente.getCanton().getCantonId());
            query.setParameter("V_ID_DISTRITO", cliente.getDistrito().getDistritoId());
            query.execute();
        } else {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_CLIENTES_TB_ACTUALIZAR_SP");
            query.registerStoredProcedureParameter("V_ID_CLIENTE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_NOMBRE", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_CORREO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_TELEFONO", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_DIRECCION", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_PAIS", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_PROVINCIA", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_CANTON", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("V_ID_DISTRITO", String.class, ParameterMode.IN);
            query.setParameter("V_ID_CLIENTE", cliente.getClienteId());
            query.setParameter("V_NOMBRE", cliente.getNombre());
            query.setParameter("V_CORREO", cliente.getCorreo());
            query.setParameter("V_TELEFONO", cliente.getTelefono());
            query.setParameter("V_DIRECCION", cliente.getDireccion());
            query.setParameter("V_ID_PAIS", cliente.getPais().getPaisId());
            query.setParameter("V_ID_PROVINCIA", cliente.getProvincia().getProvinciaId());
            query.setParameter("V_ID_CANTON", cliente.getCanton().getCantonId());
            query.setParameter("V_ID_DISTRITO", cliente.getDistrito().getDistritoId());
            query.execute();
        }
    }

    @Override
    @Transactional
    public void delete(Clientes cliente) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_CLIENTES_TB_ELIMINAR_SP");
        query.registerStoredProcedureParameter("V_ID_CLIENTE", String.class, ParameterMode.IN);
        query.setParameter("V_ID_CLIENTE", cliente.getClienteId());
        query.execute();
    }

    @Override
    @Transactional
    public void deleteById(String clienteId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_CLIENTES_TB_ELIMINAR_SP");
        query.registerStoredProcedureParameter("V_ID_CLIENTE", String.class, ParameterMode.IN);
        query.setParameter("V_ID_CLIENTE", clienteId);
        query.execute();
    }
}
