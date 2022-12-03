package bf.isge.gsn.todo.service;

import bf.isge.gsn.todo.dto.CreateTodoDTO;
import bf.isge.gsn.todo.dto.UpdateTodoDTO;
import bf.isge.gsn.todo.exception.TodoNotExistException;
import bf.isge.gsn.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TodoService {

    Todo createTodo (CreateTodoDTO todo) ;
    void deleteById (int id);
    void updateTodo(int id, UpdateTodoDTO todo) throws TodoNotExistException;
    List <Todo> todoList();
    Todo getById(int id);

}
