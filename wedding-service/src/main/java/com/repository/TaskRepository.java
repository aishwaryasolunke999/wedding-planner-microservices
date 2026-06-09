package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	long countByCompleted(boolean completed);
}