package com.demo.base.swagger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Vince Yuan
 * @date 01/22/2021
 */
@EnableWebMvc
@Configuration
public class SwaggerWebMvcAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[] { "doc.html" }).addResourceLocations(new String[] { "classpath:/META-INF/resources/" });
        registry.addResourceHandler(new String[] { "/webjars/**" }).addResourceLocations(new String[] { "classpath:/META-INF/resources/webjars/" });
    }
}
