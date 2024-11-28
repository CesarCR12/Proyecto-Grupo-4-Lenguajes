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
        // Obtener la lista de cantones desde el servicio
        List<Canton> cantones = cantonService.getAllCantones();
        
        // Verificar que los cantones fueron obtenidos correctamente
        System.out.println("Cantones: " + cantones.size());  // Para verificar que hay datos
        
        // Agregar la lista de cantones al modelo
        model.addAttribute("cantones", cantones);
        
        // Retornar el nombre de la vista "Cantones"
        return "Cantones"; 
    }
}
