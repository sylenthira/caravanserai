package org.caravanserai.demo.dao;

import org.caravanserai.demo.dto.Contact;
import org.caravanserai.demo.dto.Phone;

import java.util.List;

/**
 * @author sylenthira
 */
public interface ContactDao {
    public List<Contact> getContacts();
    public List<Contact> getContacts(int startIndex, int size);
    public Contact getContactById(Integer id);
    public Contact getContactByPhoneNo(String phoneNo);
    public void addContact(Contact contact);
    public void updateContact(Contact contact);
    public void deleteContact(Contact contact);

    public List<Phone> getPhonesByContactId(Integer contactId);
    public Phone getPhoneByContactIdPhoneId(Integer contactId, Integer phoneId);
    public void addPhone(Integer contactId, Phone phone);
    public void updatePhone(Integer contactId, Phone phone);
    public void deletePhone(Integer contactId, Phone phone);
}
