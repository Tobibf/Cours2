package bf.isge.gsn.todo.service;

import bf.isge.gsn.todo.dto.CreateTodoDTO;
import bf.isge.gsn.todo.dto.UpdateTodoDTO;
import bf.isge.gsn.todo.exception.TodoNotExistException;
import bf.isge.gsn.todo.model.Todo;
import bf.isge.gsn.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceJPAImpl implements TodoService {
    private TodoRepository todoRepository;

    public TodoServiceJPAImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo createTodo(CreateTodoDTO todoTDO) {
        Todo tod = new Todo();
        tod.setDescription(todoTDO.getDescription());
        tod.setTitle(todoTDO.getTitle());
        tod.setArchived(todoTDO.isArchived());

        return todoRepository.save(tod);
    }

    @Override
    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void updateTodo(int id, UpdateTodoDTO todoDTO) throws TodoNotExistException {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotExistException();
        }
        //Get todo to dataBase
        Todo todo = todoRepository.findById(id).orElse(null);

        //Update the two colum
        todo.setArchived(todoDTO.isArchived());
        todo.setDescription(todoDTO.getDescription());

        todoRepository.save(todo);
    }

    @Override
    public List<Todo> todoList() {

        List<Todo> todoList = new ArrayList<>();
        for (Todo todo : todoRepository.findAll()) {
            todoList.add(todo);
        }
        return todoList;
    }

    @Override
    public Todo getById(int id) {
        return todoRepository.findById(id).orElse(null);
    }
}
