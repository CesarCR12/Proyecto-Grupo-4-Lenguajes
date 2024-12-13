/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.service.InventarioCantidadService;
import com.example.demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InventarioCantidadController {

    @Autowired
    private InventarioCantidadService inventarioCantidadService;

    @GetMapping("/inventario/cantidad")
    public String mostrarFormularioCantidad() {
        return "inventario/cantidad"; 
    }

    @GetMapping("/inventario/cantidad-consultar")
    public String consultarCantidad(
        @RequestParam String nombre,
        Model model
    ) {
        int cantidad = inventarioCantidadService.obtenerCantidadPorNombre(nombre);
        model.addAttribute("nombre", nombre);
        model.addAttribute("cantidad", cantidad);
        return "inventario/cantidad"; 
    }

}
