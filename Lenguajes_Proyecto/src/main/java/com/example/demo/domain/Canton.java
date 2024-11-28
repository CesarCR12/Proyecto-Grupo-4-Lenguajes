/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FIDE_CANTON_TB")
public class Canton implements Serializable {

    @Id
    @Column(name = "FIDE_CANTON_TB_ID_CANTON_PK")
    private String cantonId;

    @Column(name = "NOMBRE")
    private String nombre;

    public String getCantonId() {
        return cantonId;
    }

    public void setCantonId(String cantonId) {
        this.cantonId = cantonId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
