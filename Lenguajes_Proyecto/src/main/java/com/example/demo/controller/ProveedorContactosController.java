/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.ProveedorContactoVista;
import com.example.demo.service.ProveedorContactosVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProveedorContactosController {

    @Autowired
    private ProveedorContactosVistaService proveedorContactosVistaService;

    @GetMapping("/proveedores/contactos")
    public String mostrarProveedoresConContactos(Model model) {
        List<ProveedorContactoVista> proveedores = proveedorContactosVistaService.obtenerProveedoresConContactos();
        model.addAttribute("proveedores", proveedores);
        return "proveedores/contactos";
    }
}
