package com.finanzas.personales.controller;

import com.finanzas.personales.model.Vendedor;
import com.finanzas.personales.service.VendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("vendedores", service.listarTodos());
        return "vendedores/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("vendedor", new Vendedor());
        return "vendedores/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("vendedor") Vendedor vendedor,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "vendedores/formulario";
        }
        service.guardar(vendedor);
        return "redirect:/vendedores/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("vendedor", service.buscarPorId(id));
        return "vendedores/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/vendedores/";
    }
}
