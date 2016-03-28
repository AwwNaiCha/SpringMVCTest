//package com.sjsu.cmpe275.lab2.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.view.UrlBasedViewResolver;
//
///**
// * Created by huimin on 3/27/16.
// */
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"com.sjsu.cmpe275.lab2.controller","com.sjsu.cmpe275.lab2.service"})
//public class ViewConfig extends WebMvcConfigurerAdapter {
//    @Bean
//    public UrlBasedViewResolver setupViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/pages/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }
//
//
//}
