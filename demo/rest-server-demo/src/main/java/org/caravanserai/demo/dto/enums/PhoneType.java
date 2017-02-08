package org.caravanserai.demo.dto.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Copyright(C) 2017 MILLENNIUM IT SOFTWARE (PRIVATE) LIMITED
 * All rights reserved.
 * <p/>
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
 * MILLENNIUM IT SOFTWARE (PRIVATE) LIMITED.
 * <p/>
 * This copy of the Source Code is intended for MILLENNIUM IT SOFTWARE (PRIVATE) LIMITED 's internal use only and is
 * intended for view by persons duly authorized by the management of MILLENNIUM IT SOFTWARE (PRIVATE) LIMITED. No
 * part of this file may be reproduced or distributed in any form or by any
 * means without the written approval of the Management of MILLENNIUM IT SOFTWARE (PRIVATE) LIMITED.
 * <p/>
 * Created by Sylenthira Sathashivam on 2/8/2017.
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
