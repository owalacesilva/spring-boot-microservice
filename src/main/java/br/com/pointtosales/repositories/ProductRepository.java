/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pointtosales.repositories;

import br.com.pointtosales.models.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wsilva
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
    Product findById(long id);
    
    List<Product> findByName(String name);
}
