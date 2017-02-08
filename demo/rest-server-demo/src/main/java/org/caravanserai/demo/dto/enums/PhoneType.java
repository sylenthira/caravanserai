package org.caravanserai.demo.dto.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author sylenthira
 */
public enum PhoneType {
    MOBILE(0), HOME(1), WORK(2);

    private Integer type;

    PhoneType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public static PhoneType valueOf(Integer type) {
        Optional<PhoneType> entry = Arrays.stream(PhoneType.values())
                .filter(phoneType -> phoneType.getType().equals(type))
                .findFirst();

        if (entry.isPresent()) {
            return entry.get();
        } else {
            throw new IllegalArgumentException("Invalid type received");
        }


    }
}
