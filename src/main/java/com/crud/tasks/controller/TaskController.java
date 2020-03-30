package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @Autowired
    private DbService service;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping()
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    @GetMapping("{id}")
    public TaskDto getTask(@PathVariable("id") Long taskId) {
        return taskMapper.mapToTaskDto(service.getById(taskId));
    }

    @DeleteMapping("{id}")
  //  @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity deleteTask(Long taskId) {
        //
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto(1L, "Edited test title", "Edited Test_content");
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody TaskDto taskDto) {
    }
}
