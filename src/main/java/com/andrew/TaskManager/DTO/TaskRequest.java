package com.andrew.TaskManager.DTO;

import com.andrew.TaskManager.Enum.Priority;
import com.andrew.TaskManager.Enum.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRequest {
	
	@NotBlank(message = "Title is Required")
	@Size(max = 50, message = "Title must be under 50 characters")
	private String title;
	
	@Size(max = 500, message = "Description must be under 500 characters")
	private String description;
	
	private Status status;
	private Priority priority;
	
}
