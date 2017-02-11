package org.caravanserai.demo.web.resource.impl;

import org.apache.commons.lang3.StringUtils;
import org.caravanserai.demo.dal.entity.Contact;
import org.caravanserai.demo.dal.entity.Phone;
import org.caravanserai.demo.web.jaxb.dto.Contacts;
import org.caravanserai.demo.web.jaxb.dto.JaxbContact;
import org.caravanserai.demo.web.jaxb.dto.JaxbPhone;
import org.caravanserai.demo.web.jaxb.dto.Phones;
import org.caravanserai.demo.service.ContactEntryService;
import org.caravanserai.demo.service.impl.ContactEntryServiceImpl;
import org.caravanserai.demo.web.resource.ContactResource;
import org.caravanserai.rest.server.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sylenthira
 */
@Path(value = ContactResource.CONTEXT_PATH)
public class ContactResourceImpl implements ContactResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactResourceImpl.class);
    private static ContactEntryService contactEntryService;

    @Context
    private HttpServletRequest httpRequest;
    @Context
    private UriInfo uriInfo;

    @PostConstruct
    void init() {
        if (contactEntryService == null) {
            contactEntryService = new ContactEntryServiceImpl();
        }
    }


    @Override
    public Response getContactsInJSON(Integer start, Integer size) {
        return ResponseUtil.getOkSuccess(getContacts(start, size));
    }



    @Override
    public Response getContactsInXML(Integer start, Integer size) {
        List<Contact> contactList = getContacts(start, size);
        Contacts contacts = null;
        if (contactList != null && contactList.size() > 0) {
            contacts = new Contacts();
            List<JaxbContact> jaxbContacts = new ArrayList<>();
            contactList.forEach(contact -> {
                jaxbContacts.add(createJaxbContact(contact));
            });
            contacts.setContactList(jaxbContacts);
        }

        return ResponseUtil.getOkSuccess(contacts);
    }

    @Override
    public Response getContactById(Integer id) {
        Contact contact = contactEntryService.getContactById(id);
        String accept = httpRequest.getHeader(HttpHeaders.ACCEPT);
        if (StringUtils.isNotBlank(accept) && accept.equals(MediaType.APPLICATION_XML)){
            return ResponseUtil.getOkSuccess(createJaxbContact(contact));
        }
        return ResponseUtil.getOkSuccess(contact);
    }

    @Override
    public Response getContactByPhone(String phoneNo) {
        Contact contact = contactEntryService.getContactByPhoneNo(phoneNo);
        String accept = httpRequest.getHeader(HttpHeaders.ACCEPT);
        if (StringUtils.isNotBlank(accept) && accept.equals(MediaType.APPLICATION_XML)){
            return ResponseUtil.getOkSuccess(createJaxbContact(contact));
        }
        return ResponseUtil.getOkSuccess(contact);
    }

    @Override
    public Response addContact(Contact contact) {
        Contact rec = contactEntryService.addContact(contact);
        return ResponseUtil.getCreated(uriInfo.getBaseUri() + "contacts/" + rec.getId());
    }

    @Override
    public Response updateContact(Integer id, Contact contact) {
        contactEntryService.updateContact(id, contact);
        return ResponseUtil.getCreated(uriInfo.getBaseUri() + "contacts/" + id);
    }

    @Override
    public Response deleteContact(Integer id) {
        contactEntryService.deleteContact(id);
        return ResponseUtil.getOkSuccess();
    }

    @Override
    public Response getPhonesByContactId(Integer id) {
        return ResponseUtil.getOkSuccess(contactEntryService.getPhones(id));
    }

    @Override
    public Response getPhoneByContactIdPhoneId(Integer contactId, Integer phoneId) {
        return ResponseUtil.getOkSuccess(contactEntryService.getPhoneByContactIdPhoneId(contactId, phoneId));
    }

    @Override
    public Response addPhone(Integer contactId, Phone phone) {
        Phone rec = contactEntryService.addPhone(contactId, phone);
        return ResponseUtil.getCreated(uriInfo.getBaseUri() + "contacts/" + contactId + "phones/" + rec.getId());
    }

    @Override
    public Response updatePhone(Integer contactId, Integer phoneId, Phone phone) {
        contactEntryService.updatePhone(contactId, phoneId, phone);
        return ResponseUtil.getCreated(uriInfo.getBaseUri() + "contacts/" + contactId + "phones/" + phoneId);
    }

    @Override
    public Response deletePhone(Integer contactId, Integer phoneId) {
        contactEntryService.deletePhone(contactId, phoneId);
        return ResponseUtil.getOkSuccess();
    }


    private JaxbContact createJaxbContact(Contact contact) {
        JaxbContact jaxbContact = new JaxbContact();
        jaxbContact.setId(contact.getId());
        jaxbContact.setName(contact.getName());
        if (contact.getPhones() != null && contact.getPhones().size() > 0) {
            Phones phones = new Phones();
            phones.setPhoneList(new ArrayList<>());
            contact.getPhones().forEach(p-> {
                JaxbPhone jaxbPhone = new JaxbPhone();
                jaxbPhone.setId(p.getId());
                jaxbPhone.setNumber(p.getNumber());
                jaxbPhone.setType(p.getType());
                phones.getPhoneList().add(jaxbPhone);
            });
            jaxbContact.setPhones(phones);
        }
        return jaxbContact;
    }

    private List<Contact> getContacts(Integer start, Integer size) {
        List<Contact> contactList;
        if (start != null && size != null){
            contactList = contactEntryService.getContacts(start, size);
        } else {
            contactList =  contactEntryService.getContacts();
        }
        return contactList;
    }
}
