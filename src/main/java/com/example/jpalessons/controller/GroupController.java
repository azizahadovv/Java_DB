package com.example.jpalessons.controller;


import com.example.jpalessons.entity.Groups;
import com.example.jpalessons.payload.ReqGroup;
import com.example.jpalessons.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/v1/groups")
@RestController

public class GroupController {

    @Autowired
    private GroupRepo groupRepo;

    @PostMapping
    public HttpEntity<?> saveGroup(@RequestBody ReqGroup reqGroup) {
        Groups save = groupRepo.save(new Groups(reqGroup.getName()));
        return ResponseEntity.ok(save);
    }


    @GetMapping("/")
    public HttpEntity<?> getGroups() {
        List<Groups> allGroups = groupRepo.findAll();
        return ResponseEntity.ok(allGroups);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getGroupById(@PathVariable Integer id) {
        Optional<Groups> group = groupRepo.findById(id);
        return ResponseEntity.ok(group.get());
    }

    @GetMapping()
    public HttpEntity<?> findByGroupName(@RequestParam String name) {
        List<Groups> groupNameByNameContainsIgnoreCase = groupRepo.findGroupNameByNameContainsIgnoreCase(name);
        return ResponseEntity.ok(groupNameByNameContainsIgnoreCase);
    }


    @DeleteMapping("{id}")
    public HttpEntity<?> deleteGroup(@PathVariable Integer id) {
        groupRepo.deleteById(id);
        return ResponseEntity.ok("Group with id " + id + " was deleted");
    }

    @PutMapping("{id}")
    public HttpEntity<?> updateGroup(@PathVariable Integer id, @RequestBody ReqGroup reqGroup) {
        Groups update = groupRepo.save(new Groups(id, reqGroup.getName()));
        return ResponseEntity.ok(update);
    }


}
