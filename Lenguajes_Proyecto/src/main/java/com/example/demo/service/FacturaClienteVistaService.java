/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.FacturaClienteVista;
import java.util.List;

public interface FacturaClienteVistaService {
    List<FacturaClienteVista> obtenerFacturasOrdenadas(String sortOrder);
    List<FacturaClienteVista> obtenerFacturasPorCliente(String filtroCliente, String sortOrder);
}