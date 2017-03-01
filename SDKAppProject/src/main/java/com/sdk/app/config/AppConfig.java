package com.sdk.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.sdk.app")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public VelocityConfigurer velocityConfig(){
		VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
		velocityConfigurer.setResourceLoaderPath("/WEB-INF/app/");
	    return velocityConfigurer;
	}

	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        VelocityViewResolver viewResolver = new VelocityViewResolver();
         
        viewResolver.setViewClass(VelocityView.class);
        viewResolver.setCache(true);
        viewResolver.setPrefix("/WEB-INF/app/");
        viewResolver.setSuffix(".html");
        viewResolver.setExposeSpringMacroHelpers(true);
 
        registry.viewResolver(viewResolver);
    }
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
