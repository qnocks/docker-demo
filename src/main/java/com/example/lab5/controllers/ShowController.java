package com.example.lab5.controllers;

import com.example.lab5.domain.Show;
import com.example.lab5.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/shows")
public class ShowController {
    private final ShowService showService;

    @Autowired
    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("shows", showService.getAll());
        return "shows/list";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("shows", List.of(showService.get(id)));
        return "shows/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("show") Show show) {
        return "shows/new";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute Show show, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "shows/new";
        }
        showService.save(show);
        return "redirect:/shows";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        showService.delete(id);
        return "redirect:/shows";
    }
}
