/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "FIDE_PROVEEDORES_TB")
public class Proveedor implements Serializable {

    @Id
    @Column(name = "FIDE_PROVEEDORES_TB_ID_PROVEEDORES_PK")
    private String proveedorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTADOS", referencedColumnName = "FIDE_ESTADOS_TB_ID_ESTADOS_PK")
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "FIDE_PAIS_TB_ID_PAIS_PK")
    private Pais pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "FIDE_PROVINCIA_TB_ID_PROVINCIA_PK")
    private Provincia provincia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CANTON", referencedColumnName = "FIDE_CANTON_TB_ID_CANTON_PK")
    private Canton canton;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DISTRITO", referencedColumnName = "FIDE_DISTRITO_TB_ID_DISTRITO_PK")
    private Distrito distrito;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "CREADO_POR")
    private String creadoPor;

    @Column(name = "FECHA_CREACION")
    private Timestamp fechaCreacion;

    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;

    @Column(name = "FECHA_MODIFICACION")
    private Timestamp fechaModificacion;

    @Column(name = "ESTADO")
    private String estadoProveedor;

    @Column(name = "ACCION")
    private String accion;

    public Proveedor() {
    }

    public Proveedor(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstadoProveedor() {
        return estadoProveedor;
    }

    public void setEstadoProveedor(String estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
