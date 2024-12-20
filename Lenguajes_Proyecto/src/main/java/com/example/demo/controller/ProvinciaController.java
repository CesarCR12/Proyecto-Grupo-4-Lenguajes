/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Provincia;
import com.example.demo.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ProvinciaController {

    @Autowired
    private ProvinciaService ProvinciaService;

    @GetMapping("/provincias")
    public String getAllProvincias(Model model) {
        List<Provincia> Provincias = ProvinciaService.getAllProvincias(); 
        model.addAttribute("provincias", Provincias); 
        return "Provincias"; 
    }
}
