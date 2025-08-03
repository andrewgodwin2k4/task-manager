package com.andrew.TaskManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrew.TaskManager.Entity.Task;
import com.andrew.TaskManager.Enum.Priority;
import com.andrew.TaskManager.Enum.Status;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long>{
	
		List<Task> findAllByTitle(String title);
		
		List<Task> findAllByPriority(Priority priority);
		
		List<Task> findAllByStatus(Status status);
}
