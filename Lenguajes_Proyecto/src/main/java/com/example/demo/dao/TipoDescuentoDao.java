/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.dao;

import com.example.demo.domain.TipoDescuento;
import java.util.List;

public interface TipoDescuentoDao {
    List<TipoDescuento> findAll();
    TipoDescuento findById(String id);
    void save(TipoDescuento tipoDescuento);
    void update(TipoDescuento tipoDescuento);
    void deleteById(String id);
}
