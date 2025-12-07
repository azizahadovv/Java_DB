package com.example.jpalessons.repository;

import com.example.jpalessons.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepo extends JpaRepository<Groups, Integer> {

    List<Groups> findGroupNameByNameContainsIgnoreCase(String name);


}
