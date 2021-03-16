/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pointtosales.interfaces;

import br.com.pointtosales.models.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author wsilva
 */
public interface IProductRepository extends CrudRepository<Product, Long> {
    
    Product findById(long id);
    
    List<Product> findByName(String name);
}
