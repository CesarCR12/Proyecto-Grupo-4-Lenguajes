/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Estado;
import com.example.demo.domain.Promocion;
import com.example.demo.service.EstadoService;
import com.example.demo.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/promociones")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    @Autowired
    private EstadoService estadoService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Promocion> promociones = promocionService.getAllPromociones();
        model.addAttribute("promociones", promociones);
        return "promociones/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("promocion", new Promocion());
        model.addAttribute("estados", estadoService.getAllEstados());
        return "promociones/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Promocion promocion, @RequestParam("estadoId") String estadoId) {
        Estado estado = estadoService.getEstadoById(estadoId);
        promocion.setEstado(estado);

        if (promocion.getPromocionId() == null) { 
            promocionService.save(promocion); 
        } else {
            promocionService.update(promocion); 
        }
        return "redirect:/promociones/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") String id, Model model) {
        Promocion promocion = promocionService.getPromocionById(id);
        if (promocion != null) {
            model.addAttribute("promocion", promocion);
            model.addAttribute("estados", estadoService.getAllEstados());
            return "promociones/modifica";
        }
        return "redirect:/promociones/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id) {
        promocionService.deleteById(id); 
        return "redirect:/promociones/listado";
    }
}
