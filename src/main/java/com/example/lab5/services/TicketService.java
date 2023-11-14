package com.example.lab5.services;

import com.example.lab5.domain.Ticket;
import com.example.lab5.repositories.TicketRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAll() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    public Ticket get(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Customer id: " + id));
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @SneakyThrows
    public Ticket update(Long id, Ticket ticket) {
        return null;
    }

    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }
}
