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

    // Relación con la tabla FIDE_PAIS_TB (Muchos a uno)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "FIDE_PAIS_TB_ID_PAIS_PK")
    private Pais pais;  // Objeto de tipo Pais

    @Column(name = "ID_PROVINCIA")
    private String provinciaId;

    @Column(name = "ID_CANTON")
    private String cantonId;

    @Column(name = "ID_DISTRITO")
    private String distritoId;

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

    // Constructor vacío
    public Clientes() {
    }

    // Constructor con ID del cliente
    public Clientes(String clienteId) {
        this.clienteId = clienteId;
    }

    // Getters y Setters
    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    // Getter y Setter para la relación con Pais
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    // Otros Getters y Setters
    public String getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(String provinciaId) {
        this.provinciaId = provinciaId;
    }

    public String getCantonId() {
        return cantonId;
    }

    public void setCantonId(String cantonId) {
        this.cantonId = cantonId;
    }

    public String getDistritoId() {
        return distritoId;
    }

    public void setDistritoId(String distritoId) {
        this.distritoId = distritoId;
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
