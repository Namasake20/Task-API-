package com.namasake.task.service;

import com.namasake.task.domain.Task;
import com.namasake.task.repo.TaskRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service @AllArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService{
    private final TaskRepo taskRepo;
    @Override
    public Task saveTask(Task task) {
        log.info("saving new task {} to database...",task.getTitle());
        return taskRepo.save(task);
    }

    @Override
    public List<Task> getTasks() {
        log.info("fetching all tasks");
        return taskRepo.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        log.info("deleting task with {} from database...",id);
        boolean taskExists = taskRepo.existsById(id);
        if (!taskExists){
            throw new IllegalStateException("task with id "+id+" does not exist");
        }
        taskRepo.deleteById(id);
    }

    @Override
    public Task updateTask(Long id,String title, String completed) {
        Task task = taskRepo.findById(id).orElseThrow(() ->new IllegalArgumentException("Task with"+id+" not found"));
        if (title != null && title.length() > 0 && !Objects.equals(task.getTitle(),title)){
            Optional<Task> optionalBird = Optional.ofNullable(taskRepo.findByTitle(title));
            if (optionalBird.isPresent()){
                log.error("name taken");
                throw new IllegalStateException("name taken");
            }
            task.setTitle(title);
        }
        if (completed != null && completed.length() > 0 ){
            task.setCompleted(Boolean.parseBoolean(completed));
        }
        return task;
    }
}
