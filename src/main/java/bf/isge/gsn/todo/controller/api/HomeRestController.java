package bf.isge.gsn.todo.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class HomeRestController {

    @GetMapping
    public String helloWorld(){
        return  "Hello World";
    }
}
