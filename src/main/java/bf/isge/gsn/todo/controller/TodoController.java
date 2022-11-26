package bf.isge.gsn.todo.controller;

import bf.isge.gsn.todo.model.Todo;
import bf.isge.gsn.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @GetMapping
    public List<Todo> todoList(){
        return todoService.todoList();
    }
    @GetMapping("{id}")
    public Todo getTodo(@PathVariable int id){
        return todoService.getById(id);
    }
    @PutMapping("{id}")
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(id, todo);

    }
    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable int id){
       todoService.deleteById(id);
    }
}
