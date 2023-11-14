package com.example.lab5.repositories;

import com.example.lab5.domain.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {
}
