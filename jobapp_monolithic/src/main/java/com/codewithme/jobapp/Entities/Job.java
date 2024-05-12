package com.codewithme.jobapp.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "jobs")
public class Job {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String  location;
    @ManyToOne()
    @JoinColumn(name = "co_id")
    @JsonIgnore
    private  Company company;

}
