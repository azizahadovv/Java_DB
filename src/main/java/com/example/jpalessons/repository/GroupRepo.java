package com.example.jpalessons.repository;

import com.example.jpalessons.entity.Groups;
import com.example.jpalessons.projection.GroupClientProjections;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepo extends JpaRepository<Groups, Integer> {

    List<GroupClientProjections> findAllProjectedBy();

    List<GroupClientProjections>
    findByNameContainsIgnoreCase(String name);


}
