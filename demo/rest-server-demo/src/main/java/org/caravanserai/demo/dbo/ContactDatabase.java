package org.caravanserai.demo.dbo;

import org.caravanserai.demo.dto.Contact;
import org.caravanserai.demo.dto.Phone;
import org.caravanserai.demo.dto.enums.PhoneType;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sylenthira
 */
public class ContactDatabase {
    public static final Map<Integer, Contact> CONTACT_RECORDS = new ConcurrentHashMap<>();
    public static final AtomicInteger CONTACT_ID = new AtomicInteger(0);
    public static final AtomicInteger PHONE_ID = new AtomicInteger(0);

    public static void setUpData() {
        Contact contact = new Contact();
        contact.setId(CONTACT_ID.incrementAndGet());
        contact.setName("Sylenthira");

        Set<Phone> phones = new HashSet<>();
        Phone phone;

        phone = new Phone();
        phone.setId(PHONE_ID.incrementAndGet());
        phone.setNumber("+94716066191");
        phone.setType(PhoneType.MOBILE);
        phones.add(phone);

        phone = new Phone();
        phone.setId(PHONE_ID.incrementAndGet());
        phone.setNumber("+94776542166");
        phone.setType(PhoneType.WORK);
        phones.add(phone);

        contact.setPhones(phones);
        CONTACT_RECORDS.put(CONTACT_ID.get(), contact);
    }

}
