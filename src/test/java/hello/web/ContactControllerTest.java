package hello.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.bean.Contact;
import hello.service.IContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IContactService contactService;

    @Test
    public void getContacts() throws Exception {
        List<Contact> mockList = Arrays.asList(
                new Contact("alfa", "alfa@home.org", "11", "i11"),
                new Contact("beta", "beta@home.org", "22", "i22"));

        when(contactService.read()).thenReturn(mockList);

        MvcResult result = mvc
                .perform(MockMvcRequestBuilders.get("/api/contacts").accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        String expected = "["
                + "{name:\"alfa\",email:\"alfa@home.org\",mobile:\"11\",info:\"i11\"}" +","
                + "{name:\"beta\",email:\"beta@home.org\",mobile:\"22\",info:\"i22\"}" + "]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), true);

        MockHttpServletResponse response  = result.getResponse();
        ObjectMapper mapper = new ObjectMapper();
        //ExecutionStatus responseObj = mapper.readValue(response.getContentAsString(), ExecutionStatus.class);
        JsonNode node = mapper.readTree(response.getContentAsString());
        assertThat(node, notNullValue());
        assertThat(node.isArray(), is(true));
        assertThat(node.size(), equalTo(2));
        assertThat(node.get(0).path("name").asText(), is("alfa"));
        assertThat(node.get(1).path("name").asText(), is("beta"));

    }

}