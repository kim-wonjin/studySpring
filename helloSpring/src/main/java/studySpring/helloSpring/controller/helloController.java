package studySpring.helloSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    // 정적 컨텐츠
    @GetMapping("hello")  // url /hello 들어오면 밑에를 호출
    public String hello (Model model) {
        model.addAttribute("data", "hello!~~~!");
        return "hello";  // resources/templates/hello.html 로 연결
    }
    // MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String helloMvc (@RequestParam("name")String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    //API
    @GetMapping("hello-String")
    @ResponseBody
    public String helloString (@RequestParam("name")String name) {
        return "hello " + name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi (@RequestParam("name")String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        // cmd N : generate 단축키
        // Getter Setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
