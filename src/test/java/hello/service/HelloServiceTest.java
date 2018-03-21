package hello.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/BusinessApplicationContext.xml" })
public class HelloServiceTest {

  @Autowired
  private HelloService helloService;

  @Test
  public void testWelcome() {
    assertThat(helloService.welcome(), is("Greetings\n") );
  }

  @Test
  public void testSzia() {
    assertThat(helloService.szia(), is("Shalom!") );
  }

}
