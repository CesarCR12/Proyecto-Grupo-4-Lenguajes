/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "FIDE_PAIS_TB")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FIDE_PAIS_TB_ID_PAIS_PK", nullable = false, length = 200)
    private String idPais;

    @Column(name = "NOMBRE", nullable = false, length = 255)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADOS", referencedColumnName = "FIDE_ESTADOS_TB_ID_ESTADOS_PK")
    private Estado estado;
}
