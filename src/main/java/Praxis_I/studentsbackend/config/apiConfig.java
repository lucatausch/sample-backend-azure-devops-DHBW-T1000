package Praxis_I.studentsbackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class apiConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT")
                .exposedHeaders("Cache-Control", "no-cache")
                .exposedHeaders("Pragma", "no-cache")
                .allowCredentials(false).maxAge(3600);
    }


}
