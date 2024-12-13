/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.PalletVista;
import com.example.demo.service.PalletVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PalletVistaController {

    @Autowired
    private PalletVistaService palletVistaService;

    @GetMapping("/pallets/vista")
    public String mostrarPallets(@RequestParam(defaultValue = "1") String idEstados, Model model) {
 
        List<PalletVista> pallets = palletVistaService.obtenerPalletsPorEstado(idEstados);
        
        model.addAttribute("pallets", pallets);
        model.addAttribute("idEstados", idEstados);
        
        return "pallets/vista";
    }
}
