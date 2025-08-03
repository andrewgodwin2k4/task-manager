package com.andrew.TaskManager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrew.TaskManager.DTO.TaskRequest;
import com.andrew.TaskManager.Entity.Task;
import com.andrew.TaskManager.Enum.Priority;
import com.andrew.TaskManager.Enum.Status;
import com.andrew.TaskManager.Repository.TaskRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

	@Autowired
	TaskRepository repo;
	
	public void addTask(TaskRequest task) {
		Task t = new Task();
		t.setTitle(task.getTitle());
		t.setDescription(task.getDescription());
		t.setStatus(task.getStatus());
		t.setPriority(task.getPriority());
		
		repo.save(t);	
	}

	public List<Task> getTaskByTitle(String title) {
		return repo.findAllByTitle(title);
	}

	public Optional<Task> getTaskById(long id) {
		return repo.findById(id);
	}

	public boolean updateTask(long id,TaskRequest task) {
		Optional<Task> exist = repo.findById(id);
		if(!exist.isEmpty()) {
			
			Task t = exist.get();
			t.setTitle(task.getTitle());
			t.setDescription(task.getDescription());
			t.setStatus(task.getStatus());
			t.setPriority(task.getPriority());
			
			repo.save(t);	
			return true;
		}
		return false;

		
	}

	public boolean deleteTask(long id) {
		Optional<Task> exist = repo.findById(id);
		if(!exist.isEmpty()) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Task> getTasksByPriority(Priority priority) {
		return repo.findAllByPriority(priority);
	}
	
	public List<Task> getTasksByStatus(Status status) {
		return repo.findAllByStatus(status);
	}

}
