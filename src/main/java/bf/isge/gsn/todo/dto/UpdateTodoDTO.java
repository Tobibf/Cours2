package bf.isge.gsn.todo.dto;

import lombok.Data;

@Data
public class UpdateTodoDTO {
    private String description;
    private boolean archived;
}
