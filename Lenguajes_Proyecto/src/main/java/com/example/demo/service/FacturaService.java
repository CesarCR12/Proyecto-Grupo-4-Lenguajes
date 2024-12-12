/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Factura;

import java.util.List;

public interface FacturaService {

    List<Factura> obtenerTodasLasFacturas();
    Factura obtenerFacturaPorId(String id);
    void guardarFactura(Factura factura);
    void actualizarFactura(Factura factura);
    void eliminarFactura(String id);
    void agregarDescuentoAFactura(String idFactura, String idDescuento);
}
