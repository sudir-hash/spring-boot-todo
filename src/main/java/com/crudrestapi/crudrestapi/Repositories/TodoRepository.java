package com.crudrestapi.crudrestapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudrestapi.crudrestapi.Models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
