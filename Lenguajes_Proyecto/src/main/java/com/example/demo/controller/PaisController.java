/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Pais;
import com.example.demo.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/paises")
    public String getAllPaises(Model model) {
        List<Pais> paises = paisService.getAllPaises();  // Llamamos al servicio
        model.addAttribute("paises", paises);  // Pasamos los países al modelo
        return "paises";  // La vista "paises.html" se renderiza
    }
}

