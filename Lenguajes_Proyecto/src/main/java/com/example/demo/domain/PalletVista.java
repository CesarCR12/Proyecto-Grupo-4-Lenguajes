/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FIDE_PALLETS_V")
public class PalletVista {

    @Id
    private String idPallet;

    private String idProveedores;

    private String idEstados;

    private String descripcion;

    public PalletVista() {}

    public String getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(String idPallet) {
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
}
