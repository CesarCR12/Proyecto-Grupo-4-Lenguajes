/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.FacturaClienteVista;
import com.example.demo.service.FacturaClienteVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FacturaClienteVistaController {

    @Autowired
    private FacturaClienteVistaService facturaClienteVistaService;

    @GetMapping("/facturas/clientes")
    public String mostrarFacturasClientes(
            @RequestParam(required = false) String filtroCliente,
            @RequestParam(defaultValue = "asc") String sortOrder,
            Model model) {
        
        List<FacturaClienteVista> facturas;

        if (filtroCliente != null && !filtroCliente.isEmpty()) {
            facturas = facturaClienteVistaService.obtenerFacturasPorCliente(filtroCliente, sortOrder);
        } else {
            facturas = facturaClienteVistaService.obtenerFacturasOrdenadas(sortOrder);
        }
        
        model.addAttribute("facturas", facturas);
        model.addAttribute("filtroCliente", filtroCliente);
        model.addAttribute("sortOrder", sortOrder);
        return "facturas/vista";
    }
}
