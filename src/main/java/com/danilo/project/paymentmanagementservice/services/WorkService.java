package com.danilo.project.paymentmanagementservice.services;

import com.danilo.project.paymentmanagementservice.entities.Work;
import com.danilo.project.paymentmanagementservice.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {
    @Autowired
    private WorkRepository repository;

    public List<Work> findAll(){
        List<Work> list = repository.findAll();
        return list;
    }

    public Work findById(Long id){
        Optional<Work> obj = repository.findById(id);
        return obj.get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Work insert(Work obj) {
        obj = repository.save(obj);
        return obj;
    }

    public Work update(Long id, Work obj){
        Work entity = repository.getReferenceById(id);
        updateData(entity,obj);
        return entity;
    }

    private void updateData(Work entity, Work obj) {
        entity.setClient(obj.getClient());
        entity.setDate(obj.getDate());
        entity.setDestination(obj.getDestination());
        entity.setStatus(obj.getStatus());
        entity.setTotal(obj.getTotal());
    }
}
