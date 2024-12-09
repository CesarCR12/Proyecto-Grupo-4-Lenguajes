/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Proveedor;
import com.example.demo.service.ProveedorService;
import com.example.demo.service.PaisService;
import com.example.demo.service.ProvinciaService;
import com.example.demo.service.CantonService;
import com.example.demo.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private PaisService paisService;

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private CantonService cantonService;

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("proveedores", proveedorService.getProveedores());
        return "proveedores/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("paises", paisService.getAllPaises());
        model.addAttribute("provincias", provinciaService.getAllProvincias());
        model.addAttribute("cantones", cantonService.getAllCantones());
        model.addAttribute("distritos", distritoService.getAllDistritos());
        return "proveedores/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedores/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") String id, Model model) {
        Proveedor proveedor = proveedorService.getProveedorById(id);
        if (proveedor != null) {
            model.addAttribute("proveedor", proveedor);
            model.addAttribute("paises", paisService.getAllPaises());
            model.addAttribute("provincias", provinciaService.getAllProvincias());
            model.addAttribute("cantones", cantonService.getAllCantones());
            model.addAttribute("distritos", distritoService.getAllDistritos());
            return "proveedores/modifica";
        }
        return "redirect:/proveedores/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id) {
        proveedorService.deleteProveedorById(id);
        return "redirect:/proveedores/listado";
    }
}
