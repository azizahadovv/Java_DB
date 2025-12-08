package com.example.jpalessons.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Student {
    @Id
    private Integer id;
    private String lastName;
    private String firstName;
    private Boolean active;

    @ManyToOne
    private Groups groups;

}
