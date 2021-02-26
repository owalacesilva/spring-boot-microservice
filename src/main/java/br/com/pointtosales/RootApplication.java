/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pointtosales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author wsilva
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class RootApplication extends SpringApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RootApplication.class, args);
    }
}
