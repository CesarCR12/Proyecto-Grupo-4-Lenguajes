/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Proveedor;
import java.util.List;

public interface ProveedorService {
    List<Proveedor> getProveedores(); 
    Proveedor getProveedorById(String id); 
    void save(Proveedor proveedor); 
    void deleteProveedorById(String id); 
}
