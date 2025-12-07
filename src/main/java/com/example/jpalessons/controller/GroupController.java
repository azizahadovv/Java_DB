package com.example.jpalessons.controller;


import com.example.jpalessons.entity.Groups;
import com.example.jpalessons.payload.ReqGroup;
import com.example.jpalessons.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/groups")
public class GroupController {

    @Autowired
    private GroupRepo groupRepo;

    @PostMapping
    public ResponseEntity<?> saveGroup(@RequestBody ReqGroup reqGroup) {
        Groups group = groupRepo.save(
                new Groups(reqGroup.getName())
        );
        return ResponseEntity.ok(group.getId());
    }

    @GetMapping
    public ResponseEntity<?> getGroups(
            @RequestParam(required = false) String name) {

        if (name != null && !name.isBlank()) {
            return ResponseEntity.ok(
                    groupRepo.findByNameContainsIgnoreCase(name)
            );
        }
        return ResponseEntity.ok(groupRepo.findAllProjectedBy());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Integer id) {
        groupRepo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateGroup(
            @PathVariable Integer id,
            @RequestBody ReqGroup reqGroup) {

        Groups group = groupRepo.findById(id)
                .orElseThrow();

        group.setName(reqGroup.getName());
        groupRepo.save(group);

        return ResponseEntity.ok("Updated");
    }
}
