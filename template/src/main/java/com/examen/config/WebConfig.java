package com.examen.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The Class WebConfig.
 * 
 */
@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * Adds the resource handlers.
	 *
	 * @param registry the registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/notFound").setViewName("forward:/notFound/");

		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizerNotFound() {
		return (factory) -> factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notFound"));
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizerForbidden() {
		return (factory) -> factory.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/notFound"));
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizerServerError() {
		return (factory) -> factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/notFound"));
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizerBadRequest() {
		return (factory) -> factory.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/notFound"));
	}

}
