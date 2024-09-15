package com.Technosignia.TodoList.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Technosignia.TodoList.Model.ToDo;
import com.Technosignia.TodoList.Repo.IToDoRepo;

@Service
public class ToDoService {

    @Autowired
    IToDoRepo repo;

    public List<ToDo> getAllToDoItems() {
        List<ToDo> todoList = new ArrayList<>();
        repo.findAll().forEach(todoList::add);
        return todoList;
    }

    public ToDo getToDoItemById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public boolean updateStatus(Long id) {
        ToDo todo = getToDoItemById(id);
        if (todo != null) {
            todo.setStatus("Completed");
            return saveOrUpdateToDoItem(todo);
        }
        return false;
    }

    public boolean saveOrUpdateToDoItem(ToDo todo) {
        ToDo updatedObj = repo.save(todo);
        return updatedObj != null && updatedObj.getId() != null;
    }

    public boolean deleteToDoItem(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
