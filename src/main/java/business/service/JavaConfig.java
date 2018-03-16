package business.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public Testfunction getTestone(){
        return new Testfunction();
    }

    @Bean
    public UseFunctionService getUserone(){
        UseFunctionService useFunctionService=new UseFunctionService();
        useFunctionService.setTestfunction(getTestone());
        return useFunctionService;
    }
}
