package com.andrew.TaskManager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andrew.TaskManager.DTO.TaskRequest;
import com.andrew.TaskManager.Entity.Task;
import com.andrew.TaskManager.Enum.Priority;
import com.andrew.TaskManager.Enum.Status;
import com.andrew.TaskManager.Service.TaskService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

	@Autowired
	TaskService service;
	
	@PostMapping("/addTask")
	public ResponseEntity<String> addTask(@RequestBody @Valid TaskRequest task) {
		service.addTask(task);
		return ResponseEntity.status(201).body("Task Created Successfully!");
	}
	
	@GetMapping("/tasks/id/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable long id){
		Optional<Task> exist = service.getTaskById(id);
		if(!exist.isEmpty())
			return ResponseEntity.ok(exist.get());
		return ResponseEntity.status(404).body(null);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateTask(@PathVariable long id, @RequestBody @Valid TaskRequest task) {
		boolean exist = service.updateTask(id,task);
		if(exist)
			return ResponseEntity.ok("Task Updated Successfully!");
		return ResponseEntity.status(404).body("Task Not Found");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable long id ) {
		boolean exist = service.deleteTask(id);
		if(exist)
			return ResponseEntity.ok("Task Deleted Successfully!");
		return ResponseEntity.status(404).body("Task Not Found");
	}
	
	@GetMapping("/tasks/title/{title}")
	public ResponseEntity<List<Task>> getTaskByTitle(@PathVariable String title){
		List<Task> list = service.getTaskByTitle(title);
		if(list.size()!=0)
			return ResponseEntity.ok(list);
		return ResponseEntity.status(404).body(null);
	}
	
	@GetMapping("/tasks/priority/{priority}")
	public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable Priority priority){
		List<Task> list = service.getTasksByPriority(priority);
		if(list.size()!=0)
			return ResponseEntity.ok(list);
		return ResponseEntity.status(404).body(null);
	}
	
	@GetMapping("/tasks/status/{status}")
	public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable Status status){
		List<Task> list = service.getTasksByStatus(status);
		if(list.size()!=0)
			return ResponseEntity.ok(list);
		return ResponseEntity.status(404).body(null);
	}
}
