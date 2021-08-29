package com.halilkose.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.halilkose.myfancypdfinvoices.ApplicationLauncher;
import com.halilkose.myfancypdfinvoices.service.InvoiceService;
import com.halilkose.myfancypdfinvoices.service.UserService;
import org.hibernate.validator.internal.engine.MethodValidationConfiguration;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties",ignoreResourceNotFound = true)
@EnableWebMvc
public class ApplicationConfiguration {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        return new MethodValidationPostProcessor();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
