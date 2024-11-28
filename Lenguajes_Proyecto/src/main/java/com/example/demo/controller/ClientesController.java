/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Clientes;
import com.example.demo.service.ClientesService;
import com.example.demo.service.PaisService; // Import del servicio de Países
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private PaisService paisService; // Inyección del servicio de Países

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Clientes> clientes = clientesService.getClientes(false);
        model.addAttribute("clientes", clientes);
        return "clientes/listado";
    }

    @GetMapping("/nuevo")
    public String clientesNuevo(Model model) {
        model.addAttribute("cliente", new Clientes());
        model.addAttribute("paises", paisService.getAllPaises()); // Añadir la lista de países al modelo
        return "clientes/modifica"; 
    }

    @PostMapping("/guardar")
    public String clientesGuardar(@ModelAttribute Clientes cliente) {
        clientesService.save(cliente);
        return "redirect:/clientes/listado";
    }

    @GetMapping("/modificar/{id}")
    public String clientesModificar(@PathVariable("id") String id, Model model) {
        Clientes cliente = clientesService.getClientes(new Clientes(id));
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            model.addAttribute("paises", paisService.getAllPaises()); // Añadir la lista de países al modelo también aquí
            return "clientes/modifica"; 
        }
        return "redirect:/clientes/listado"; 
    }

    @GetMapping("/eliminar/{id}")
    public String clientesEliminar(@PathVariable("id") String id) {
        Clientes cliente = new Clientes();
        cliente.setClienteId(id);
        clientesService.delete(cliente);
        return "redirect:/clientes/listado";
    }
}

