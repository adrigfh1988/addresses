package config;

import org.justonemore.MainSpringBootForIntegrationTest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@ComponentScan("org.justonemore")
@ContextConfiguration(classes = MainSpringBootForIntegrationTest.class)
public class IntegrationTestSpringContext {

}