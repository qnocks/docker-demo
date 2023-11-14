package com.example.lab5.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String date;

    @NonNull
    private Integer seat;

    @OneToOne
    private Show show;
}
