package bf.isge.gsn.todo.controller.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @Value("${welcome.message}")
    private String message;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }
}
