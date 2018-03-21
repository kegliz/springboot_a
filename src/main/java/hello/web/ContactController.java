package hello.web;

import hello.bean.Contact;
import hello.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    private final IContactService contactService;

    @Autowired
    ContactController(final IContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping(method = GET)
    @ResponseStatus(OK)
    public List<Contact> read() {
        return contactService.read();
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    Contact create(@RequestBody final Contact contact) {
        return contactService.create(contact);
    }

}
