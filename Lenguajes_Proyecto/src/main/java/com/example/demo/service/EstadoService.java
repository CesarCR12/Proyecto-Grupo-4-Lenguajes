/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Estado;
import java.util.List;

public interface EstadoService {
    List<Estado> getAllEstados();
    Estado getEstadoById(String id);
}
