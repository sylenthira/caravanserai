package org.caravanserai.demo.dto;

import org.caravanserai.demo.dto.enums.PhoneType;
import org.caravanserai.demo.dto.jaxb.PhoneTypeEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;

/**
 * @author sylenthira
 */
@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {
    public Phone() {}

    private Integer id;
    @XmlElement
    @XmlJavaTypeAdapter(PhoneTypeEnum.class)
    private PhoneType type;
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", type=" + type +
                ", number='" + number + '\'' +
                '}';
    }
}