/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Distrito;
import com.example.demo.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/distritos")
    public String getAllDistritos(Model model) {
        List<Distrito> distritos = distritoService.getAllDistritos();  
        model.addAttribute("distritos", distritos);  
        return "distritos"; 
    }
}
