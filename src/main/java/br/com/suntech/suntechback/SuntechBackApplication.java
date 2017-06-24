package br.com.suntech.suntechback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"br.com.suntech"})
@EntityScan("br.com.suntech.domain")
@EnableJpaRepositories("br.com.suntech.domain.repository")
@EnableAutoConfiguration
@EnableSwagger2
public class SuntechBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuntechBackApplication.class, args);
	}
	
	@Bean
    public Docket api() { 
        Docket docket = new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("br.com.suntech.controller"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(this.getApiInfo())
          .useDefaultResponseMessages(false);
        
        List<ResponseMessage> listResponseMessage = new ArrayList<>();
        listResponseMessage.add(new ResponseMessageBuilder().code(HttpStatus.NOT_FOUND.value()).message("Usuários não encontrados.").build());
        
        docket.globalResponseMessage(RequestMethod.GET, listResponseMessage);
        docket.enableUrlTemplating(true);
		return docket;                                           
    }

	@SuppressWarnings("deprecation")
	private ApiInfo getApiInfo() {
		ApiInfo apiInfo = new ApiInfo("Listagem de usuários", 
				"Esta documentação descreve as operações da listagem de usuários.", 
				"1.0", 
				"", 
				"dhiego.henrique@hotmail.com", 
				"", 
				"");
		return apiInfo;
	}
}
