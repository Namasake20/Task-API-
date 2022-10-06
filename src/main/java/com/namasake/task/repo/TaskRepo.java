package com.namasake.task.repo;

import com.namasake.task.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long> {
    Task findByTitle(String title);
}
