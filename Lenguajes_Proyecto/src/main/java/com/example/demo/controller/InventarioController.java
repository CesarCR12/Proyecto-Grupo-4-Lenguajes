/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Inventario;
import com.example.demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/listado")
    public String listarInventario(Model model) {

        List<Inventario> inventarios = inventarioService.getInventarios(true);
        model.addAttribute("inventarios", inventarios);
        return "inventario/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoInventario(Model model) {
        model.addAttribute("inventario", new Inventario());
        return "inventario/modifica";
    }

    @PostMapping("/guardar")
    public String guardarInventario(@ModelAttribute Inventario inventario) {
        inventarioService.save(inventario);
        return "redirect:/inventario/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificarInventario(@PathVariable("id") String id, Model model) {
        Inventario inventario = inventarioService.getInventario(new Inventario(id));
        if (inventario != null) {
            model.addAttribute("inventario", inventario);
            return "inventario/modifica";
        }
        return "redirect:/inventario/listado"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarInventario(@PathVariable("id") String id) {
        Inventario inventario = new Inventario();
        inventario.setIdInventario(id);
        inventarioService.delete(inventario);
        return "redirect:/inventario/listado";
    }
}
