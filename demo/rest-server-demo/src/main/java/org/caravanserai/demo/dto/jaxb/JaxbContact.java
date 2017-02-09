package org.caravanserai.demo.dto.jaxb;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sylenthira on 09/02/17.
 */
@XmlRootElement(name = "contact")
public class JaxbContact {
    private Integer id;
    private String name;
    private Phones phones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phones getPhones() {
        return phones;
    }

    public void setPhones(Phones phones) {
        this.phones = phones;
    }
}
