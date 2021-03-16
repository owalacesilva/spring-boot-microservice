/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pointtosales.controllers;

import br.com.pointtosales.models.Product;
import br.com.pointtosales.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wsilva
 */
@RestController
public class ProductController {
    
    private Logger log = LoggerFactory.getLogger(ProductController.class);
    
    @Autowired
    private ProductRepository productRepository;
    
    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public Iterable<Product> all() {
        return productRepository.findAll();
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public Product create(@RequestBody Product productData) {
        System.out.println("-- Product data received: " + productData.getName());
        
        Product product = new Product();
        product.setName(productData.getName());
        
        return productRepository.save(product);
    }
    
    @RequestMapping(path = "/products/{id}", method = RequestMethod.GET)
    public Product read(@PathVariable(required = true) String id) {
        Product product = productRepository.findById(Long.parseLong(id));
        Assert.notNull(product, "Could not be found product with id = '" + id + "'");
        
        return product;
    }
    
    @RequestMapping(path = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable(required = true) String id, @RequestBody Product productData) {
        log.debug("-- Product data received: " + productData.getName());
        
        Product product = productRepository.findById(Long.parseLong(id));
        product.setName(productData.getName());
        productRepository.save(product);
        
        return ResponseEntity.ok(HttpStatus.OK);
    }
    
    @RequestMapping(path = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(required = true) String id) {
        Product product = productRepository.findById(Long.parseLong(id));
        productRepository.delete(product);
        
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
