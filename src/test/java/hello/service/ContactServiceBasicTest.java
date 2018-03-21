package hello.service;

import hello.bean.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/BusinessApplicationContext.xml" })
public class ContactServiceBasicTest {

    @Autowired
    IContactService contactService;

    @Test
    public void getContacts() {
        List<Contact> contacts = contactService.read();
        assertThat(contacts.size(), is(not(0)));
        Optional<String> emailOfLuke = Optional.empty();
        for (Contact contact : contacts) {
            if (contact.getName().startsWith("Luke"))
                emailOfLuke = Optional.ofNullable(contact.getEmail());
        }
        assertThat(emailOfLuke.isPresent(), is(true));
        assertThat(emailOfLuke.get(), is("luke@sw.org"));

    }

    @Test
    public void createContact() {
        List<Contact> contacts = contactService.read();
        int sizeBeforeAdd = contacts.size();
        contactService.create(new Contact("a"));
        contacts = contactService.read();
        int sizeAfterAdd = contacts.size();
        assertThat(sizeBeforeAdd+1, equalTo(sizeAfterAdd));
    }

}