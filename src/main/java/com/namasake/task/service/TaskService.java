package com.namasake.task.service;

import com.namasake.task.domain.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);
    List<Task> getTasks();
    void deleteTask(Long id);
    Task updateTask(Long id,String title,String completed);
}
