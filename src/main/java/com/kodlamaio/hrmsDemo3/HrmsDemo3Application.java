package com.kodlamaio.hrmsDemo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ertuğrul Uyar
 * @LinkedIn www.linkedin.com/in/ertugruluyar
 * @GitHub https://github.com/euyar42
 */

@SpringBootApplication
@EnableSwagger2
public class HrmsDemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(HrmsDemo3Application.class, args);
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.kodlamaio.hrmsDemo3"))               
          .build();                                           
    }
	
//	Now, hit the URL in your web browser and see the Swagger API functionalities.
//	http://localhost:8080/swagger-ui.html

}
