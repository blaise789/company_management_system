package com.codewithme.jobapp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Job {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String  location;

}
