package com.finanzas.personales.controller;

import com.finanzas.personales.model.Plan;
import com.finanzas.personales.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/planes")
public class PlanController {

    @Autowired
    private PlanService service;

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("planes", service.listarTodos());
        return "planes/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("plan", new Plan());
        return "planes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("plan") Plan plan,
                          BindingResult result) {

        if (result.hasErrors()) {
            return "planes/formulario";
        }

        service.guardar(plan);
        return "redirect:/planes/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/planes/";
    }
}