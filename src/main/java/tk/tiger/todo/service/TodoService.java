package tk.tiger.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.tiger.todo.domain.Todo;
import tk.tiger.todo.repository.TodoRepository;

@Service
public class TodoService {
    // ①
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo findOne(Long id) {
        return todoRepository.findById(id).get();
    }

    public List<Todo> findByName(String name){
        return todoRepository.findByName(name);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}