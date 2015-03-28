package com.jgl.company.aplicacionjgl.backend.service;

import com.jgl.company.aplicacionjgl.backend.filters.ResponseCorsFilter;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/webresources")
public class WebApp extends ResourceConfig {

    public WebApp() {
        packages("com.jgl.company.aplicacionjgl.backend.service");
        // register filters
        register(ResponseCorsFilter.class);
    }
}
