/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.service.FacturasDetalleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class FacturasDetalleServiceImpl implements FacturasDetalleService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> obtenerFacturasPorCliente(String idCliente, String sortOrder) {
        String orderClause = "asc".equalsIgnoreCase(sortOrder) ? "ASC" : "DESC";

        return entityManager
                .createNativeQuery(
                        "SELECT ID_FACTURA, FECHA_VENTA, TOTAL_VENTA, SUBTOTAL, IMPUESTOS " +
                        "FROM TABLE(FIDE_FACTURAS_DETALLE_POR_CLIENTE_FN(:idCliente)) " +
                        "ORDER BY ID_FACTURA " + orderClause)
                .setParameter("idCliente", idCliente)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(org.hibernate.transform.AliasToEntityMapResultTransformer.INSTANCE)
                .getResultList();
    }
}
