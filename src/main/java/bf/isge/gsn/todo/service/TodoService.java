package bf.isge.gsn.todo.service;

import bf.isge.gsn.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TodoService {

    Todo createTodo (Todo todo) ;
    void deleteById (int id);
    void updateTodo(int id, Todo todo);
    List <Todo> todoList();
    Todo getById(int id);

}
