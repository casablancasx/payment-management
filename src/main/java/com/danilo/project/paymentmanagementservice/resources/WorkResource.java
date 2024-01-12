package com.danilo.project.paymentmanagementservice.resources;

import com.danilo.project.paymentmanagementservice.entities.Work;
import com.danilo.project.paymentmanagementservice.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkResource {
    @Autowired
    private WorkService service;


    @GetMapping
    public ResponseEntity<List<Work>> findAll(){
        List<Work> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Work> findById(@PathVariable Long id){
        Work obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Work> insert(@RequestBody Work obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Work> update(@PathVariable Long id, @RequestBody Work obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
