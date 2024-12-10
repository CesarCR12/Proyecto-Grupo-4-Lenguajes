/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Promocion;
import java.util.List;

public interface PromocionService {
    List<Promocion> getAllPromociones();
    Promocion getPromocionById(String id);
    void save(Promocion promocion);
    void update(Promocion promocion); 
    void deleteById(String id);
}
