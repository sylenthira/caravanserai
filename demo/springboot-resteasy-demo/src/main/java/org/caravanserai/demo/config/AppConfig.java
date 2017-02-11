package org.caravanserai.demo.config;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Sylenthira on 2/11/2017.
 */
@Component
@ApplicationPath("/api")
public class AppConfig extends Application {
}
