package org.afrinnov.rnd.afrinnovdgs;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import graphql.com.google.common.base.Function;
import graphql.execution.preparsed.PreparsedDocumentEntry;
import graphql.execution.preparsed.PreparsedDocumentProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class AfrinnovDgsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfrinnovDgsApplication.class, args);
    }

    @Configuration
    static class PreparsedDocumentProviderConfig {
        private final Cache<String, PreparsedDocumentEntry> cache = Caffeine.newBuilder().maximumSize(250)
                .expireAfterAccess(5, TimeUnit.MINUTES).recordStats().build();

        @Bean
        public PreparsedDocumentProvider preparsedDocumentProvider() {
            return (executionInput, parseAndValidateFunction) -> {
                Function<String, PreparsedDocumentEntry> mapCompute = key -> parseAndValidateFunction.apply(executionInput);

                return cache.get(executionInput.getQuery(), mapCompute);
            };
        }
    }
}
