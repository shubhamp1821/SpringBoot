package com.Technosignia.TodoList.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Technosignia.TodoList.Model.ToDo;

@Repository
public interface IToDoRepo extends JpaRepository<ToDo, Long >{

}
