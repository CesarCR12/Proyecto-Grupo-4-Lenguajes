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
@Table(name = "FIDE_ESTADOS_TB")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FIDE_ESTADOS_TB_ID_ESTADOS_PK", nullable = false, length = 200)
    private String idEstado;

    @Column(name = "DESCRIPCION", nullable = false, length = 255)
    private String descripcion;
}
