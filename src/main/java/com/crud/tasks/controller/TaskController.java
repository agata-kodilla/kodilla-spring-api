package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;
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
        return taskMapper.mapToTaskDto(service.getById(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Long taskId) {
        if(service.deleteById(taskId)==false){
            throw new TaskNotFoundException();
        }
    }

    @PutMapping()
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskMapper.mapToTaskDto(service.save(taskMapper.mapToTask(taskDto)));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody TaskDto taskDto) {
        service.save(taskMapper.mapToTask(taskDto));
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleContentNotAllowedException(TaskNotFoundException t) {
    }
}
