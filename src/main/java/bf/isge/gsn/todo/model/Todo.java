package bf.isge.gsn.todo.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Todo {

 private int id;
 private String title;
 private String description;
 private User author;
 private LocalDate createdAt;
 private boolean archived;

}
