package com.gft.Casadeshow.springfox;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer{

	@Bean
	public Docket apiDocket(){
		return new Docket (DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.gft.Casadeshow.Resources"))
					.build()
					.apiInfo(apiInfo())
					.tags(new Tag("Casas", "Gerencia as casas"))
					.tags(new Tag("Eventos", "Gerencia os eventos"))
					.tags(new Tag("Usuários", "Gerencia os usuários"))
					.tags(new Tag("Vendas", "Gerencia as vendas"));
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("CasaShowAPI")
				.description("API aberta para acessar informações do projeto MVC.")
				.version("1.0")
				.contact(new Contact("Gabrielli Jamas","https://www.gft.com/br/pt/index/","gjamas22@gmail.com"))
				.build();
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
