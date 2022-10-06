package com.namasake.task.api;

import com.namasake.task.domain.Task;
import com.namasake.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok().body(taskService.getTasks());
    }

    @PostMapping("/task/save")
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/task/save").toUriString());
        return ResponseEntity.created(uri).body(taskService.saveTask(task));
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long id){
        taskService.deleteTask(id);
    }

    @PutMapping(path = "{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable("taskId") Long id, @RequestParam(required = false) String title,@RequestParam(required = false) boolean completed ){
        return ResponseEntity.ok().body(taskService.updateTask(id,title, String.valueOf(completed)));
    }
}
