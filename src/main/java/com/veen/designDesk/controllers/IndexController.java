package com.veen.designDesk.controllers;

import com.veen.designDesk.configs.ApplicationConfigRepository;
import com.veen.designDesk.configs.ConfigurationClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IndexController {

    @Value("${spring.application.name}")
    private String APPLICATION_NAME;

    @Value("${spring.profiles.active}")
    private String PROFILE;

    @Autowired
    private ConfigurationClientService configurationClientService;



    @GetMapping("/")
    public Map<String, String> index() {
        return Map.of(
                "applicationName", this.APPLICATION_NAME,
                "version", configurationClientService.getConfig("app.msrv.version").getValue() ,
                "description", "SaaS platform for managing graphic design and printing projects",
                "environment", PROFILE.equalsIgnoreCase("dev") ? "Test" : "Production"
        );
    }
}
