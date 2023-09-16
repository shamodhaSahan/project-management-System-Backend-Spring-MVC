package lk.ijse.pms.config;

import lk.ijse.pms.api.TechLeadController;
import lk.ijse.pms.exeception.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/15/2023
 * Time : 2:18 AM
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {TechLeadController.class, GlobalExceptionHandler.class})
public class WebAppConfig {
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(5097152);
        return resolver;
    }
}
