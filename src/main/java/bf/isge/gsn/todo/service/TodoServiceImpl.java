package bf.isge.gsn.todo.service;

import bf.isge.gsn.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class TodoServiceImpl  implements TodoService{
    private final Map<Integer, Todo> todoMap = new HashMap<>();
    @Override
    public Todo createTodo(Todo todo) {
        todoMap.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public void deleteById(int id) {
        todoMap.remove(id);
    }

    @Override
    public void updateTodo(int id, Todo todo) {
        todoMap.put(id, todo);
    }

    @Override
    public List<Todo> todoList() {
        return new ArrayList<>(todoMap.values());
    }

    @Override
    public Todo getById(int id) {
        return todoMap.get(id);
    }
}
