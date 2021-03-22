package com.example.demo.config;

import com.example.demo.model.Hobbit;
import com.example.demo.service.HobbitService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
public class MyConfig {

    @Bean
    @Profile("fake")
    /*
        @Profile, @Qualifier, @Primary - sposoby na radzenie sobie,
        gdy Spring ma zbyt wielu kandydatów do wstrzyknięcia
     */
    public HobbitService hobbitServiceImpl3(){
        return new HobbitService() {
            @Override
            public List<Hobbit> findAll() {
                return null;
            }

            @Override
            public Hobbit save(Hobbit hobbit) {
                return null;
            }
        };
    }
}
