package com.seijitateishi.taskmanager.controller.requests;

import com.seijitateishi.taskmanager.enums.Priority;
import com.seijitateishi.taskmanager.model.Task;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

import static com.seijitateishi.taskmanager.enums.Status.TO_DO;

@Data
public class TaskCreateRequest {
    @NotNull
    @Size(min = 5)
    private String title;
    private String description;
    @NotNull
    private LocalDateTime deadline;
    @NotNull
    private Priority priority;

    public Task toTask(){
        return Task.builder()
                .title(title)
                .description(description)
                .deadline(deadline)
                .priority(priority)
                .status(TO_DO)
                .build();
    }
}
