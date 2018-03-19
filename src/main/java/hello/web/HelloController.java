package hello.web;

import hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;


    @RequestMapping("/")
    public String index() {
        return helloService.welcome();
    }

    @RequestMapping("/ivrit")
    public String ivrit() {
        return helloService.szia();
    }

}
