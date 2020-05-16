package tk.tiger.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tk.tiger.todo.domain.Todo;
import tk.tiger.todo.service.TodoService;

@Controller
@RequestMapping("/todos") // ①
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public String index(Model model) { // ②
        List<Todo> todos = todoService.findAll();
        model.addAttribute("todos", todos); // ③
        return "todos/index"; // ④
    }

    @GetMapping("new")
    public String newTodo(Model model) {
        return "todos/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
        Todo todo = todoService.findOne(id);
        model.addAttribute("todo", todo);
        return "todos/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Todo todo = todoService.findOne(id);
        model.addAttribute("todo", todo);
        return "todos/show";
    }

    @PostMapping
    public String create(@ModelAttribute Todo todo) { // ⑥
        todoService.save(todo);
        return "redirect:/todos"; // ⑦
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Todo todo) {
        todo.setId(id);
        todoService.save(todo);
        return "redirect:/todos";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/todos";
    }
}