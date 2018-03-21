package hello.service;

import hello.bean.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ContactServiceBasic implements IContactService {
    private static List<Contact> contacts = new ArrayList<Contact>();
    static {
        contacts.add(new Contact("Luke Skywalker").setEmail("luke@sw.org").setMobile("11111111").setInfo("jedi knight"));
        contacts.add(new Contact("Hulk").setEmail("hulk@marvel.org").setMobile("22222222222").setInfo("green man"));
        contacts.add(new Contact("Stalker").setEmail("stalker@zone.org").setMobile("312345678").setInfo("life"));
    }

    @Override
    public List<Contact> read() {
        return Collections.unmodifiableList(contacts);
    }

    @Override
    public Contact create(Contact contact) {
        Contact newContact = new Contact(contact);
        contacts.add(newContact);
        return newContact;
    }
}
