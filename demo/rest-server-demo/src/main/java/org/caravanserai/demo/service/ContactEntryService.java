package org.caravanserai.demo.service;

import org.caravanserai.demo.domain.Contact;
import org.caravanserai.demo.domain.Phone;

import java.util.List;

/**
 * @author sylenthira.
 */
public interface ContactEntryService {
    public Contact getContact(int id);
    public List<Contact> getContacts();
    public List<Contact> getContacts(int start, int size);

    public void add(Contact contact);
    public void update(Contact contact);
    public void delete(int id);

    public void addPhone(Phone phone);
    public void updatePhone(Phone phone);

}
