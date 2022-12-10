package bf.isge.gsn.todo.controller.api;

import bf.isge.gsn.todo.dto.CreateTodoDTO;
import bf.isge.gsn.todo.dto.UpdateTodoDTO;
import bf.isge.gsn.todo.exception.TodoNotExistException;
import bf.isge.gsn.todo.model.Todo;
import bf.isge.gsn.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoRestController {
    private TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo createTodo(@RequestBody CreateTodoDTO todo){
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
    public void updateTodo(@PathVariable int id, @RequestBody UpdateTodoDTO todo) throws TodoNotExistException {
        todoService.updateTodo(id, todo);

    }
    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable int id){
       todoService.deleteById(id);
    }
}
