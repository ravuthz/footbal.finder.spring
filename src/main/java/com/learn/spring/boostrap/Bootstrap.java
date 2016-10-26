package com.learn.spring.boostrap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.learn.spring.configuration.WebConfiguration;

public class Bootstrap implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfiguration.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("springServlet", new DispatcherServlet(context));
		dispatcher.addMapping("/");
	}

}
