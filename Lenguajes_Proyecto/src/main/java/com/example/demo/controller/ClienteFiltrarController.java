/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.service.ClienteFiltrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteFiltrarController {

    @Autowired
    private ClienteFiltrarService clienteFiltrarService;

    @GetMapping("/clientes/filtrar")
    public String filtrarClientes(
            @RequestParam(required = false) String nombre,
            Model model) {
        String resultado = "";
        if (nombre != null && !nombre.trim().isEmpty()) {
            resultado = clienteFiltrarService.filtrarClientesPorNombre(nombre);
        }
        model.addAttribute("resultado", resultado);
        model.addAttribute("nombre", nombre);
        return "clientes/filtrar";
    }
}
