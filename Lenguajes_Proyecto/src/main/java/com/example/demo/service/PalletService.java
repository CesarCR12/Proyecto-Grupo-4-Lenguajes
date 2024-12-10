/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Pallet;
import java.util.List;

public interface PalletService {
    List<Pallet> obtenerTodosLosPallets(); 
    Pallet obtenerPalletPorId(Long id); 
    void guardarPallet(Pallet pallet); 
    void actualizarPallet(Pallet pallet); 
    void eliminarPallet(Long id);
}
