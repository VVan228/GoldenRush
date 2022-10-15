package hack.polyus.goldenrush.security;

import hack.polyus.goldenrush.services.interfaces.ScheduleGenerator;
import hack.polyus.goldenrush.services.ScheduleGeneratorImpl;
import hack.polyus.goldenrush.services.interfaces.TransportDataService;
import hack.polyus.goldenrush.services.TransportDataServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hack.polyus.goldenrush")
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST");
    }


    @Bean
    public TransportDataService transportDataService(){
        return new TransportDataServiceImpl();
    }

    @Bean
    public ScheduleGenerator scheduleGenerator(){return new ScheduleGeneratorImpl();
    }
}
