/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "FIDE_PALLETS_TB")
public class Pallet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIDE_PALLETS_TB_ID_PALLET_PK", updatable = false, nullable = false)
    private Long idPallet;

    @Column(name = "ID_PROVEEDORES")
    private String idProveedores;

    @Column(name = "ID_ESTADOS")
    private String idEstados;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CREADO_POR")
    private String creadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;

    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_MODIFICACION")
    private Date fechaModificacion;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "ACCION")
    private String accion;

    public Long getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(Long idPallet) {
        this.idPallet = idPallet;
    }

    public String getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(String idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getIdEstados() {
        return idEstados;
    }

    public void setIdEstados(String idEstados) {
        this.idEstados = idEstados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
