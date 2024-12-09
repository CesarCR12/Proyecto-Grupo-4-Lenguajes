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
        System.out.println("Listando inventarios...");
        List<Inventario> inventarios = inventarioService.getInventarios(true);
        model.addAttribute("inventarios", inventarios);
        return "inventario/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoInventario(Model model) {
        System.out.println("Creando un nuevo producto...");
        model.addAttribute("inventario", new Inventario());
        return "inventario/modifica";
    }

    @PostMapping("/guardar")
    public String guardarInventario(@ModelAttribute Inventario inventario) {
        System.out.println("Guardando producto...");
        System.out.println("Nombre: " + inventario.getNombre());
        System.out.println("Cantidad: " + inventario.getCantidad());
        System.out.println("Precio: " + inventario.getPrecio());
        System.out.println("ID Pallet: " + inventario.getIdPallet());
        
        inventarioService.save(inventario);
        return "redirect:/inventario/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificarInventario(@PathVariable("id") String id, Model model) {
        System.out.println("Modificando producto con ID: " + id);
        Inventario inventario = inventarioService.getInventario(new Inventario(id));
        if (inventario != null) {
            model.addAttribute("inventario", inventario);
            return "inventario/modifica";
        }
        System.out.println("Producto no encontrado, redirigiendo...");
        return "redirect:/inventario/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarInventario(@PathVariable("id") String id) {
        System.out.println("Eliminando producto con ID: " + id);
        Inventario inventario = new Inventario();
        inventario.setIdInventario(id);
        inventarioService.delete(inventario);
        return "redirect:/inventario/listado";
    }
}
