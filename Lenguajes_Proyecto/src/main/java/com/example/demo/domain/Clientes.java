/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FIDE_CLIENTES_TB")
public class Clientes implements Serializable {

    @Id
    @Column(name = "FIDE_CLIENTES_TB_ID_CLIENTE_PK")
    private String clienteId;

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

    @Column(name = "ID_ESTADOS")
    private String estadoId;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "TELEFONO")
    private String telefono;

    public Clientes() {
    }

    public Clientes(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
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

    public String getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(String estadoId) {
        this.estadoId = estadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
