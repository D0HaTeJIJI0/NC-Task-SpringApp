package config;

import com.netcracker.travnichev.dao.impl.DefaultSpecializationDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.netcracker.travnichev.service.impl")
public class SpecializationServiceConfig {
    @Bean
    public DefaultSpecializationDao specializationService() {
        return new DefaultSpecializationDao();
    }
}
