/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.InventarioCantidadMinimaVista;
import com.example.demo.service.InventarioCantidadMinimaVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InventarioCantidadMinimaVistaController {

    @Autowired
    private InventarioCantidadMinimaVistaService inventarioCantidadMinimaVistaService;

    @GetMapping("/inventario/cantidad-minima")
    public String mostrarInventarioCantidadMinima(Model model) {
        List<InventarioCantidadMinimaVista> inventarios = inventarioCantidadMinimaVistaService.obtenerInventarioCantidadMinimaVista();
        model.addAttribute("inventarios", inventarios);
        return "inventario/vista";
    }

}
