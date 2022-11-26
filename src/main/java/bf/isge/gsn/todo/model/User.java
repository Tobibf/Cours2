package bf.isge.gsn.todo.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private int id;
    private String name;
    private List<Todo> todoList  = new ArrayList<>();
    private LocalDate createdAt;

}
