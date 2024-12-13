/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.ClienteVista;
import com.example.demo.service.ClienteVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClienteVistaController {

    @Autowired
    private ClienteVistaService clienteVistaService;

    @GetMapping("/clientes/vista")
    public String mostrarClientesVista(Model model) {
        List<ClienteVista> clientesVista = clienteVistaService.obtenerClientesVista();
        model.addAttribute("clientesVista", clientesVista);
        return "clientes/vista";
    }
}
