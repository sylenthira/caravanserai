package org.caravanserai.demo.web.listener;


import org.caravanserai.demo.dbo.ContactDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author sylenthira
 */
public class AppServletContextListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Servlet Context Initialization...");
        ContactDatabase.setUpData();

        LOGGER.debug("Total Records: {}", ContactDatabase.CONTACT_RECORDS.size());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Context Destroyed");
    }
}
