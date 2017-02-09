package org.caravanserai.demo.dto.jaxb;

import org.caravanserai.demo.dto.Phone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author sylenthira
 */
@XmlRootElement(name = "phones")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phones {

    @XmlElement(name = "phone")
    private List<Phone> phoneList;

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}
