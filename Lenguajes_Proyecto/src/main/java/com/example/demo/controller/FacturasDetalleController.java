/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.service.FacturasDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class FacturasDetalleController {

    @Autowired
    private FacturasDetalleService facturasDetalleService;

    @GetMapping("/facturas/vista")
    public String mostrarVistaGeneral(Model model) {
        return "facturas/vista-general"; 
    }

    @GetMapping("/facturas/detalle")
    public String mostrarDetalleFacturas(
        @RequestParam(required = false) String idCliente, 
        @RequestParam(defaultValue = "asc") String sortOrder,
        Model model
    ) {
        if (idCliente == null || idCliente.isEmpty()) {
            model.addAttribute("error", "Por favor, proporciona un ID de cliente.");
            return "facturas/detalle"; 
        }

        try {
            List<Map<String, Object>> facturas = facturasDetalleService.obtenerFacturasPorCliente(idCliente, sortOrder);

            model.addAttribute("facturas", facturas);
            model.addAttribute("idCliente", idCliente);
            model.addAttribute("sortOrder", sortOrder);
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al consultar las facturas: " + e.getMessage());
        }

        return "facturas/detalle"; 
    }
}
