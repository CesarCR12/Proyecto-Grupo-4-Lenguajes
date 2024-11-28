/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FIDE_DISTRITO_TB")
public class Distrito implements Serializable {

    @Id
    @Column(name = "FIDE_DISTRITO_TB_ID_DISTRITO_PK")
    private String distritoId;

    @Column(name = "NOMBRE")
    private String nombre;

    public String getDistritoId() {
        return distritoId;
    }

    public void setPaisId(String distritoId) {
        this.distritoId = distritoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
