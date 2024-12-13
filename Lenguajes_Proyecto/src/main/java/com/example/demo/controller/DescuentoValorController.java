/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.service.DescuentoValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DescuentoValorController {

    @Autowired
    private DescuentoValorService descuentoValorService;

    @GetMapping("/descuentos/valor")
    public String obtenerValorDescuento(
        @RequestParam(required = false, defaultValue = "") String idDescuento,
        Model model
    ) {
        if (idDescuento.isEmpty()) {
            model.addAttribute("error", "El ID del descuento no puede estar vacío.");
            return "descuentos/valor";
        }
        double valorDescuento = descuentoValorService.obtenerValorDescuento(idDescuento);

        if (valorDescuento == -1) {
            model.addAttribute("error", "Descuento no encontrado.");
        } else if (valorDescuento == -2) {
            model.addAttribute("error", "Error al consultar el valor del descuento.");
        } else {
            model.addAttribute("valorDescuento", valorDescuento);
        }

        model.addAttribute("idDescuento", idDescuento);
        return "descuentos/valor";
    }
}
