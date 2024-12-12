/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Descuento;
import com.example.demo.domain.Factura;
import com.example.demo.service.FacturaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Factura> obtenerTodasLasFacturas() {
        return entityManager.createQuery("SELECT f FROM Factura f", Factura.class).getResultList();
    }

    @Override
    public Factura obtenerFacturaPorId(String id) {
        return entityManager.find(Factura.class, id);
    }

    @Override
    @Transactional
    public void guardarFactura(Factura factura) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_FACTURAS_TB_REGISTRAR_SP");

        query.registerStoredProcedureParameter("P_ID_FACTURA", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_CLIENTE", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_PROMOCION", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_FECHA_VENTA", java.sql.Date.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_IMPUESTOS", Double.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_IDS_INVENTARIO", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_CANTIDADES", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_DESCUENTO", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_TOTAL_VENTA", Double.class, jakarta.persistence.ParameterMode.OUT);

        query.setParameter("P_ID_FACTURA", factura.getIdFactura());
        query.setParameter("P_ID_CLIENTE", factura.getIdCliente());
        query.setParameter("P_ID_PROMOCION", factura.getIdPromocion());
        query.setParameter("P_FECHA_VENTA", new java.sql.Date(factura.getFechaVenta().getTime()));
        query.setParameter("P_IMPUESTOS", factura.getImpuestos());
        query.setParameter("P_IDS_INVENTARIO", factura.getIdsInventario().trim());
        query.setParameter("P_CANTIDADES", factura.getCantidades().trim());

        query.setParameter("P_ID_DESCUENTO", (factura.getDescuento() != null) ? factura.getDescuento().getId() : null);

        query.execute();

        factura.setTotalVenta((Double) query.getOutputParameterValue("P_TOTAL_VENTA"));
    }

    @Override
    @Transactional
    public void actualizarFactura(Factura factura) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_FACTURAS_TB_MODIFICAR_SP");

        query.registerStoredProcedureParameter("P_ID_FACTURA", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_CLIENTE", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_PROMOCION", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_FECHA_VENTA", java.sql.Date.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_IMPUESTOS", Double.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_IDS_INVENTARIO", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_CANTIDADES", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_ID_DESCUENTO", String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter("P_TOTAL_VENTA", Double.class, jakarta.persistence.ParameterMode.OUT);

        query.setParameter("P_ID_FACTURA", factura.getIdFactura());
        query.setParameter("P_ID_CLIENTE", factura.getIdCliente());
        query.setParameter("P_ID_PROMOCION", factura.getIdPromocion());
        query.setParameter("P_FECHA_VENTA", new java.sql.Date(factura.getFechaVenta().getTime()));
        query.setParameter("P_IMPUESTOS", factura.getImpuestos());
        query.setParameter("P_IDS_INVENTARIO", factura.getIdsInventario().trim());
        query.setParameter("P_CANTIDADES", factura.getCantidades().trim());
        query.setParameter("P_ID_DESCUENTO", (factura.getDescuento() != null) ? factura.getDescuento().getId() : null);

        query.execute();

        factura.setTotalVenta((Double) query.getOutputParameterValue("P_TOTAL_VENTA"));
    }

    @Override
    @Transactional
    public void eliminarFactura(String id) {
        Factura factura = obtenerFacturaPorId(id);
        if (factura != null) {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("FIDE_FACTURAS_TB_ELIMINAR_SP");

            query.registerStoredProcedureParameter("P_ID_FACTURA", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("P_IDS_INVENTARIO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("P_CANTIDADES", String.class, jakarta.persistence.ParameterMode.IN);

            query.setParameter("P_ID_FACTURA", id);
            query.setParameter("P_IDS_INVENTARIO", factura.getIdsInventario().trim());
            query.setParameter("P_CANTIDADES", factura.getCantidades().trim());

            query.execute();
        }
    }

    @Override
    @Transactional
    public void agregarDescuentoAFactura(String idFactura, String idDescuento) {
        Factura factura = obtenerFacturaPorId(idFactura);
        Descuento descuento = entityManager.find(Descuento.class, idDescuento);

        if (factura != null && descuento != null) {
            factura.setDescuento(descuento);
            entityManager.merge(factura);
        } else {
            throw new IllegalArgumentException("Factura o Descuento no encontrados.");
        }
    }
}
