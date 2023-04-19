package com.seijitateishi.taskmanager.controller;

import com.seijitateishi.taskmanager.controller.requests.TaskCreateRequest;
import com.seijitateishi.taskmanager.enums.Status;
import com.seijitateishi.taskmanager.model.Task;
import com.seijitateishi.taskmanager.repository.TaskRepository;
import com.seijitateishi.taskmanager.services.TaskService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;


    @GetMapping
    public List<Task> getAllTasks() {
        List<Task> list = taskService.getAllTasks();
        return list;
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        Task task = taskService.getById(id);
        return task;
    }

    @PostMapping("/{id}/{status}")
    public ResponseEntity<Void> taskUpdate(@PathVariable Long id, @PathVariable Status status) throws Exception {
        taskService.taskUpdate(id, status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody @Valid TaskCreateRequest task){
        taskService.createTask(task.toTask());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
