package com.codewithme.jobapp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String title;
    private String description;
    private double rating;
    @ManyToOne()
    @JsonIgnore()
    private  Company company;


}
