package com.veen.designDesk.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationClientService {

    @Autowired
    private ApplicationConfigRepository applicationConfigRepository;

    public ConfigModel getConfig(String keyName){
        return applicationConfigRepository.findByKey(keyName);
    }
}
