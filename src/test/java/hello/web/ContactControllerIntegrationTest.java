package hello.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void getContacts() throws Exception {

        String uri = "/api/contacts";

        ResponseEntity<String> response =
                template.getForEntity(createUrl(uri), String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.getBody());
        assertThat(node, notNullValue());
        assertThat(node.isArray(), is(true));
        assertThat(node.size(), equalTo(3));
        assertThat(node.get(0).path("name").asText(), is("Luke Skywalker"));
        assertThat(node.get(1).path("name").asText(), is("Hulk"));
        assertThat(node.get(2).path("name").asText(), is("Stalker"));

    }

    private String createUrl(String uri) {
        return "http://localhost:" + port + uri;
    }
}