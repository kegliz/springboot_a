package hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

  public String welcome() {
    return "Greetings\n";
  }

}
