/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.service.ProveedorNombreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProveedorNombreController {

    @Autowired
    private ProveedorNombreService proveedorNombreService;

    @GetMapping("/proveedores/nombre")
    public String obtenerNombreProveedor(
        @RequestParam(value = "idProveedor", required = false) String idProveedor, 
        Model model
    ) {
        if (idProveedor == null || idProveedor.isEmpty()) {
            model.addAttribute("error", "El parámetro 'idProveedor' es obligatorio.");
            return "proveedores/nombre";
        }
        
        String nombreProveedor = proveedorNombreService.obtenerNombreProveedor(idProveedor);
        model.addAttribute("idProveedor", idProveedor);
        model.addAttribute("nombreProveedor", nombreProveedor);
        return "proveedores/nombre"; 
    }
}
