/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Clientes;
import com.example.demo.service.ClientesService;
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

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Clientes> clientes = clientesService.getClientes(false);
        model.addAttribute("clientes", clientes);
        return "clientes/listado";
    }

    @GetMapping("/nuevo")
    public String clientesNuevo(Model model) {
        model.addAttribute("cliente", new Clientes());
        return "clientes/modifica"; 
    }

    @PostMapping("/guardar")
    public String clientesGuardar(@ModelAttribute Clientes cliente) {
       
        if (cliente.getClienteId() != null && !cliente.getClienteId().isEmpty()) {
            Clientes clienteExistente = clientesService.getClientes(cliente);
            if (clienteExistente != null) {
                clienteExistente.setNombre(cliente.getNombre());
                clienteExistente.setCorreo(cliente.getCorreo());
                clienteExistente.setTelefono(cliente.getTelefono());
                clienteExistente.setDireccion(cliente.getDireccion());
                clientesService.save(clienteExistente);
            }
        } else {
           
            clientesService.save(cliente);
        }
        return "redirect:/clientes/listado";
    }

    @GetMapping("/modificar/{id}")
    public String clientesModificar(@PathVariable("id") String id, Model model) {
        Clientes cliente = clientesService.getClientes(new Clientes(id));
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
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
