package com.finanzas.personales.controller;

import com.finanzas.personales.model.Venta;
import com.finanzas.personales.service.ClienteService;
import com.finanzas.personales.service.PlanService;
import com.finanzas.personales.service.VendedorService;
import com.finanzas.personales.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private PlanService planService;

    private void cargarListas(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("vendedores", vendedorService.listarTodos());
        model.addAttribute("planes", planService.listarTodos());
        model.addAttribute("estados", Venta.EstadoVenta.values());
    }

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("ventas", ventaService.listarTodos());
        return "ventas/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("venta", new Venta());
        cargarListas(model);
        return "ventas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("venta") Venta venta,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            cargarListas(model);
            return "ventas/formulario";
        }
        ventaService.guardar(venta);
        return "redirect:/ventas/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("venta", ventaService.buscarPorId(id));
        cargarListas(model);
        return "ventas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        ventaService.eliminar(id);
        return "redirect:/ventas/";
    }
}
