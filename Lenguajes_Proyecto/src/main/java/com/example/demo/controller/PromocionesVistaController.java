/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.PromocionVista;
import com.example.demo.service.PromocionVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PromocionesVistaController {

    @Autowired
    private PromocionVistaService promocionVistaService;

    @GetMapping("/promociones/activas")
    public String mostrarPromocionesActivas(Model model) {
        List<PromocionVista> promociones = promocionVistaService.obtenerPromocionesActivas();
        model.addAttribute("promociones", promociones);
        return "promociones/activas";
    }
}
