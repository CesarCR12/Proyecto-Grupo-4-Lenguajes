/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface FacturasDetalleService {
    List<Map<String, Object>> obtenerFacturasPorCliente(String idCliente, String sortOrder);
}
