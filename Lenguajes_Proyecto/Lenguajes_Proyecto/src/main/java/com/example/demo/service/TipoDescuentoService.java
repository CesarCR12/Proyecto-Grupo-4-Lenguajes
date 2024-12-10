/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.TipoDescuento;
import java.util.List;

public interface TipoDescuentoService {
    List<TipoDescuento> getAllTiposDescuento();
    TipoDescuento getTipoDescuentoById(String id);
    void save(TipoDescuento tipoDescuento);
    void update(TipoDescuento tipoDescuento);
    void deleteById(String id);
}
