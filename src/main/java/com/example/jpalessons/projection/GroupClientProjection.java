package com.example.jpalessons.projection;


import org.springframework.beans.factory.annotation.Value;

public interface GroupClientProjection {
    @Value("#{target.id}")
    Integer getId();

    @Value("#{target.name}")
    String getName();
}
