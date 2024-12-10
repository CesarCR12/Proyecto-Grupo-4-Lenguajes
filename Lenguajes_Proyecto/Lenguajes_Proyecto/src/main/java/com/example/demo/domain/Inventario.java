/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FIDE_INVENTARIO_TB")
public class Inventario implements Serializable {

    @Id
    @Column(name = "FIDE_INVENTARIO_TB_ID_INVENTARIO_PK")
    private String idInventario;

    @Column(name = "ID_PALLET")
    private String idPallet;

    @Column(name = "ID_ESTADOS")
    private String idEstados;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "PRECIO")
    private Double precio;

    public Inventario() {
    }

    public Inventario(String idInventario) {
        this.idInventario = idInventario;
    }

    public String getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(String idInventario) {
        this.idInventario = idInventario;
    }

    public String getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(String idPallet) {
        this.idPallet = idPallet;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
