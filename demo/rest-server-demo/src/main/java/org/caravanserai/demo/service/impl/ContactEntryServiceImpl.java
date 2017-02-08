package org.caravanserai.demo.service.impl;


import org.caravanserai.demo.dao.ContactDao;
import org.caravanserai.demo.dao.impl.ContactDaoImpl;
import org.caravanserai.demo.dto.Contact;
import org.caravanserai.demo.dto.Phone;
import org.caravanserai.demo.service.ContactEntryService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author sylenthira
 */
public class ContactEntryServiceImpl implements ContactEntryService {
    private static ContactDao contactDao;

    public ContactEntryServiceImpl() {
        if (contactDao == null) {
            contactDao = new ContactDaoImpl();
        }
    }

    @Override
    public Contact getContactById(int id) {
        return contactDao.getContactById(id);
    }

    @Override
    public Contact getContactByPhoneNo(String phoneNo) {
        return contactDao.getContactByPhoneNo(phoneNo);
    }

    @Override
    public List<Contact> getContacts() {
        return contactDao.getContacts();
    }

    @Override
    public List<Contact> getContacts(int start, int size) {
        return contactDao.getContacts(start, size);
    }

    @Override
    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        contactDao.updateContact(contact);
    }

    @Override
    public void deleteContact(int id) {
        contactDao.deleteContact(getContactById(id));
    }

    @Override
    public List<Phone> getPhones(int contactId) {
        return contactDao.getPhonesByContactId(contactId);
    }

    @Override
    public Phone getPhoneByContactIdPhoneId(Integer contactId, Integer phoneId) {
        return contactDao.getPhoneByContactIdPhoneId(contactId, phoneId);
    }

    @Override
    public void addPhone(int contactId, Phone phone) {
        contactDao.addPhone(contactId, phone);
    }

    @Override
    public void updatePhone(int contactId, Phone phone) {
        contactDao.updatePhone(contactId, phone);
    }

    @Override
    public void deletePhone(int contactId, int phoneId) {
        contactDao.deletePhone(contactId, getPhoneByContactIdPhoneId(contactId, phoneId));
    }
}
