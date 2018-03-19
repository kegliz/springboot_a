package hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

  @Override
  public String welcome() {
    return "Greetings\n";
  }

  @Override
  public String szia() {
    return "Shalom!";
  }

}
