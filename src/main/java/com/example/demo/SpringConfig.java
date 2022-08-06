package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final DataRepository dataRepository;

    public SpringConfig(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Bean
    public DataService dataService(){
        return new DataService(dataRepository);
    }

//    @Bean DataController dataController(){
//        return new DataController(dataService());
//    }
}
