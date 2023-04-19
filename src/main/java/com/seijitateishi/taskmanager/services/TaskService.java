package com.seijitateishi.taskmanager.services;

import com.seijitateishi.taskmanager.enums.Priority;
import com.seijitateishi.taskmanager.enums.Status;
import com.seijitateishi.taskmanager.model.Task;
import com.seijitateishi.taskmanager.repository.TaskRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.seijitateishi.taskmanager.enums.Status.TO_DO;
@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository repository;

    public List<Task> getAllTasks(){
        List<Task> list = repository.findAll();
        return list;
    }

    public Task getById(Long id){

        return repository.findById(id).get();
    }

    public void createTask(Task task){
        repository.save(task);
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }

    public void taskUpdate(Long id, Status status) throws Exception {
        Task task = repository.getById(id);
        if(task == null)
            throw new Exception("Invalid id!");
        task.setStatus(status);
        repository.save(task);
    }
}
