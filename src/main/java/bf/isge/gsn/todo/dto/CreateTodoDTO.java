package bf.isge.gsn.todo.dto;

import lombok.Data;

@Data
public class CreateTodoDTO {
    private String description;
    private boolean archived;
    private String title;
}


