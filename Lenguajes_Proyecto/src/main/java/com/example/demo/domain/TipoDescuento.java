/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FIDE_TIPO_DESCUENTO_TB")
public class TipoDescuento implements Serializable {

    @Id
    @Column(name = "FIDE_TIPO_DESCUENTO_TB_ID_TIPO_DESCUENTO_PK")
    private String id;

    @Column(name = "ID_ESTADOS")
    private String idEstados;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEstados() {
        return idEstados;
    }

    public void setIdEstados(String idEstados) {
        this.idEstados = idEstados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
