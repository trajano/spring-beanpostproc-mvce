package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class Decorator implements BeanPostProcessor, InitializingBean, Ordered {
    @Value("${spring.kafka.maximumRequestSize:15728640}")
    private int maxRequestSize;

    @Override
    public void afterPropertiesSet() {
        System.out.println(maxRequestSize);
    }

    @Override
    public int getOrder() {
        // return HIGHEST_PRECEDENCE;
        // return LOWEST_PRECEDENCE;
        return 0;
    }
}