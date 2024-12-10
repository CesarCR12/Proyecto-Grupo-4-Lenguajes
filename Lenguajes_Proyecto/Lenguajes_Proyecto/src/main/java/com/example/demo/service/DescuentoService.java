/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Descuento;
import java.util.List;

public interface DescuentoService {
    List<Descuento> getAllDescuentos(); 
    Descuento getDescuentoById(String id);
    void saveDescuento(Descuento descuento);
    void updateDescuento(Descuento descuento);
    void deleteDescuento(String id); 
}
