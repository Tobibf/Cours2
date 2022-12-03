package bf.isge.gsn.todo.repository;

import bf.isge.gsn.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Integer> {
}
