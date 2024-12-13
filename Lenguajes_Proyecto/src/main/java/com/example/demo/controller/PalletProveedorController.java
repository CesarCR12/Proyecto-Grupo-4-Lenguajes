package com.example.demo.controller;

import com.example.demo.service.PalletProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PalletProveedorController {

    @Autowired
    private PalletProveedorService palletProveedorService;

    @GetMapping("/pallets/proveedor")
    public String obtenerProveedor(@RequestParam(required = false) String idPallet, Model model) {
        if (idPallet == null || idPallet.isEmpty()) {
            model.addAttribute("error", "Por favor, ingrese un ID de Pallet válido.");
            return "pallets/proveedor";
        }

        String proveedor = palletProveedorService.obtenerProveedorPorPallet(idPallet);
        model.addAttribute("proveedor", proveedor);
        model.addAttribute("idPallet", idPallet);
        return "pallets/proveedor";
    }
}
