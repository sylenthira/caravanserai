package org.caravanserai.demo.web.jaxb;

import org.caravanserai.demo.dal.entity.enums.PhoneType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by sylenthira on 09/02/17.
 */
public class PhoneTypeEnum extends XmlAdapter<Integer, PhoneType> {
    @Override
    public PhoneType unmarshal(Integer type) throws Exception {
        return PhoneType.valueOf(type);
    }

    @Override
    public Integer marshal(PhoneType phoneType) throws Exception {
        return phoneType.getType();
    }
}
