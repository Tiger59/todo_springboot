package tk.tiger.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.tiger.todo.domain.Todo;
import tk.tiger.todo.service.TodoService;

@RestController
@RequestMapping("rest/todos") // ①
public class TodoRestController {
    @Autowired
    private TodoService todoService;

    /**
     * 全てのTodoを取得
     * @return
     */
    @GetMapping
    public List<Todo> getAllTodo() {
        List<Todo> todos = todoService.findAll();
        return todos;
    }

    /**
     * Todoの追加
     * @param todo
     * @return
     */
    @PostMapping
    public Todo createTodo(@ModelAttribute Todo todo) {
        todoService.save(todo);
        return todo;
    }

    /**
     * IDを指定しTodoを取得
     * @param id
     * @return
     */
    @GetMapping("id/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        Todo todo = todoService.findOne(id);
        return todo;
    }

    /**
     * IDを指定しTodoを変更
     * @param id
     * @param new_todo
     * @return
     */
    @PutMapping("id/{id}")
    public Todo updateTodo(@PathVariable Long id, @ModelAttribute Todo new_todo) {
        try {
            //Todoが存在するか確認
            Todo old_todo = todoService.findOne(id);
            new_todo.setId(id);
            todoService.save(new_todo);
        } catch (Exception e) {
            //TODO:todo未定義の際の処理を追加
            return null;
        }
        return new_todo;
    }

    /**
     * IDを指定しTodoを消去
     * @param id
     * @return
     */
    @DeleteMapping("id/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return "{comments:success}";
    }

    /**
     * Todo作成者の名前を指定しTodoの追加
     * @param name
     * @return
     */
    @GetMapping("name/{name}")
    public List<Todo> getTodoByName(@PathVariable String name) {
        List<Todo> todos = todoService.findByName(name);
        return todos;
    }
}