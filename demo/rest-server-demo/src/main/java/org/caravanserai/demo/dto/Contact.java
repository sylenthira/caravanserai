package org.caravanserai.demo.dto;

/**
 * Created by sylenthira on 08/02/17.
 */
public class Contact {
    private static Contact ourInstance = new Contact();

    public static Contact getInstance() {
        return ourInstance;
    }

    private Contact() {
    }
}
