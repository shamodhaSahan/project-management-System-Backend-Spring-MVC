package lk.ijse.pms.config;

import lk.ijse.pms.service.utill.TechLeadServiceImpl;
import lk.ijse.pms.utill.EntityDtoConvertor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/15/2023
 * Time : 2:18 AM
 */

@Configuration
@Import({JPAConfig.class})
@ComponentScan(basePackageClasses = {TechLeadServiceImpl.class, EntityDtoConvertor.class})
public class WebRootConfig {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
