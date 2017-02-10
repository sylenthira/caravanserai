package org.caravanserai.demo.service;


import org.caravanserai.demo.dal.entity.Contact;
import org.caravanserai.demo.dal.entity.Phone;

import java.util.List;

/**
 * @author sylenthira.
 */
public interface ContactEntryService {
    public Contact getContactById(int id);
    public Contact getContactByPhoneNo(String phoneNo);
    public List<Contact> getContacts();
    public List<Contact> getContacts(int start, int size);
    public void addContact(Contact contact);
    public void updateContact(Contact contact);
    public void deleteContact(int id);

    public List<Phone> getPhones(int contactId);
    public Phone getPhoneByContactIdPhoneId(Integer contactId, Integer phoneId);
    public void addPhone(int contactId, Phone phone);
    public void updatePhone(int contactId, Phone phone);
    public void deletePhone(int contactId, int phoneId);

}
