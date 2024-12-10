/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Pallet;
import com.example.demo.service.PalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pallets")
public class PalletController {

    @Autowired
    private PalletService palletService;

    @GetMapping("/listado")
    public String listarPallets(Model model) {
        List<Pallet> pallets = palletService.obtenerTodosLosPallets();
        model.addAttribute("pallets", pallets);
        return "pallets/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoPallet(Model model) {
        Pallet nuevoPallet = new Pallet();
        nuevoPallet.setEstado("ACTIVO"); 
        model.addAttribute("pallet", nuevoPallet);
        return "pallets/modifica";
    }

    @PostMapping("/guardar")
    public String guardarPallet(@ModelAttribute Pallet pallet) {
        if (pallet.getIdPallet() == null) { 
            palletService.guardarPallet(pallet);
        } else { 
            palletService.actualizarPallet(pallet);
        }
        return "redirect:/pallets/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificarPallet(@PathVariable("id") Long id, Model model) {
        Pallet pallet = palletService.obtenerPalletPorId(id);
        if (pallet != null) {
            model.addAttribute("pallet", pallet);
            return "pallets/modifica";
        }
        return "redirect:/pallets/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPallet(@PathVariable("id") Long id) {
        palletService.eliminarPallet(id);
        return "redirect:/pallets/listado";
    }
}
