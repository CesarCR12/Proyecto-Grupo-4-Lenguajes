/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "FIDE_FACTURAS_TB")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIDE_FACTURAS_TB_ID_FACTURAS_PK", updatable = false, nullable = false)
    private String idFactura;

    @Column(name = "ID_CLIENTE")
    private String idCliente;

    @Column(name = "ID_PROMOCION")
    private String idPromocion;

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_VENTA")
    private Date fechaVenta;

    @Column(name = "TOTAL_VENTA")
    private Double totalVenta;

    @Column(name = "SUBTOTAL")
    private Double subtotal;

    @Column(name = "IMPUESTOS")
    private Double impuestos = 12.0; 

    @Transient
    private String idsInventario; 

    @Transient
    private String cantidades; 

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(String idPromocion) {
        this.idPromocion = idPromocion;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Double impuestos) {
        this.impuestos = impuestos;
    }

    public String getIdsInventario() {
        return idsInventario;
    }

    public void setIdsInventario(String idsInventario) {
        this.idsInventario = idsInventario;
    }

    public String getCantidades() {
        return cantidades;
    }

    public void setCantidades(String cantidades) {
        this.cantidades = cantidades;
    }
}
