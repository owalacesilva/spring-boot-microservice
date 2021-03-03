/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pointtosales;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author wsilva
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class RootApplication extends SpringApplication {
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RootApplication.class, args);
        
        String[] beansNames = context.getBeanDefinitionNames();
        Arrays.sort(beansNames);
        for (String name : beansNames) {
            // System.out.println(name);
        }
    }
}
