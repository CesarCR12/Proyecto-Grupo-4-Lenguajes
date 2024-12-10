/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Descuento;
import com.example.demo.service.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/descuentos")
public class DescuentoController {

    @Autowired
    private DescuentoService descuentoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Descuento> descuentos = descuentoService.getAllDescuentos();
        model.addAttribute("descuentos", descuentos);
        return "descuentos/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("descuento", new Descuento());
        return "descuentos/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Descuento descuento) {
        if (descuento.getId() == null || descuento.getId().isEmpty()) {
            descuentoService.saveDescuento(descuento); 
        } else {
            descuentoService.updateDescuento(descuento); 
        }
        return "redirect:/descuentos/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") String id, Model model) {
        Descuento descuento = descuentoService.getDescuentoById(id);
        if (descuento != null) {
            model.addAttribute("descuento", descuento);
            return "descuentos/modifica";
        }
        return "redirect:/descuentos/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id) {
        descuentoService.deleteDescuento(id);
        return "redirect:/descuentos/listado";
    }
}
