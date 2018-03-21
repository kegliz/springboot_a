package hello.service;

import hello.bean.Contact;

import java.util.List;

public interface IContactService {

    List<Contact> read();
    Contact create(Contact contact);

}
