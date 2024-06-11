package com.exampleAPINeoris.APINeoris.controller;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Component
public class DataLoader {

    @Bean
    CommandLineRunner loadData(DataSource dataSource) {
        return args -> {
            ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false, "UTF-8", new ClassPathResource("data.sql"));
            resourceDatabasePopulator.execute(dataSource);
        };
    }
}
