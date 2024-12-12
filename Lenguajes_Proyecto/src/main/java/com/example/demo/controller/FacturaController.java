/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.domain.Factura;
import com.example.demo.service.ClientesService;
import com.example.demo.service.FacturaService;
import com.example.demo.service.PromocionService;
import com.example.demo.service.DescuentoService;
import com.example.demo.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private PromocionService promocionService;

    @Autowired
    private DescuentoService descuentoService;

    @Autowired
    private InventarioService inventarioService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(java.util.Date.class, new org.springframework.beans.propertyeditors.CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/listado")
    public String listarFacturas(Model model) {
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
        model.addAttribute("facturas", facturas);
        return "facturas/listado";
    }

    @GetMapping("/nuevo")
    public String nuevaFactura(Model model) {
        model.addAttribute("factura", new Factura());
        model.addAttribute("clientes", clientesService.getClientes(true));
        model.addAttribute("promociones", promocionService.getAllPromociones());
        model.addAttribute("descuentos", descuentoService.getAllDescuentos());
        model.addAttribute("inventarios", inventarioService.getInventarios(true)); 
        return "facturas/modifica";
    }

    @PostMapping("/guardar")
    public String guardarFactura(@ModelAttribute Factura factura) {
        try {
            if (factura.getIdFactura() == null || factura.getIdFactura().isEmpty()) {
                factura.setIdsInventario(factura.getIdsInventario().replace(" ", ""));
                factura.setCantidades(factura.getCantidades().replace(" ", ""));

                if (!validarListas(factura.getIdsInventario(), factura.getCantidades())) {
                    return "redirect:/facturas/nuevo?error=invalidData";
                }

                facturaService.guardarFactura(factura);
            } else {
                facturaService.actualizarFactura(factura);
            }
            return "redirect:/facturas/listado";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/facturas/nuevo?error=true";
        }
    }

    @GetMapping("/modificar/{id}")
    public String modificarFactura(@PathVariable("id") String id, Model model) {
        Factura factura = facturaService.obtenerFacturaPorId(id);
        if (factura != null) {
            model.addAttribute("factura", factura);
            model.addAttribute("clientes", clientesService.getClientes(true));
            model.addAttribute("promociones", promocionService.getAllPromociones());
            model.addAttribute("descuentos", descuentoService.getAllDescuentos());
            model.addAttribute("inventarios", inventarioService.getInventarios(true)); 
            return "facturas/modifica";
        }
        return "redirect:/facturas/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFactura(@PathVariable("id") String id) {
        try {
            facturaService.eliminarFactura(id);
            return "redirect:/facturas/listado?deleted=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/facturas/listado?error=true";
        }
    }

    @PutMapping("/{idFactura}/descuento/{idDescuento}")
    public String asignarDescuentoAFactura(
            @PathVariable String idFactura,
            @PathVariable String idDescuento) {
        try {
            facturaService.agregarDescuentoAFactura(idFactura, idDescuento);
            return "redirect:/facturas/listado?descuentoAsignado=true";
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "redirect:/facturas/listado?error=" + e.getMessage();
        }
    }

    private boolean validarListas(String idsInventario, String cantidades) {
        String[] ids = idsInventario.split(",");
        String[] qtys = cantidades.split(",");

        if (ids.length != qtys.length) {
            return false;
        }

        for (String qty : qtys) {
            try {
                if (Integer.parseInt(qty) <= 0) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}
