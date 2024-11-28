/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Inventario;
import java.util.List;

public interface InventarioService {

    List<Inventario> getInventarios(boolean activos);

    Inventario getInventario(Inventario inventario);

    void save(Inventario inventario);

    void delete(Inventario inventario);

    void deleteById(String idInventario);
}
