/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FIDE_DESCUENTO_TB")
public class Descuento implements Serializable {

    @Id
    @Column(name = "FIDE_DESCUENTO_TB_ID_DESCUENTO_PK")
    private String id;

    @Column(name = "ID_ESTADOS")
    private String idEstados;

    @Column(name = "ID_TIPO_DESCUENTO", nullable = false)
    private String idTipoDescuento = "1"; // Valor predeterminado

    @Column(name = "VALOR")
    private Double valor;

    // Getters y Setters
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

    public String getIdTipoDescuento() {
        return idTipoDescuento;
    }

    public void setIdTipoDescuento(String idTipoDescuento) {
        if (idTipoDescuento == null || idTipoDescuento.isEmpty()) {
            this.idTipoDescuento = "1"; 
        } else {
            this.idTipoDescuento = idTipoDescuento;
        }
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
