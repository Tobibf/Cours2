package bf.isge.gsn.todo.controller.web;

import bf.isge.gsn.todo.dto.CreateTodoDTO;
import bf.isge.gsn.todo.service.TodoService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoPageController {
    // todo list page
    private TodoService todoService;

    public TodoPageController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todoList")
    public String todoListPage(Model model) {
        model.addAttribute("todos", todoService.todoList());
        return "todoList";
    }

    @GetMapping("/addTodo")
    public String createTodoPage(Model model) {
        CreateTodoDTO form = new CreateTodoDTO();
        form.setDescription("description par defaut");
        model.addAttribute("todoForm", form);
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String createTodoForm(Model model, @ModelAttribute("todoForm") CreateTodoDTO todoForm) {
        if(Strings.isEmpty(todoForm.getTitle())) {
            model.addAttribute("errorMessage", "Le titre est requis");
            return "addTodo";
        }
        try {
            todoService.createTodo(todoForm);
            return "redirect:/todoList";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Une erreur est survenue lors de la sauvegarde: "+ e.getMessage());
            return "addTodo";
        }
    }

}
