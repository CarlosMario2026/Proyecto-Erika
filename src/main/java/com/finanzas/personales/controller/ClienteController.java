package com.finanzas.personales.controller;

import com.finanzas.personales.model.Cliente;
import com.finanzas.personales.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/")
    public String listar(@RequestParam(required = false) String buscar, Model model) {
        if (buscar != null && !buscar.isEmpty()) {
            model.addAttribute("clientes", service.buscar(buscar));
        } else {
            model.addAttribute("clientes", service.listarTodos());
        }
        model.addAttribute("buscar", buscar);
        return "clientes/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("cliente") Cliente cliente,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "clientes/formulario";
        }
        service.guardar(cliente);
        return "redirect:/clientes/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", service.buscarPorId(id));
        return "clientes/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/clientes/";
    }
}