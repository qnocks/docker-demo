package com.example.lab5.controllers;

import com.example.lab5.domain.Ticket;
import com.example.lab5.services.ShowService;
import com.example.lab5.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final ShowService showService;

    @Autowired
    public TicketController(TicketService ticketService, ShowService showService) {
        this.ticketService = ticketService;
        this.showService = showService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("tickets", ticketService.getAll());
        return "tickets/list";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("tickets", List.of(ticketService.get(id)));
        return "tickets/list";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("ticket") Ticket ticket, Model model) {
        model.addAttribute("shows", showService.getAll());
        return "tickets/new";
    }

    @PostMapping("/new")
    public String create(@Valid @ModelAttribute Ticket ticket, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "tickets/new";
        }
        ticketService.save(ticket);
        return "redirect:/tickets";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        ticketService.delete(id);
        return "redirect:/tickets";
    }
}
