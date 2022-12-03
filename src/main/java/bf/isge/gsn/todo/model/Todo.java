package bf.isge.gsn.todo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Todo {
 @Id
 @GeneratedValue
 private int id;

 @Column(unique = true)
 private String title;
 private String description;

 @ManyToOne
 private User author;


 private LocalDate createdAt;

 @Column(columnDefinition = "boolean default false")
 private boolean archived;

 @PrePersist
 public void setup() {
  this.createdAt = LocalDate.now();
 }
}
