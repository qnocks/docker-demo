package com.example.lab5.services;

import com.example.lab5.domain.Show;
import com.example.lab5.repositories.ShowRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    private final ShowRepository showRepository;

    @Autowired
    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> getAll() {
        return (List<Show>) showRepository.findAll();
    }

    public Show get(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find Car id: " + id));
    }

    public Show save(Show show) {
        return showRepository.save(show);
    }

    @SneakyThrows
    public Show update(Long id, Show show) {
        return null;
    }

    public void delete(Long id) {
        showRepository.deleteById(id);
    }
}
