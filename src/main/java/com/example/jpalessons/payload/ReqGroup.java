package com.example.jpalessons.payload;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity



public class ReqGroup {

    @Id
    private Long id;
    private String name;
}
