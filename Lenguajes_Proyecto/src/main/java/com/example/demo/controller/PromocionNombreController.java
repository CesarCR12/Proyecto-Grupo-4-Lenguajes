/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.service.PromocionNombreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PromocionNombreController {

    @Autowired
    private PromocionNombreService promocionNombreService;

    @GetMapping("/promociones/nombre")
    public String obtenerNombrePromocion(
        @RequestParam(required = false, defaultValue = "") String idPromocion,
        Model model
    ) {
        if (idPromocion.isEmpty()) {
            model.addAttribute("error", "El ID de la promoción no puede estar vacío.");
            return "promociones/nombre";
        }
        String nombrePromocion = promocionNombreService.obtenerNombrePromocion(idPromocion);
        model.addAttribute("idPromocion", idPromocion);
        model.addAttribute("nombrePromocion", nombrePromocion);
        return "promociones/nombre";
    }
}
