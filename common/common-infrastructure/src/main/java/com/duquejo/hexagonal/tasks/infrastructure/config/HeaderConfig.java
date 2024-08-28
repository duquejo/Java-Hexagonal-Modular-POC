package com.duquejo.hexagonal.tasks.infrastructure.config;

import com.duquejo.hexagonal.tasks.infrastructure.filter.SecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

    @Bean
    public SecurityFilter headerFilter() {
        return new SecurityFilter();
    }
}
