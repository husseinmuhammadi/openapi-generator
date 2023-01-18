package com.javastudio.oag.integration;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "server.port=0"
)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = {"test"})
@Retention(RetentionPolicy.RUNTIME)
public @interface IntegrationTest {
}
