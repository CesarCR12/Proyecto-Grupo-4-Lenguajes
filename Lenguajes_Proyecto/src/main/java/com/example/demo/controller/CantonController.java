/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Canton;
import com.example.demo.service.CantonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class CantonController {

    @Autowired
    private CantonService cantonService;

    @GetMapping("/cantones")
    public String getAllCantones(Model model) {

        List<Canton> cantones = cantonService.getAllCantones();
        
        System.out.println("Cantones: " + cantones.size());  
        
        model.addAttribute("cantones", cantones);
        
        return "Cantones"; 
    }
}
