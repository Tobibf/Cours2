package bf.isge.gsn.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Todo> todoList  = new ArrayList<>();

    private LocalDate createdAt;

    @PrePersist
    public void setup() {
        this.createdAt = LocalDate.now();
    }
}
