package com.veen.designDesk.configs;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationConfigRepository extends MongoRepository<ConfigModel, String> {
    ConfigModel findByKey(String key);
}
