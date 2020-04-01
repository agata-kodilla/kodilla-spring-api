package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public <Optional>Task getById(final Long id){
        return repository.findById(id).get();
    }

    public Task save(Task task) {
        return repository.save(task);
    }


    public void deleteById(final Long id){
       repository.deleteById(id);
    }

}
