package studySpring.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloController {

    @GetMapping("hello")  // url /hello 들어오면 밑에를 호출
    public String hello (Model model) {
        model.addAttribute("data", "hello!~~~!");
        return "hello";  // resources/templates/hello.html 로 연결
    }
}
