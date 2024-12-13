/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.DescuentoDetalleVista;
import com.example.demo.service.DescuentoDetalleVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DescuentoDetalleVistaController {

    @Autowired
    private DescuentoDetalleVistaService descuentoDetalleVistaService;

    @GetMapping("/descuentos/detalle")
    public String mostrarDescuentos(
        @RequestParam(defaultValue = "asc") String sortOrder,
        Model model
    ) {
        List<DescuentoDetalleVista> descuentos = descuentoDetalleVistaService.obtenerDescuentosOrdenados(sortOrder);
        model.addAttribute("descuentos", descuentos);
        model.addAttribute("sortOrder", sortOrder);
        return "descuentos/detalle";
    }
}
